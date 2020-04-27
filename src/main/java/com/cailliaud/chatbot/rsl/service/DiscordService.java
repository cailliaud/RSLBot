package com.cailliaud.chatbot.rsl.service;

import com.cailliaud.chatbot.rsl.listener.HeroListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Service
public class DiscordService {

    private JDA discordApi;
    private HeroListener heroListener;

    @Value("${discord.token}")
    private String token;

    public DiscordService(HeroListener heroListener) {
        this.heroListener = heroListener;
    }

    @PostConstruct
    private void postConstruct() throws LoginException {
        this.discordApi = JDABuilder
                .createDefault(token)
                .setActivity(Activity.of(Activity.ActivityType.STREAMING, "Raid: Shadow Legends"))
                .setStatus(OnlineStatus.ONLINE)
                .setAutoReconnect(true)
                .build();

        this.discordApi.addEventListener(heroListener);

    }

}
