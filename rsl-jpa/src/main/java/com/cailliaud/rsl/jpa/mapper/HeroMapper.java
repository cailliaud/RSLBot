package com.cailliaud.rsl.jpa.mapper;

import com.cailliaud.rsl.domain.Hero;
import com.cailliaud.rsl.jpa.entity.HeroEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroMapper {

    public Hero toHero(@NonNull HeroEntity heroEntity) {

        Hero hero = new Hero();
        hero.setEnglishName(heroEntity.getEnglishName());
        hero.setFrenchName(heroEntity.getFrenchName());

        return hero;
    }

    public List<Hero> toHeroes(List<HeroEntity> heroEntities) {

        if (CollectionUtils.isEmpty(heroEntities)) {
            return Collections.emptyList();
        }
        return heroEntities.stream().map(this::toHero).collect(Collectors.toList());

    }
}
