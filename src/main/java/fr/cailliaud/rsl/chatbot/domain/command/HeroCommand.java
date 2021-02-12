package fr.cailliaud.rsl.chatbot.domain.command;

import fr.cailliaud.rsl.chatbot.entity.HeroEntity;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.util.StringUtils;

import java.util.function.Function;

@RequiredArgsConstructor
public class HeroCommand implements ICommandAnswer {

  private final Function<HeroEntity, String> heroFunction;
  private final String pasDispo;

  @Override
  public void publishAnswer(MessageReceivedEvent event, Object... args) {
    MessageChannel channel = event.getChannel();
    HeroEntity hero = (HeroEntity) args[0];
    if (StringUtils.hasText(heroFunction.apply(hero))) {
      channel.sendMessage(heroFunction.apply(hero).trim()).queue();
    } else {
      channel.sendMessage(pasDispo).queue();
    }
  }
}
