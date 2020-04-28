package com.cailliaud.chatbot.rsl.domain.message;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static com.cailliaud.chatbot.rsl.domain.Utils.AYUMILOVE;

public class TierListCommand implements ICommandAnswer {
    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        MessageEmbed msgEmbedded;

        msgEmbedded = new EmbedBuilder()
                .setColor(Color.YELLOW)
                .setTitle("Raid Shadow Legends : Tier list")
                .addField(AYUMILOVE, "Lien vers ayumilove tier list : https://ayumilove.net/raid-shadow-legends-list-of-champions-by-rarity/", false)
                .addField("RAID-CODEX", "Lien vers raid-codex tier list : https://raid-codex.com/tier-list/best-champions-overall/", false)
                .addField("Alucare", "Lien vers Alucare tier list : https://www.alucare.fr/wiki/guide-raid-shadow-legend/liste-des-champions-de-raid-shadow-legends-par-rarete-et-force/", false)
                .setDescription("Ensemble des sites fournissant des tier list.")
                .setImage("https://raid-codex.com/tier-list/best-champions-overall/Arena_LoadingScreen_1920x1080-1024x576.jpg")
                .setFooter("Information récupérer par votre humble serviteur.")
                .build();
        channel.sendMessage(msgEmbedded).queue();
    }
}
