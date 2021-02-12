package fr.cailliaud.rsl.chatbot;

import fr.cailliaud.rsl.chatbot.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestUtils {

  @Test
  public void testRemoveAccentMethod() {
    // -- Given
    String championName = "Prêtresse de l'esprit sacré à dents ouï";

    // -- When
    String championNameStripped = Utils.stripAccents(championName);

    // -- Then

    Assertions.assertEquals("Pretresse de l'esprit sacre a dents oui", championNameStripped);
  }
}
