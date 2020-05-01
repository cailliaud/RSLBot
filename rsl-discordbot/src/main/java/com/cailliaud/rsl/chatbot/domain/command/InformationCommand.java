package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static com.cailliaud.rsl.chatbot.utils.Utils.*;

public class InformationCommand implements ICommandAnswer {
    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        MessageEmbed msgEmbedded;

        msgEmbedded = new EmbedBuilder()
                .setColor(Color.YELLOW)
                .setTitle("Annuaire des sites Raid Shadow Legends")
                .addField(AYUMILOVE, "https://ayumilove.net/raid-shadow-legends-guide/", false)
                .addField(RAID_CODEX, "https://raid-codex.com/", false)
                .addField(ALUCARE, "https://www.alucare.fr/wiki/guide-raid-shadow-legend/", false)
                .addField(WIKI_FANDOM, "https://raid-shadow-legends.fandom.com/wiki/Raid:_Shadow_Legends_Wiki", false)
                .setDescription("Ensemble des sites fournissant des informations sur le jeu.")
                .setFooter("Information récupérer par votre humble serviteur.")
                .build();
        channel.sendMessage(msgEmbedded).queue();
    }
}
