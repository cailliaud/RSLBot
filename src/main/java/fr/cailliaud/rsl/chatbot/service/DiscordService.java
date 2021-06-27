package fr.cailliaud.rsl.chatbot.service;

import fr.cailliaud.rsl.chatbot.listener.HeroListener;
import fr.cailliaud.rsl.chatbot.listener.PingListener;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Service
@RequiredArgsConstructor
public class DiscordService {

  private final HeroListener heroListener;
  private final PingListener pingListener;

  @Value("${discord.token}")
  private String token;

  @Value("${discord.enabled:false}")
  private boolean isEnabled;

  @PostConstruct
  private void postConstruct() throws LoginException, InterruptedException {

    if (isEnabled) {
      JDA discordApi =
          JDABuilder.createDefault(token)
              .setActivity(Activity.of(Activity.ActivityType.STREAMING, "!raid-help"))
              .setStatus(OnlineStatus.ONLINE)
              .setAutoReconnect(true)
              .build();
      discordApi.addEventListener(heroListener, pingListener);

      discordApi.awaitReady();

      discordApi
          .getGuilds()
          .forEach(
              g ->
                  g.updateCommands()
                      .addCommands(
                          new CommandData("ping", "Calculer le ping du bot RSL"),
                          new CommandData("raid-ayu", "ayu raid info")
                              .addOption(
                                  OptionType.STRING, "héros", "nom du héros recherché", true))
                      .queue());
    }
  }
}
