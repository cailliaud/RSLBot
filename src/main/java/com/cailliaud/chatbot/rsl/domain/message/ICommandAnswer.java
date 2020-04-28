package com.cailliaud.chatbot.rsl.domain.message;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ICommandAnswer {

    void publishAnswer(MessageReceivedEvent event, Object... args);


}
