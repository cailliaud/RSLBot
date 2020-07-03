package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DeprecatedCommand implements ICommandAnswer {
    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        channel.sendMessage(event.getAuthor().getAsMention() + "\n"
                + "> " + event.getMessage().getContentRaw() + "\n"
                + "La commande que tu as utilisé n'est plus disponible. !raid-help pour obtenir les nouvelles commandes la remplaçant !").queue();
    }
}
