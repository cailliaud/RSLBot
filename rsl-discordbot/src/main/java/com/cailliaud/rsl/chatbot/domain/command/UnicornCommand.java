package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class UnicornCommand implements ICommandAnswer {
    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        MessageEmbed msgEmbedded;

        msgEmbedded = new EmbedBuilder()
                .setColor(Color.PINK)
                .setAuthor("Unicorn", "https://unicorn.com/", "https://cdn2.iconfinder.com/data/icons/fashion-44/300/unicorn-fashion-accesories-clothing-512.png")
                .setTitle("Magnifique est la licorne !")
                .setDescription("Les licornes se nourrissent exclusivement d'arc-en-ciel.\n Elles font des caca papillons.")
                .setImage("https://images-eu.ssl-images-amazon.com/images/I/81f-ZMKw1%2BL.png")
                .setFooter("UNICORN POWERRRRR")
                .build();
        channel.sendMessage(msgEmbedded).queue();
    }
}
