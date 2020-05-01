package com.cailliaud.rsl.jpa.repository;

import com.cailliaud.rsl.jpa.entity.HeroEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<HeroEntity, Long> {

    @Query("SELECT h FROM HERO h WHERE LOWER(h.frenchName) = LOWER(:name) OR LOWER(h.englishName) = LOWER(:name)")
    List<HeroEntity> findHeroesByFrenchNameOrEnglishNameIgnoringCase(String name);

    List<HeroEntity> findByFrenchNameContainingIgnoreCase(String frenchName);

}
