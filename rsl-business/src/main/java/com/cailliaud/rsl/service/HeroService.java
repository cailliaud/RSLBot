package com.cailliaud.rsl.service;

import com.cailliaud.rsl.adapter.IHeroAdapter;
import com.cailliaud.rsl.domain.Hero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService implements IHeroService {

    private IHeroAdapter heroAdapter;

    public HeroService(IHeroAdapter heroAdapter) {
        this.heroAdapter = heroAdapter;
    }

    @Override
    public Hero findHero(String heroName) {
        return heroAdapter.findHeroByName(heroName);
    }

    @Override
    public List<Hero> findPossibleHeroes(String heroName) {
        List<Hero> tmpPossibleHeroes = new ArrayList<>();
        for (int i = heroName.length(); i > 2; i--) {
            String chunk = heroName.substring(0, i);

            List<Hero> possibleHeroes = heroAdapter.findHeroesByFrenchNameContains(chunk);

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
