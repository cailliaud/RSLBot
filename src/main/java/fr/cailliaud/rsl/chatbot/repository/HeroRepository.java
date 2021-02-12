package fr.cailliaud.rsl.chatbot.repository;

import fr.cailliaud.rsl.chatbot.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeroRepository extends JpaRepository<HeroEntity, Long> {

  Optional<HeroEntity> findFirstByNomAnglaisIgnoreCaseOrNomFrancaisIgnoreCase(
      String nom, String nom2);

  List<HeroEntity> findByNomFrancaisContainingIgnoreCase(String frenchName);
}
