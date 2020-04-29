package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static com.cailliaud.rsl.chatbot.utils.Utils.AYUMILOVE;

public class ExperienceCommand implements ICommandAnswer {

    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        MessageEmbed msgEmbedded;

        msgEmbedded = new EmbedBuilder()
                .setColor(Color.BLUE)
                .setAuthor(AYUMILOVE, "https://ayumilove.net/raid-shadow-legends-campaign-xp-silver-guide/")
                .setTitle("Raid Shadow Legends : Expérience et Argent en Campagne", "https://ayumilove.net/raid-shadow-legends-campaign-xp-silver-guide/")
                .setDescription("Tableau listant l'ensemble des taux d'expérience et d'argent récupérables par zone de la campagne.")
                .setFooter("Information récupérer par votre humble serviteur.")
                .build();
        channel.sendMessage(msgEmbedded).queue();
    }
}
