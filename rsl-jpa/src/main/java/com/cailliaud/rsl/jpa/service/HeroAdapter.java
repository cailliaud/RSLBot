package com.cailliaud.rsl.jpa.service;

import com.cailliaud.rsl.adapter.IHeroAdapter;
import com.cailliaud.rsl.domain.Hero;
import com.cailliaud.rsl.jpa.mapper.HeroMapper;
import com.cailliaud.rsl.jpa.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroAdapter implements IHeroAdapter {

  private final HeroRepository heroRepository;
  private final HeroMapper heroMapper;

  @Override
  public Hero findHeroByName(String name) {
    return heroRepository.findHeroesByFrenchNameOrEnglishNameIgnoringCase(name).stream()
        .map(heroMapper::convert)
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<Hero> findHeroesByFrenchNameContains(String heroShardName) {
    return heroRepository.findByFrenchNameContainingIgnoreCase(heroShardName).stream()
        .map(heroMapper::convert)
        .collect(Collectors.toList());
  }
}
