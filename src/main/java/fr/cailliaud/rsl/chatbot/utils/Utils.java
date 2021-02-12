package fr.cailliaud.rsl.chatbot.utils;

import lombok.experimental.UtilityClass;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.stream.Collectors;

@UtilityClass
public class Utils {

  public final String AYUMILOVE = "AYUMILOVE [EN]";
  public final String RAID_CODEX = "RAID-CODEX [EN]";
  public final String ALUCARE = "ALUCARE [FR]";
  public final String CAILLIAUD = "CAILLIAUD";
  public final String WIKI_FANDOM = "WIKI FANDOM [EN]";
  public final String GUIDE_URL =
      "https://ayumilove.net/raid-shadow-legends-%s-skill-mastery-equip-guide/";
  public final String ICON_URL =
      "https://ayumilove.net/files/games/raid_shadow_legends/avatar/%s.png";
  public final String IMAGE_URL =
      "https://ayumilove.net/files/games/raid_shadow_legends/champion/%s.jpg";
  public final String MASTERY_URL =
      "https://ayumilove.net/files/games/raid_shadow_legends/mastery/%s.jpg";

  public String serializeName(String name, String separator) {
    return Arrays.stream(name.split("\\s+"))
        .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
        .map(t -> t.replace("’", ""))
        .collect(Collectors.joining(separator));
  }

  public String stripAccents(String s) {
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    return s;
  }
}
