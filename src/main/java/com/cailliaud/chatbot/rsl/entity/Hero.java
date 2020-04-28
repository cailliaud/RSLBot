package com.cailliaud.chatbot.rsl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String englishName;
    private String frenchName;


    public Hero(String englishName, String frenchName) {
        this.englishName = englishName;
        this.frenchName = frenchName;
    }
}
