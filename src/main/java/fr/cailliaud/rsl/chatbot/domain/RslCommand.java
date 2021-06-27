package fr.cailliaud.rsl.chatbot.domain;

import fr.cailliaud.rsl.chatbot.domain.command.*;
import fr.cailliaud.rsl.chatbot.entity.HeroEntity;
import fr.cailliaud.rsl.chatbot.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum RslCommand {
  AYUMILOVE(
      "!raid-ayu",
      new HeroCommand(
          heroEntity ->
              String.format(Utils.GUIDE_URL, Utils.serializeName(heroEntity.getNomAnglais(), "-")),
          "Ayumilove n'a pas encore de guide sur ce champion."),
      "[EN][AYUMILOVE] Afficher les informations sur un héros du jeu",
      "!raid-ayu Galek"),
  MASTERY(
      "!raid-maitrise",
      new HeroCommand(
          heroEntity ->
              String.format(
                  Utils.MASTERY_URL, Utils.serializeName(heroEntity.getNomAnglais(), "_")),
          "Ayumilove n'a pas encore d'aide pour les maitrises sur ce champion."),
      "Afficher les informations sur les maitrises pour un héros du jeu",
      "!raid-maitrise Galek"),
  ALUCARE(
      "!raid-alu",
      new HeroCommand(
          HeroEntity::getLienAlucare, "Alucare n'a pas encore de guide sur ce champion."),
      "[FR][ALUCARE] Afficher les informations sur un héros du jeu",
      "!raid-alu Galek"),
  TIX(
      "!raid-tix",
      new HeroCommand(
          HeroEntity::getLienMisterTix, "Mister Tix n'a pas encore de guide sur ce champion."),
      "[FR][Mister TIX] Afficher les informations sur un héros du jeu",
      "!raid-tix Galek"),
  INTELERIA(
      "!raid-int",
      new HeroCommand(
          HeroEntity::getLienInteleria, "Inteleria n'a pas encore de guide sur ce champion."),
      "[FR][Inteleria] Afficher les informations sur un héros du jeu",
      "!raid-int Galek"),

  TIER_LIST(
      "!raid-tier",
      new TierListCommand(),
      "Afficher les différentes tier list du jeu.",
      "!raid-tier"),
  MINE("!raid-mine", new MineCommand(), "Afficher les informations sur la mine.", "!raid-mine"),

  HELP("!raid-help", new HelpCommand(), "Afficher les commandes !raid", "!raid-help"),
  UNKNOWN("", new UnknownCommand(), "Commande inconnue", "!raid-12345"),
  RAID_BUFF(
      "!raid-buff",
      new SimpleUrlCommand("https://www.inteleria.com/buffs-and-debuffs-list/"),
      "Afficher les info buff",
      "!raid-buff"),
  RAID_BDC(
      "!raid-bdc",
      new SimpleUrlCommand("https://www.inteleria.com/clan-boss-top-champions/"),
      "Afficher les info bdc",
      "!raid-bdc"),
  RAID_SPEED_TUNE(
      "!raid-speedtune",
      new SimpleUrlCommand("https://www.deadwoodjedi.com/speed-tunes-9"),
      "Afficher les info bdc speedtunes",
      "!raid-speedtune"),
  RAID_CBC_CALCULATOR(
      "!raid-cbcalculator",
      new SimpleUrlCommand("https://deadwoodjedi.info/cb"),
      "Accès outil cbc calculator",
      "!raid-cbcalculator"),
  RAID_EXP(
      "!raid-exp",
      new SimpleUrlCommand(
          "https://docs.google.com/spreadsheets/d/1invzrqmdYSCBwJ4tY6YjUhsrDZkf1_j6B9C8EDPrGhk/edit#gid=623907573"),
      "Accès gdoc experience",
      "!raid-exp"),
  RAID_CAMPAGNE(
      "!raid-campagne",
      new SimpleUrlCommand("https://www.inteleria.com/campaign-top-champions/"),
      "TODO",
      "!raid-campagne"),
  RAID_DOWNTOWER(
      "!raid-doomtower",
      new SimpleUrlCommand("https://www.inteleria.com/doom-tower/"),
      "TODO",
      "!raid-doomtower"),
  RAID_DTSTAGE(
      "!raid-dtstage",
      new SimpleUrlCommand(
          "https://docs.google.com/spreadsheets/d/1tZcL6f4qAMRUZ1UXbljj4QpRfV28NGrtOpVOmtk1-u8/edit#gid=0"),
      "TODO",
      "!raid-dtstage"),
  RAID_ARAIGNEE(
      "!raid-araignée",
      new SimpleUrlCommand("https://www.inteleria.com/spiders-den-top-champions/"),
      "TODO",
      "!raid-araignée"),
  RAID_CHEVALIERFEU(
      "!raid-chevalierdefeu",
      new SimpleUrlCommand("https://www.inteleria.com/fire-knight-top-champions/"),
      "TODO",
      "!raid-chevalierdefeu"),
  RAID_DRAGON(
      "!raid-dragon",
      new SimpleUrlCommand("https://www.inteleria.com/dragons-lair-top-champions/"),
      "TODO",
      "!raid-dragon"),
  RAID_DEAL(
      "!raid-deal",
      new SimpleUrlCommand("https://www.inteleria.com/tools/deal-calculator/"),
      "TODO",
      "!raid-deal"),
  RAID_BAZAR(
      "!raid-bazar",
      new SimpleUrlCommand("https://www.inteleria.com/bazaar-guide-item-values/"),
      "TODO",
      "!raid-bazar"),
  RAID_BANNERLORS(
      "!raid-bannerlords",
      new SimpleUrlCommand("https://www.inteleria.com/factions/banner-lords/"),
      "TODO",
      "!raid-bannerlords"),
  RAID_HIGHELVES(
      "!raid-highelves",
      new SimpleUrlCommand("https://www.inteleria.com/factions/high-elves/"),
      "TODO",
      "!raid-highelves"),
  RAID_THESACREDORDER(
      "!raid-thesacredorder",
      new SimpleUrlCommand("https://www.inteleria.com/factions/the-sacred-order/"),
      "TODO",
      "!raid-thesacredorder"),
  RAID_BARBARIANS(
      "!raid-barbarians",
      new SimpleUrlCommand("https://www.inteleria.com/factions/barbarians/"),
      "TODO",
      "!raid-barbarians"),
  RAID_OGRYNTRIBES(
      "!raid-ogryntribes",
      new SimpleUrlCommand("https://www.inteleria.com/factions/ogryn-tribes/"),
      "TODO",
      "!raid-ogryntribes"),
  RAID_LIZARDMEN(
      "!raid-lizardmen",
      new SimpleUrlCommand("https://www.inteleria.com/factions/lizardmen/"),
      "TODO",
      "!raid-lizardmen"),
  RAID_SKINWALKERS(
      "!raid-skinwalkers",
      new SimpleUrlCommand("https://www.inteleria.com/factions/skinwalkers/"),
      "TODO",
      "!raid-skinwalkers"),
  RAID_ORCS(
      "!raid-orcs",
      new SimpleUrlCommand("https://www.inteleria.com/factions/orcs/"),
      "TODO",
      "!raid-orcs"),
  RAID_DEMONSPAWN(
      "!raid-demonspawn",
      new SimpleUrlCommand("https://www.inteleria.com/factions/demonspawn/"),
      "TODO",
      "!raid-demonspawn"),
  RAID_UNDEADHORDES(
      "!raid-undeadhordes",
      new SimpleUrlCommand("https://www.inteleria.com/factions/undead-hordes/"),
      "TODO",
      "!raid-undeadhordes"),
  RAID_DARKELVES(
      "!raid-darkelves",
      new SimpleUrlCommand("https://www.inteleria.com/factions/dark-elves/"),
      "TODO",
      "!raid-darkelves"),
  RAID_KNIGHTREVENANT(
      "!raid-knightrevenant",
      new SimpleUrlCommand("https://www.inteleria.com/factions/knight-revenant/"),
      "TODO",
      "!raid-knightrevenant"),
  RAID_DWARVES(
      "!raid-dwarves",
      new SimpleUrlCommand("https://www.inteleria.com/factions/dwarves/"),
      "TODO",
      "!raid-dwarves");

  private final String key;
  private final ICommandAnswer commandAnswer;
  private final String description;
  private final String example;

  public static RslCommand fromString(String text) {
    Optional<RslCommand> optCommand =
        Arrays.stream(RslCommand.values()).filter(cmd -> cmd.key.equals(text)).findFirst();

    return optCommand.orElse(UNKNOWN);
  }
}
