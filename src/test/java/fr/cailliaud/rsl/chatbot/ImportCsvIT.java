package fr.cailliaud.rsl.chatbot;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import fr.cailliaud.rsl.chatbot.domain.HeroDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest(properties = {"discord.token=4654564es", "discord.enabled=false"})
public class ImportCsvIT {

  @Test
  void doitLireFichierCsv() throws IOException {
    CsvMapper mapper = new CsvMapper();
    CsvSchema schema = mapper.schemaFor(HeroDto.class).withHeader().withColumnSeparator(';');

    MappingIterator<HeroDto> it =
        mapper
            .readerFor(HeroDto.class)
            .with(schema)
            .readValues(
                this.getClass().getClassLoader().getResource("data/Personnages_raid_bot.csv"));

    while (it.hasNextValue()) {
      HeroDto value = it.nextValue();
      System.out.println(value.toString());
    }
  }
}
