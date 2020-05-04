package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class SimpleCommand implements ICommandAnswer {

    private String url;

    public SimpleCommand(String url) {
        this.url = url;
    }

    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        channel.sendMessage(url).queue();
    }
}
