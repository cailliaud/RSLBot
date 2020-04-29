package com.cailliaud.rsl.jpa.repository;

import com.cailliaud.rsl.jpa.entity.HeroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<HeroEntity, Long> {

    HeroEntity findFirstByEnglishNameIgnoreCase(String englishName);

    HeroEntity findFirstByFrenchNameIgnoreCase(String frenchName);

    List<HeroEntity> findByFrenchNameContainingIgnoreCase(String frenchName);

    HeroEntity findById(long id);
}
