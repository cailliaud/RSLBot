package com.cailliaud.chatbot.rsl.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties("rsl")
@Getter
@Setter
public class HeroesMap {

    private Map<String, String> heroes = new HashMap<>();
}
