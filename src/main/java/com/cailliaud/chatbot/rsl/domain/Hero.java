package com.cailliaud.chatbot.rsl.domain;

import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
public class Hero {
    private static final String GUIDE_URL = "https://ayumilove.net/raid-shadow-legends-%s-skill-mastery-equip-guide/";
    private static final String ICON_URL = "https://files.ayumilove.net/games/raid_shadow_legends/avatar/%s.png";
    private static final String IMAGE_URL = "https://files.ayumilove.net/games/raid_shadow_legends/champion/%s.jpg";
    private static final String MASTERY_URL = "https://files.ayumilove.net/games/raid_shadow_legends/mastery/%s.jpg";


    private String name;
    private String guideUrl;
    private String iconUrl;
    private String imageUrl;
    private String masteryUrl;

    public Hero(@NonNull String name) {
        this.name = StringUtils.capitalize(name);
        this.guideUrl = String.format(GUIDE_URL, serializeName(name, "-"));
        this.iconUrl = String.format(ICON_URL, serializeName(name, "_"));
        this.imageUrl = String.format(IMAGE_URL, serializeName(name, "_"));
        this.masteryUrl = String.format(MASTERY_URL, serializeName(name, "_"));
    }

    private String serializeName(String name, String separator) {
        return Arrays.stream(name.split("\\s+"))
                .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(separator));
    }
}
