package com.cailliaud.rsl.service;

import com.cailliaud.rsl.domain.Hero;

import java.util.List;

public interface IHeroService {

    Hero findHero(String heroName);

    List<Hero> findPossibleHeroes(String heroName);
}
