package com.cailliaud.rsl.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeroServiceTest {

    @Test
    public void testRemoveAccentMethod() {
        //-- Given
        String championName = "Prêtresse de l'esprit sacré à dents ouï";

        //-- When
        String championNameStripped = HeroService.stripAccents(championName);

        //-- Then

        Assertions.assertEquals("Pretresse de l'esprit sacre a dents oui", championNameStripped);
    }

}