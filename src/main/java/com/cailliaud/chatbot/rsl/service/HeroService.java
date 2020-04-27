package com.cailliaud.chatbot.rsl.service;

import com.cailliaud.chatbot.rsl.configuration.HeroesMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HeroService {

    private Map<String, String> heroesMapping;


    public HeroService(HeroesMap heroesMap) {
        this.heroesMapping = heroesMap.getHeroes();
    }

    public String findHero(String hero) {
        return heroesMapping.get(hero.toLowerCase(Locale.FRANCE));
    }


    public Set<String> findSimilarHeroes(String hero) {

        String heroToTest = hero.toLowerCase(Locale.FRANCE);
        Set<String> tmpPossibleHeroes = new HashSet<>();
        for (int i = hero.length(); i > 1; i--) {
            String chunk = heroToTest.substring(0, i);

            Set<String> possibleHeroes = heroesMapping.entrySet().stream()
                    .filter(e -> e.getKey().startsWith(chunk))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());

            if (possibleHeroes.size() > tmpPossibleHeroes.size()) {
                tmpPossibleHeroes = possibleHeroes;
            }

            if (tmpPossibleHeroes.size() >= 5) {
                break;
            }
        }
        return tmpPossibleHeroes;

    }
}
