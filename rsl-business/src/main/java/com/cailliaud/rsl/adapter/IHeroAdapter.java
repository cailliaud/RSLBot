package com.cailliaud.rsl.adapter;

import com.cailliaud.rsl.domain.Hero;

import java.util.List;

public interface IHeroAdapter {

    Hero findHeroByFrenchName(String frenchName);

    List<Hero> findHeroesByFrenchNameContains(String heroShardName);
}
