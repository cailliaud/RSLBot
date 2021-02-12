package fr.cailliaud.rsl.chatbot.service;

import fr.cailliaud.rsl.chatbot.listener.HeroListener;
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

  private HeroListener heroListener;

  @Value("${discord.token}")
  private String token;

  @Value("${discord.enabled:false}")
  private boolean isEnabled;

  public DiscordService(HeroListener heroListener) {
    this.heroListener = heroListener;
  }

  @PostConstruct
  private void postConstruct() throws LoginException {

    if (isEnabled) {
      JDA discordApi =
          JDABuilder.createDefault(token)
              .setActivity(Activity.of(Activity.ActivityType.STREAMING, "!raid-help"))
              .setStatus(OnlineStatus.ONLINE)
              .setAutoReconnect(true)
              .build();

      discordApi.addEventListener(heroListener);
    }
  }
}
