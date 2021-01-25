package com.cailliaud.rsl.chatbot.domain;

import com.cailliaud.rsl.chatbot.domain.command.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum RslCommand {
  EXPERIENCE(
      "!raid-xp",
      new ExperienceCommand(),
      "Afficher les informations pour obtenir au mieux de l'expérience et de l'argent",
      "!raid-xp",
      false),
  AYUMILOVE(
      "!raid-ayu",
      new HeroAyumiloveCommand(),
      "[EN][AYUMILOVE] Afficher les informations sur un héros du jeu",
      "!raid-ayumilove Galek",
      false),
  RAID("!raid", new DeprecatedCommand(), null, null, true),
  ENGLISH(
      "!raid-en",
      new DeprecatedCommand(),
      "Identifique à !raid-ayumilove",
      "!raid-en Galek",
      false),
  ALUCARE(
      "!raid-alu",
      new HeroAlucareCommand(),
      "[FR][ALUCARE] Afficher les informations sur un héros du jeu",
      "!raid-alucare Galek",
      false),
  FRENCH("!raid-fr", new DeprecatedCommand(), "Identique à !raid-alucare", "!raid-fr Galek", false),
  TIX(
      "!raid-tix",
      new HeroTixCommand(),
      "[FR][Mister TIX] Afficher les informations sur un héros du jeu",
      "!raid-tix Galek",
      false),
  VDG(
      "!raid-vdg",
      new HeroVdgCommand(),
      "[FR][VDG] Afficher les informations sur un héros du jeu",
      "!raid-vdg Galek",
      false),
  MASTERY(
      "!raid-maitrise",
      new MasteryCommand(),
      "Afficher les informations sur les maitrises pour un héros du jeu",
      "!raid-maitrise Galek",
      false),
  TIER_LIST(
      "!raid-tier",
      new TierListCommand(),
      "Afficher les différentes tier list du jeu.",
      "!raid-tier",
      false),
  MINE(
      "!raid-mine",
      new MineCommand(),
      "Afficher les informations sur la mine.",
      "!raid-mine",
      false),
  INFO(
      "!raid-info",
      new InformationCommand(),
      "Afficher les principales sources d'information sur le jeu.",
      "!raid-info",
      false),
  HELP("!raid-help", new HelpCommand(), "Afficher les commandes !raid", "!raid-help", false),
  UNKNOWN("", new UnknownCommand(), "Commande inconnue", "!raid-12345", false),
  UNICORN("!raid-unicorn", new UnicornCommand(), null, null, true),
  ORI("!raid-ori", new OriCommand(), null, null, true);

  private String key;
  private ICommandAnswer commandAnswer;
  private String description;
  private String example;
  private boolean isHidden;

  public static RslCommand fromString(String text) {
    Optional<RslCommand> optCommand =
        Arrays.stream(RslCommand.values()).filter(cmd -> cmd.key.equals(text)).findFirst();

    return optCommand.orElse(UNKNOWN);
  }
}
