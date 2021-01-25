package com.cailliaud.rsl.service;

import com.cailliaud.rsl.adapter.IHeroAdapter;
import com.cailliaud.rsl.domain.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService implements IHeroService {

  private final IHeroAdapter heroAdapter;

  public static String stripAccents(String s) {
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    return s;
  }

  @Override
  public Hero findHero(String heroName) {
    return heroAdapter.findHeroByName(stripAccents(heroName));
  }

  @Override
  public List<Hero> findPossibleHeroes(String heroName) {
    List<Hero> tmpPossibleHeroes = new ArrayList<>();
    String heroNameFormatted = stripAccents(heroName);
    for (int i = heroNameFormatted.length(); i > 2; i--) {
      String chunk = heroNameFormatted.substring(0, i);

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
