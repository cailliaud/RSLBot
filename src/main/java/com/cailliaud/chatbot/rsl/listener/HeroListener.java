package com.cailliaud.chatbot.rsl.listener;

import com.cailliaud.chatbot.rsl.domain.HeroDto;
import com.cailliaud.chatbot.rsl.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class HeroListener extends ListenerAdapter {

    private static final String AYUMILOVE = "Ayumilove";
    private HeroService heroService;


    public HeroListener(HeroService heroService) {
        super();
        this.heroService = heroService;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        if (message.getContentRaw().startsWith("!raid")) {
            String[] commands = message.getContentRaw().split(" ", 2);
            if (commands.length == 1) {
                manageRaidRequest(event, commands[0]);
            } else if (commands.length >= 2) {
                manageRaidRequest(event, commands[0], commands[1]);
            } else {
                sendDefaultMessage(event);
            }
        }
    }

    private void manageRaidRequest(MessageReceivedEvent event, String command) {
        MessageChannel channel = event.getChannel();
        MessageEmbed msgEmbedded;

        switch (command) {
            case "!raid-pex":
                msgEmbedded = new EmbedBuilder()
                        .setColor(Color.BLUE)
                        .setAuthor(AYUMILOVE, "https://ayumilove.net/raid-shadow-legends-campaign-xp-silver-guide/")
                        .setTitle("Raid Shadow Legends : Expérience et Argent en Campagne", "https://ayumilove.net/raid-shadow-legends-campaign-xp-silver-guide/")
                        .setDescription("Tableau listant l'ensemble des taux d'expérience et d'argent récupérables par zone de la campagne.")
                        .setFooter("Information récupérer par votre humble serviteur.")
                        .build();
                channel.sendMessage(msgEmbedded).queue();
                break;
            default:
                sendDefaultMessage(event);
        }
    }

    private void manageRaidRequest(MessageReceivedEvent event, String command, String argument) {
        MessageChannel channel = event.getChannel();

        HeroDto hero = heroService.findHero(argument);

        if (hero == null) {
            List<HeroDto> possibleHeroes = heroService.findSimilarHeroes(argument);

            String values = possibleHeroes.stream().map(HeroDto::getName).collect(Collectors.joining(", "));

            String message = event.getAuthor().getAsMention() + "\n"
                    + "> " + event.getMessage().getContentRaw() + "\n"
                    + "Je ne connais pas le héros que tu me demandes.\n";

            if (!values.isEmpty()) {
                message += "Peut-être est-ce l'un de ceci : " + values;
            }
            channel.sendMessage(message).queue();
            return;
        }

        MessageEmbed msgEmbedded;

        switch (command.toLowerCase()) {
            case "!raid-maitrise":
                msgEmbedded = new EmbedBuilder()
                        .setColor(Color.RED)
                        .setAuthor(AYUMILOVE, hero.getGuideUrl(), hero.getIconUrl())
                        .setTitle(hero.getName(), hero.getGuideUrl())
                        .setDescription(hero.getName() + " | Raid Shadow Legends Guide Maîtrise")
                        .setImage(hero.getMasteryUrl())
                        .setFooter("Informations récupérées par vos humbles serviteurs Ori, Orokir, Moahh, Gafi, Tampax et Yaszawel.")
                        .build();
                channel.sendMessage(msgEmbedded).queue();
                break;
            case "!raid":
                msgEmbedded = new EmbedBuilder()
                        .setColor(Color.RED)
                        .setAuthor(AYUMILOVE, hero.getGuideUrl(), hero.getIconUrl())
                        .setTitle(hero.getName(), hero.getGuideUrl())
                        .setDescription(hero.getName() + " | Raid Shadow Legends Guide Maîtrise")
                        .setImage(hero.getImageUrl())
                        .setFooter("Informations récupérées par vos humbles serviteurs Ori, Orokir, Moahh, Gafi, Tampax et Yaszawel.")
                        .build();
                channel.sendMessage(msgEmbedded).queue();
                break;
            default:
                sendDefaultMessage(event);

        }
    }

    private void sendDefaultMessage(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        channel.sendMessage(event.getAuthor().getAsMention() + "\n"
                + "> " + event.getMessage().getContentRaw() + "\n"
                + "Tu n'as pas bien formulé la requête, utilise !raid-help pour obtenir les commandes").queue();
    }
}
