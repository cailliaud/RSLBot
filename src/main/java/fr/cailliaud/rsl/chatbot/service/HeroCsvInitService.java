package fr.cailliaud.rsl.chatbot.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import fr.cailliaud.rsl.chatbot.domain.HeroDto;
import fr.cailliaud.rsl.chatbot.entity.HeroEntity;
import fr.cailliaud.rsl.chatbot.repository.HeroRepository;
import fr.cailliaud.rsl.chatbot.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeroCsvInitService {

  private final HeroRepository heroRepository;

  @PostConstruct
  private void postConstruct() throws Exception {
    List<HeroEntity> heroEntitySet = new ArrayList<>();
    CsvMapper mapper = new CsvMapper();
    CsvSchema schema = mapper.schemaFor(HeroDto.class).withHeader().withColumnSeparator(';');

    MappingIterator<HeroDto> it =
        mapper
            .readerFor(HeroDto.class)
            .with(schema)
            .readValues(
                this.getClass().getClassLoader().getResource("data/Personnages_raid_bot.csv"));

    while (it.hasNextValue()) {
      HeroDto heroDto = it.nextValue();
      HeroEntity heroEntity = new HeroEntity();
      heroEntity.setFaction(heroDto.getFaction());
      heroEntity.setLienAlucare(heroDto.getLienAlucare());
      heroEntity.setLienInteleria(heroDto.getLienInteleria());
      heroEntity.setLienMisterTix(heroDto.getLienMisterTix());
      heroEntity.setNomAnglais(Utils.stripAccents(heroDto.getNomAnglais()).trim().toLowerCase());
      heroEntity.setNomFrancais(Utils.stripAccents(heroDto.getNomFrancais()).trim().toLowerCase());
      log.debug(heroEntity.toString());
      heroEntitySet.add(heroEntity);
    }

    heroRepository.saveAll(heroEntitySet);
  }
}
