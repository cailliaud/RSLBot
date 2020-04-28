package com.cailliaud.chatbot.rsl.service;

import com.cailliaud.chatbot.rsl.domain.HeroDto;
import com.cailliaud.chatbot.rsl.entity.Hero;
import com.cailliaud.chatbot.rsl.mapper.HeroMapper;
import com.cailliaud.chatbot.rsl.repository.HeroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class HeroService {

    private HeroRepository heroRepository;
    private HeroMapper heroMapper;


    public HeroService(HeroRepository heroRepository, HeroMapper heroMapper) {
        this.heroRepository = heroRepository;
        this.heroMapper = heroMapper;
    }

    public HeroDto findHero(String heroName) {

        Hero hero = heroRepository.findFirstByFrenchNameIgnoreCase(heroName.toLowerCase());
        return heroMapper.toHeroDto(hero);

    }


    public List<HeroDto> findSimilarHeroes(String hero) {

        String heroToTest = hero.toLowerCase(Locale.FRANCE);
        List<Hero> tmpPossibleHeroes = new ArrayList<>();
        for (int i = hero.length(); i > 2; i--) {
            String chunk = heroToTest.substring(0, i);

            List<Hero> possibleHeroes = heroRepository.findByFrenchNameContainingIgnoreCase(chunk);

            if (possibleHeroes.size() > tmpPossibleHeroes.size()) {
                tmpPossibleHeroes = possibleHeroes;
            }

            if (tmpPossibleHeroes.size() >= 5) {
                break;
            }
        }
        return heroMapper.toHeroesDto(tmpPossibleHeroes);

    }
}
