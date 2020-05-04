package com.cailliaud.rsl.chatbot.domain;

import com.cailliaud.rsl.chatbot.domain.command.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum RslCommand {

    HERO("!raid", new HeroCommand(), "Afficher les informations sur un héros du jeu", "!raid Galek", false),
    BUFF("!raid-buff", new SimpleCommand("https://www.alucare.fr/wiki/guide-raid-shadow-legend/liste-des-buffs-et-debuffs-de-raid-shadow-legend/"), "Afficher les buffs et debuffs disponibles dans le jeu", "!raid-buff", false),
    MASTERY("!raid-maitrise", new SimpleCommand("https://www.alucare.fr/wiki/guide-raid-shadow-legend/guide-raid-shadow-legend-sur-les-maitrises/"), "Afficher les maitrises du jeu", "!raid-maitrise", false),
    ARTIFACT("!raid-artefact", new SimpleCommand("https://www.alucare.fr/wiki/guide-raid-shadow-legend/artefact-raid-shadow-legend/"), "Afficher les artefacts du jeu", "!raid-artefact", false),
    HELP("!raid-help", new HelpCommand(), "Afficher les commandes !raid", "!raid-help", false),
    UNKNOWN("", new UnknownCommand(), "Commande inconnue", "!raid-12345", false);


    private String key;
    private ICommandAnswer commandAnswer;
    private String description;
    private String example;
    private boolean isHidden;

    public static RslCommand fromString(String text) {
        Optional<RslCommand> optCommand = Arrays.stream(RslCommand.values())
                .filter(cmd -> cmd.key.equals(text))
                .findFirst();

        return optCommand.orElse(UNKNOWN);
    }


}
