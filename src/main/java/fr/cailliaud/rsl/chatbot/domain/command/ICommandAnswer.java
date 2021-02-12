package fr.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ICommandAnswer {

  void publishAnswer(MessageReceivedEvent event, Object... args);
}
