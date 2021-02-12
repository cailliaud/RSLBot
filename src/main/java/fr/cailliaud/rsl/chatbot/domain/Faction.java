package fr.cailliaud.rsl.chatbot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Faction {
  BANNER_LORDS("Banner Lords"),
  HIGH_ELVES("High Elves"),
  THE_SACRED_ORDER("The Sacred Order"),
  OGRYN_TRIBES("Ogryn Tribes"),
  BARBARIANS("Barbarians"),
  LIZARDMEN("Lizardmen"),
  SKINWALKERS("Skinwalkers"),
  ORCS("Orcs"),
  DEMONSPAWN("Demonspawn"),
  UNDEAD_HORDES("Undead Hordes"),
  DARK_ELVES("Dark Elves"),
  KNIGHT_REVENANT("Knight Revenant"),
  DWARVES("Dwarves");

  private final String label;
}
