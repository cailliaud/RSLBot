package com.cailliaud.chatbot.rsl.service;

import com.cailliaud.chatbot.rsl.configuration.HeroesMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class HeroService {

    private Map<String, String> heroesMapping;


    public HeroService(HeroesMap heroesMap) {
        this.heroesMapping = heroesMap.getHeroes();
    }

    public String findHero(String hero) {
        return heroesMapping.get(hero.toLowerCase());
    }
}
