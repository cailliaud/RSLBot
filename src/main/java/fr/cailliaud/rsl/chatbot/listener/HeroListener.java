package fr.cailliaud.rsl.chatbot.listener;

import fr.cailliaud.rsl.chatbot.domain.RslCommand;
import fr.cailliaud.rsl.chatbot.domain.command.ICommandAnswer;
import fr.cailliaud.rsl.chatbot.entity.HeroEntity;
import fr.cailliaud.rsl.chatbot.service.HeroService;
import fr.cailliaud.rsl.chatbot.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class HeroListener extends ListenerAdapter {

  private final HeroService heroService;

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

  @Override
  public void onSlashCommand(SlashCommandEvent event) {
    if (!event.getName().startsWith("raid")) return;

    List<OptionMapping> options = event.getOptionsByName("héros");

    OptionMapping herosOption = options.get(0);

    HeroEntity hero = heroService.findHero(herosOption.getAsString());
    if (hero == null) {
      event.reply("J'ai pas trouvé de héros " + herosOption.getAsString()).queue();
    } else {
      event
          .reply(String.format(Utils.GUIDE_URL, Utils.serializeName(hero.getNomAnglais(), "-")))
          .queue(); // Queue both reply and
    }
  }

  private void performCommandWithArguments(
      MessageReceivedEvent event, RslCommand command, String arg) {
    MessageChannel channel = event.getChannel();
    ICommandAnswer commandAnswer = command.getCommandAnswer();
    switch (command) {
      case ALUCARE:
      case AYUMILOVE:
      case TIX:
      case INTELERIA:
      case MASTERY:
        HeroEntity hero = heroService.findHero(arg);
        if (hero == null) {
          List<HeroEntity> possibleHeroes = heroService.findPossibleHeroes(arg);

          String values =
              possibleHeroes.stream()
                  .map(HeroEntity::getNomFrancais)
                  .collect(Collectors.joining(", "));

          String answer =
              event.getAuthor().getAsMention()
                  + "\n"
                  + "> "
                  + event.getMessage().getContentRaw()
                  + "\n"
                  + "Je ne connais pas le héros que tu me demandes.\n";

          if (!values.isEmpty()) {
            answer += "Peut-être est-ce l'un de ceci : " + values;
          }
          channel.sendMessage(answer).queue();
        } else {
          commandAnswer.publishAnswer(event, hero);
        }
        break;
      default:
        commandAnswer.publishAnswer(event, arg);
    }
  }
}
