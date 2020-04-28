package com.cailliaud.chatbot.rsl.mapper;

import com.cailliaud.chatbot.rsl.domain.HeroDto;
import com.cailliaud.chatbot.rsl.entity.Hero;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.cailliaud.chatbot.rsl.domain.Utils.*;

@Service
public class HeroMapper {


    public HeroDto toHeroDto(Hero hero) {

        if (hero == null) {
            return null;
        }
        HeroDto heroDto = new HeroDto();

        heroDto.setName(StringUtils.capitalize(hero.getFrenchName()));

        String guideUrl = String.format(GUIDE_URL, serializeName(hero.getEnglishName(), "-"));
        heroDto.setGuideUrl(guideUrl);

        String iconUrl = String.format(ICON_URL, serializeName(hero.getEnglishName(), "_"));
        heroDto.setIconUrl(iconUrl);

        String imageUrl = String.format(IMAGE_URL, serializeName(hero.getEnglishName(), "_"));
        heroDto.setImageUrl(imageUrl);

        String masteryUrl = String.format(MASTERY_URL, serializeName(hero.getEnglishName(), "_"));
        heroDto.setMasteryUrl(masteryUrl);

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
