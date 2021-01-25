package com.cailliaud.rsl.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class Hero {

  private String englishName;
  private String frenchName;
  private String urlAlucare;
  private String urlVinceVDG;
  private String urlMisterTix;
}
