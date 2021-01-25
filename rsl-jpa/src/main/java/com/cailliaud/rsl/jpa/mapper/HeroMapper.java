package com.cailliaud.rsl.jpa.mapper;

import com.cailliaud.rsl.domain.Hero;
import com.cailliaud.rsl.jpa.entity.HeroEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeroMapper {

  Hero convert(HeroEntity heroEntity);
}
