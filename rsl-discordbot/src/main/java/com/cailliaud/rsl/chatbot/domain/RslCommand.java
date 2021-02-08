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
      "!raid-xp-old",
      new ExperienceCommand(),
      "Afficher les informations pour obtenir au mieux de l'expérience et de l'argent",
      "!raid-xp-old",
      false),
  AYUMILOVE(
      "!raid-ayu",
      new HeroAyumiloveCommand(),
      "[EN][AYUMILOVE] Afficher les informations sur un héros du jeu",
      "!raid-ayu Galek",
      false),
  ALUCARE(
      "!raid-alu",
      new HeroAlucareCommand(),
      "[FR][ALUCARE] Afficher les informations sur un héros du jeu",
      "!raid-alu Galek",
      false),

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
  ORI("!raid-ori", new OriCommand(), null, null, true),
  RAID("!raid", new DeprecatedCommand(), null, null, true),
  ENGLISH(
      "!raid-en", new DeprecatedCommand(), "Identifique à !raid-ayumilove", "!raid-en Galek", true),
  FRENCH("!raid-fr", new DeprecatedCommand(), "Identique à !raid-alucare", "!raid-fr Galek", true),
  RAID_BUFF(
      "!raid-buff",
      new SimpleUrlCommand("https://www.inteleria.com/buffs-and-debuffs-list/"),
      "Afficher les info buff",
      "!raid-buff",
      false),
  RAID_BDC(
      "!raid-bdc",
      new SimpleUrlCommand("https://www.inteleria.com/clan-boss-top-champions/"),
      "Afficher les info bdc",
      "!raid-bdc",
      false),
  RAID_SPEED_TUNE(
      "!raid-speedtune",
      new SimpleUrlCommand("https://www.deadwoodjedi.com/speed-tunes-9"),
      "Afficher les info bdc speedtunes",
      "!raid-speedtune",
      false),
  RAID_CBC_CALCULATOR(
      "!raid-cbcalculator",
      new SimpleUrlCommand("https://deadwoodjedi.info/cb"),
      "Accès outil cbc calculator",
      "!raid-cbcalculator",
      false),
  RAID_EXP(
      "!raid-exp",
      new SimpleUrlCommand(
          "https://docs.google.com/spreadsheets/d/1invzrqmdYSCBwJ4tY6YjUhsrDZkf1_j6B9C8EDPrGhk/edit#gid=623907573"),
      "Accès gdoc experience",
      "!raid-exp",
      false),
  RAID_CAMPAGNE(
      "!raid-campagne",
      new SimpleUrlCommand("https://www.inteleria.com/campaign-top-champions/"),
      "TODO",
      "!raid-campagne",
      false),

  RAID_DOWNTOWER(
      "!raid-doomtower",
      new SimpleUrlCommand("https://www.inteleria.com/doom-tower/"),
      "TODO",
      "!raid-doomtower",
      false),
  RAID_DTSTAGE(
      "!raid-dtstage",
      new SimpleUrlCommand(
          "https://docs.google.com/spreadsheets/d/1tZcL6f4qAMRUZ1UXbljj4QpRfV28NGrtOpVOmtk1-u8/edit#gid=0"),
      "TODO",
      "!raid-dtstage",
      false),
  RAID_ARAIGNEE(
      "!raid-araignée",
      new SimpleUrlCommand("https://www.inteleria.com/spiders-den-top-champions/"),
      "TODO",
      "!raid-araignée",
      false),
  RAID_CHEVALIERFEU(
      "!raid-chevalierdefeu",
      new SimpleUrlCommand("https://www.inteleria.com/fire-knight-top-champions/"),
      "TODO",
      "!raid-chevalierdefeu",
      false),
  RAID_DRAGON(
      "!raid-dragon",
      new SimpleUrlCommand("https://www.inteleria.com/dragons-lair-top-champions/"),
      "TODO",
      "!raid-dragon",
      false),
  RAID_DEAL(
      "!raid-deal",
      new SimpleUrlCommand("https://www.inteleria.com/tools/deal-calculator/"),
      "TODO",
      "!raid-deal",
      false),
  RAID_BAZAR(
      "!raid-bazar",
      new SimpleUrlCommand("https://www.inteleria.com/bazaar-guide-item-values/"),
      "TODO",
      "!raid-bazar",
      false),
  RAID_BANNERLORS(
      "!raid-bannerlords",
      new SimpleUrlCommand("https://www.inteleria.com/factions/banner-lords/"),
      "TODO",
      "!raid-bannerlords",
      false),
  RAID_HIGHELVES(
      "!raid-highelves",
      new SimpleUrlCommand("https://www.inteleria.com/factions/high-elves/"),
      "TODO",
      "!raid-highelves",
      false),
  RAID_THESACREDORDER(
      "!raid-thesacredorder",
      new SimpleUrlCommand("https://www.inteleria.com/factions/the-sacred-order/"),
      "TODO",
      "!raid-thesacredorder",
      false),
  RAID_BARBARIANS(
      "!raid-barbarians",
      new SimpleUrlCommand("https://www.inteleria.com/factions/barbarians/"),
      "TODO",
      "!raid-barbarians",
      false),
  RAID_OGRYNTRIBES(
      "!raid-ogryntribes",
      new SimpleUrlCommand("https://www.inteleria.com/factions/ogryn-tribes/"),
      "TODO",
      "!raid-ogryntribes",
      false),
  RAID_LIZARDMEN(
      "!raid-lizardmen",
      new SimpleUrlCommand("https://www.inteleria.com/factions/lizardmen/"),
      "TODO",
      "!raid-lizardmen",
      false),
  RAID_SKINWALKERS(
      "!!raid-skinwalkers",
      new SimpleUrlCommand("https://www.inteleria.com/factions/skinwalkers/"),
      "TODO",
      "!raid-skinwalkers",
      false),
  RAID_ORCS(
      "!raid-orcs",
      new SimpleUrlCommand("https://www.inteleria.com/factions/orcs/"),
      "TODO",
      "!raid-orcs",
      false),
  RAID_DEMONSPAWN(
      "!raid-demonspawn",
      new SimpleUrlCommand("https://www.inteleria.com/factions/demonspawn/"),
      "TODO",
      "!raid-demonspawn",
      false),
  RAID_UNDEADHORDES(
      "!raid-undeadhordes",
      new SimpleUrlCommand("https://www.inteleria.com/factions/undead-hordes/"),
      "TODO",
      "!raid-undeadhordes",
      false),
  RAID_DARKELVES(
      "!raid-darkelves",
      new SimpleUrlCommand("https://www.inteleria.com/factions/dark-elves/"),
      "TODO",
      "!raid-darkelves",
      false),
  RAID_KNIGHTREVENANT(
      "!raid-knightrevenant",
      new SimpleUrlCommand("https://www.inteleria.com/factions/knight-revenant/"),
      "TODO",
      "!raid-knightrevenant",
      false),
  RAID_DWARVES(
      "!raid-dwarves",
      new SimpleUrlCommand("https://www.inteleria.com/factions/dwarves/"),
      "TODO",
      "!raid-dwarves",
      false);

  private final String key;
  private final ICommandAnswer commandAnswer;
  private final String description;
  private final String example;
  private boolean isHidden;

  public static RslCommand fromString(String text) {
    Optional<RslCommand> optCommand =
        Arrays.stream(RslCommand.values()).filter(cmd -> cmd.key.equals(text)).findFirst();

    return optCommand.orElse(UNKNOWN);
  }
}
