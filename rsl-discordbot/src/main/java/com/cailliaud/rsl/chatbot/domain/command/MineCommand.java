package com.cailliaud.rsl.chatbot.domain.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static com.cailliaud.rsl.chatbot.utils.Utils.*;

public class MineCommand implements ICommandAnswer {

    private static final String GEMME_INFO = "Coût : %s gems\nProd : 1 gem/%s\nCapacité: %s\nTemps complet : %s";

    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        MessageEmbed msgEmbedded;

        msgEmbedded = new EmbedBuilder()
                .setColor(Color.RED)
                .setTitle("La mine sur Raid Shadow")
                .setAuthor(CAILLIAUD, "https://github.com/cailliaud", "https://cdn.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_197,h_192/https://www.alucare.fr/wp-content/uploads/2020/01/image-de-la-mine.jpg")
                .addField("Level 1", String.format(GEMME_INFO, "500", "4h48", "5", "1j 2min"), true)
                .addField("Level 2", String.format(GEMME_INFO, "500", "2h23", "10", "23h16"), true)
                .addField("Level 3", String.format(GEMME_INFO, "500", "1h36", "15", "1j"), true)
                .addField("Description", "La mine produit en continue des gemmes gratuitements.", true)
                .addField("Est-ce rentable ?", "Oui : si vous comptez jouer longtemps au jeu ( plus de 3 mois pour rentabiliser)\nNon : si vous jouez momentanément (utilisez vos gemmes dans la boutique).", false)
                .addField(ALUCARE, "Lien vers Alucare : https://www.alucare.fr/wiki/guide-raid-shadow-legend/la-mine-de-gemmes-sur-raid-shadow-legend/", false)
                .addField(WIKI_FANDOM, "Lien vers wiki : https://raid-shadow-legends.fandom.com/wiki/Mine", false)
                .setImage("https://cdn.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_1365/https://www.alucare.fr/wp-content/uploads/2020/01/Mine-de-gemmes.jpg")
                .setFooter("Information récupérer par votre humble serviteur.")
                .build();
        channel.sendMessage(msgEmbedded).queue();
    }
}
