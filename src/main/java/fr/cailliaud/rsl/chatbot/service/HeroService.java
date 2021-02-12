package fr.cailliaud.rsl.chatbot.service;

import fr.cailliaud.rsl.chatbot.entity.HeroEntity;
import fr.cailliaud.rsl.chatbot.repository.HeroRepository;
import fr.cailliaud.rsl.chatbot.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {

  private final HeroRepository heroRepository;

  public HeroEntity findHero(String heroName) {
    String heroNameCleaned = Utils.stripAccents(heroName);
    return heroRepository
        .findFirstByNomAnglaisIgnoreCaseOrNomFrancaisIgnoreCase(heroNameCleaned, heroNameCleaned)
        .orElse(null);
  }

  public List<HeroEntity> findPossibleHeroes(String heroName) {
    List<HeroEntity> tmpPossibleHeroes = new ArrayList<>();
    String heroNameFormatted = Utils.stripAccents(heroName);
    for (int i = heroNameFormatted.length(); i > 2; i--) {
      String chunk = heroNameFormatted.substring(0, i);

      List<HeroEntity> possibleHeroes = heroRepository.findByNomFrancaisContainingIgnoreCase(chunk);

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
