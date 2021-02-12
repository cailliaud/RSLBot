package fr.cailliaud.rsl.chatbot.domain.command;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@RequiredArgsConstructor
public class SimpleUrlCommand implements ICommandAnswer {

  private final String url;

  @Override
  public void publishAnswer(MessageReceivedEvent event, Object... args) {
    MessageChannel channel = event.getChannel();
    channel.sendMessage(url).queue();
  }
}
