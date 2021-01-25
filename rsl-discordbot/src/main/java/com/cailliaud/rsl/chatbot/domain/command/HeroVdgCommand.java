package com.cailliaud.rsl.chatbot.domain.command;

import com.cailliaud.rsl.chatbot.domain.HeroDto;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.util.StringUtils;

public class HeroVdgCommand implements ICommandAnswer {

  @Override
  public void publishAnswer(MessageReceivedEvent event, Object... args) {
    MessageChannel channel = event.getChannel();
    HeroDto hero = (HeroDto) args[0];

    if (StringUtils.hasText(hero.getVdgUrl())) {
      channel.sendMessage(hero.getVdgUrl()).queue();
    } else {
      channel
          .sendMessage(
              String.format("VDG ne propose pas encore de guide pour le héro %s.", hero.getName()))
          .queue();
    }
  }
}
