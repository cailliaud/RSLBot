package com.cailliaud.rsl.adapter;

import com.cailliaud.rsl.domain.Hero;

import java.util.List;

public interface IHeroAdapter {

    Hero findHeroByName(String frenchName);

    List<Hero> findHeroesByFrenchNameContains(String heroShardName);
}
