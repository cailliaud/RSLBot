package com.cailliaud.rsl.jpa.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "HERO")
@Getter
public class HeroEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String englishName;
  private String frenchName;
  private String urlAlucare;
  private String urlVinceVDG;
  private String urlMisterTix;
}
