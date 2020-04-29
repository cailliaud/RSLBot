package com.cailliaud.rsl.jpa.service;

import com.cailliaud.rsl.adapter.IHeroAdapter;
import com.cailliaud.rsl.domain.Hero;
import com.cailliaud.rsl.jpa.entity.HeroEntity;
import com.cailliaud.rsl.jpa.mapper.HeroMapper;
import com.cailliaud.rsl.jpa.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroAdapter implements IHeroAdapter {


    private HeroRepository heroRepository;
    private HeroMapper heroMapper;


    public HeroAdapter(HeroRepository heroRepository, HeroMapper heroMapper) {
        this.heroRepository = heroRepository;
        this.heroMapper = heroMapper;
    }

    @Override
    public Hero findHeroByName(String name) {
        HeroEntity hero = heroRepository.findByName(name);
        return heroMapper.toHero(hero);
    }

    @Override
    public List<Hero> findHeroesByFrenchNameContains(String heroShardName) {
        List<HeroEntity> heroEntities = heroRepository.findByFrenchNameContainingIgnoreCase(heroShardName);
        return heroMapper.toHeroes(heroEntities);
    }


}
