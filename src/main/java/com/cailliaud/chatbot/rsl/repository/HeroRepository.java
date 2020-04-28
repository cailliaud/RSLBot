package com.cailliaud.chatbot.rsl.repository;

import com.cailliaud.chatbot.rsl.entity.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    Hero findFirstByEnglishNameIgnoreCase(String englishName);

    Hero findFirstByFrenchNameIgnoreCase(String frenchName);

    List<Hero> findByFrenchNameContainingIgnoreCase(String frenchName);

    Hero findById(long id);
}
