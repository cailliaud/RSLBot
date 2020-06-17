package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class OriCommand implements ICommandAnswer {

    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        MessageEmbed msgEmbedded;

        msgEmbedded = new EmbedBuilder()
                .setColor(Color.DARK_GRAY)
                .setAuthor("Ori", "https://www.twitch.tv/nealhs", "https://static-cdn.jtvnw.net/jtv_user_pictures/nealhs-profile_image-3b54edae614fdd2b-70x70.jpeg")
                .setTitle("Elle est la seule et unique beta testeuse du chatbot !")
                .setDescription("Desormais membre des administrateurs.\n Elle ne fera pas de quartier aux trouble-fêtes.")
                .setImage("http://image.jeuxvideo.com/images/jaquettes/00053122/jaquette-ori-and-the-blind-forest-pc-cover-avant-g-1404462581.jpg")
                .setFooter("ORI la beta testeuse")
                .build();
        channel.sendMessage(msgEmbedded).queue();
    }
}
