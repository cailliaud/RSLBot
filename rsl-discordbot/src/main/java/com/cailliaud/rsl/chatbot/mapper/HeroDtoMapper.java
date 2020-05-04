package com.cailliaud.rsl.chatbot.mapper;

import com.cailliaud.rsl.chatbot.domain.HeroDto;
import com.cailliaud.rsl.domain.Hero;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroDtoMapper {


    public HeroDto toHeroDto(Hero hero) {

        if (hero == null) {
            return null;
        }
        HeroDto heroDto = new HeroDto();
        heroDto.setName(StringUtils.capitalize(hero.getFrenchName()));
        heroDto.setGuideUrl(hero.getGuideUrl());

        return heroDto;
    }

    public List<HeroDto> toHeroesDto(List<Hero> heroes) {
        if (CollectionUtils.isEmpty(heroes)) {
            return Collections.emptyList();
        } else {
            return heroes.stream().map(this::toHeroDto).collect(Collectors.toList());
        }
    }


    private String serializeName(String name, String separator) {
        return Arrays.stream(name.split("\\s+"))
                .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                .map(t -> t.replace("’", ""))
                .collect(Collectors.joining(separator));
    }
}
