package com.cailliaud.rsl.chatbot.service;

import com.cailliaud.rsl.chatbot.domain.HeroDto;
import com.cailliaud.rsl.chatbot.mapper.HeroDtoMapper;
import com.cailliaud.rsl.service.IHeroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroDtoService {

    private HeroDtoMapper heroDtoMapper;
    private IHeroService heroService;


    public HeroDtoService(HeroDtoMapper heroDtoMapper, IHeroService heroService) {
        this.heroDtoMapper = heroDtoMapper;
        this.heroService = heroService;
    }

    public HeroDto findHero(String heroName) {
        return heroDtoMapper.toHeroDto(heroService.findHero(heroName));
    }

    public List<HeroDto> findPossibleHeroes(String heroName) {
        return heroDtoMapper.toHeroesDto(heroService.findPossibleHeroes(heroName));

    }
}
