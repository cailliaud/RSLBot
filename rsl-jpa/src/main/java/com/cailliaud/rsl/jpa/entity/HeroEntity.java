package com.cailliaud.rsl.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "HERO")
@Data
@NoArgsConstructor
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String englishName;
    private String frenchName;


    public HeroEntity(String englishName, String frenchName) {
        this.englishName = englishName;
        this.frenchName = frenchName;
    }
}
