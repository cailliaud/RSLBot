package com.cailliaud.chatbot.rsl.listener;

import com.cailliaud.chatbot.rsl.domain.Hero;
import com.cailliaud.chatbot.rsl.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
@Slf4j
public class HeroListener extends ListenerAdapter {

    private HeroService heroMapper;

    public HeroListener(HeroService heroMapper) {
        super();
        this.heroMapper = heroMapper;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String content = message.getContentRaw();
        Guild guild = message.getGuild();


        if (message.getContentRaw().startsWith("!raid")) {
            Optional<String> optionalHeroName = extractHeroName(message.getContentRaw());
            if (optionalHeroName.isPresent()) {

                String heroName = optionalHeroName.get();

                Hero hero = new Hero(heroName);

                MessageEmbed msgEmbedded;
                if (message.getContentRaw().startsWith("!raid-maitrise")) {
                    msgEmbedded = new EmbedBuilder()
                            .setColor(Color.RED)
                            .setAuthor("Ayumilove", hero.getGuideUrl(), hero.getIconUrl())
                            .setTitle(hero.getName(), hero.getGuideUrl())
                            .setDescription(hero.getName() + " | Raid Shadow Legends Guide Maîtrise")
                            .setImage(hero.getMasteryUrl())
                            .setFooter("Information récupérer par votre humble serviteur.")
                            .build();
                } else {
                    msgEmbedded = new EmbedBuilder()
                            .setColor(Color.RED)
                            .setAuthor("Ayumilove", hero.getGuideUrl(), hero.getIconUrl())
                            .setTitle(hero.getName(), hero.getGuideUrl())
                            .setDescription(hero.getName() + " | Raid Shadow Legends Guide Maîtrise")
                            .setImage(hero.getImageUrl())
                            .setFooter("Information récupérer par votre humble serviteur.")
                            .build();
                }


                channel.sendMessage(msgEmbedded).queue();


            } else {
                channel.sendMessage(event.getAuthor().getAsMention() + "\n"
                        + "> " + event.getMessage().getContentRaw() + "\n"
                        + "Je ne connais pas le héros demandé, je suis encore en formation !").queue();
            }
        }

    }

    private Optional<String> extractHeroName(String contentRaw) {

        String[] commands = contentRaw.split(" ", 2);
        if (commands.length < 2) {
            return Optional.empty();
        } else {
            String heroData = heroMapper.findHero(commands[1].replace(" ", ""));
            return Optional.ofNullable(heroData);
        }

    }
}
