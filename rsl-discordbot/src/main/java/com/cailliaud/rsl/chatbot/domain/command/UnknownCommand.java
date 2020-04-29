package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class UnknownCommand implements ICommandAnswer {
    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        channel.sendMessage(event.getAuthor().getAsMention() + "\n"
                + "> " + event.getMessage().getContentRaw() + "\n"
                + "Tu n'as pas bien formulé la requête, utilise !raid-help pour obtenir les commandes").queue();
    }
}
