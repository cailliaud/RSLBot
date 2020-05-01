package com.cailliaud.rsl.chatbot.domain;

import com.cailliaud.rsl.chatbot.domain.command.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum RslCommand {

    EXPERIENCE("!raid-xp", new ExperienceCommand(), "Afficher les informations pour obtenir au mieux de l'expérience et de l'argent", "!raid-xp"),
    HERO("!raid", new HeroCommand(), "Afficher les informations sur un héros du jeu", "!raid Galek"),
    MASTERY("!raid-maitrise", new MasteryCommand(), "Afficher les informations sur les maitrises pour un héros du jeu", "!raid-maitrise Galek"),
    TIER_LIST("!raid-tier", new TierListCommand(), "Afficher les différentes tier list du jeu.", "!raid-tier"),
    MINE("!raid-mine", new MineCommand(), "Afficher les informations sur la mine.", "!raid-mine"),
    INFO("!raid-info", new InformationCommand(), "Afficher les principales sources d'information sur le jeu.", "!raid-info"),
    HELP("!raid-help", new HelpCommand(), "Afficher les commandes !raid", "!raid-help"),
    UNKNOWN("", new UnknownCommand(), "Commande inconnue", "!raid-12345");


    private String key;
    private ICommandAnswer commandAnswer;
    private String description;
    private String example;

    public static RslCommand fromString(String text) {
        Optional<RslCommand> optCommand = Arrays.stream(RslCommand.values())
                .filter(cmd -> cmd.key.equals(text))
                .findFirst();

        return optCommand.orElse(UNKNOWN);
    }


}
