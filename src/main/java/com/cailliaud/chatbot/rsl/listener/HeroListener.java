package com.cailliaud.chatbot.rsl.listener;

import com.cailliaud.chatbot.rsl.domain.HeroDto;
import com.cailliaud.chatbot.rsl.domain.RslCommand;
import com.cailliaud.chatbot.rsl.domain.message.ICommandAnswer;
import com.cailliaud.chatbot.rsl.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class HeroListener extends ListenerAdapter {

    private HeroService heroService;

    public HeroListener(HeroService heroService) {
        super();
        this.heroService = heroService;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();

        if (message.getContentRaw().startsWith("!raid")) {
            String[] commands = message.getContentRaw().split(" ", 2);

            String cmd = commands[0].toLowerCase();
            RslCommand command = RslCommand.fromString(cmd);

            if (commands.length >= 2) {
                performCommandWithArguments(event, command, commands[1]);
            } else {
                command.getCommandAnswer().publishAnswer(event);
            }
        }
    }

    private void performCommandWithArguments(MessageReceivedEvent event, RslCommand command, String arg) {
        MessageChannel channel = event.getChannel();
        ICommandAnswer commandAnswer = command.getCommandAnswer();
        if (command.equals(RslCommand.MASTERY) || command.equals(RslCommand.HERO)) {

            HeroDto hero = heroService.findHero(arg);
            if (hero == null) {
                List<HeroDto> possibleHeroes = heroService.findSimilarHeroes(arg);

                String values = possibleHeroes.stream().map(HeroDto::getName).collect(Collectors.joining(", "));

                String answer = event.getAuthor().getAsMention() + "\n"
                        + "> " + event.getMessage().getContentRaw() + "\n"
                        + "Je ne connais pas le héros que tu me demandes.\n";

                if (!values.isEmpty()) {
                    answer += "Peut-être est-ce l'un de ceci : " + values;
                }
                channel.sendMessage(answer).queue();
            } else {
                commandAnswer.publishAnswer(event, hero);
            }
        } else {
            commandAnswer.publishAnswer(event, arg);
        }
    }


}
