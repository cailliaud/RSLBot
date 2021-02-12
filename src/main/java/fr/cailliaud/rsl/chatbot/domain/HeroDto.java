package fr.cailliaud.rsl.chatbot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.ToString;

@JsonPropertyOrder({
  "Nom anglais",
  "Nom francais",
  "Lien Alucare",
  "Lien Mister Tix",
  "Lien Inteleria",
  "Faction"
})
@Getter
@ToString
public class HeroDto {

  @JsonProperty("Nom anglais")
  private String nomAnglais;

  @JsonProperty("Nom francais")
  private String nomFrancais;

  @JsonProperty("Lien Alucare")
  private String lienAlucare;

  @JsonProperty("Lien Mister Tix")
  private String lienMisterTix;

  @JsonProperty("Lien Inteleria")
  private String lienInteleria;

  @JsonProperty("Faction")
  private Faction faction;
}
