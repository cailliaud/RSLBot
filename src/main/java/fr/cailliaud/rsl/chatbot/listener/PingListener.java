package fr.cailliaud.rsl.chatbot.listener;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class PingListener extends ListenerAdapter {

  @Override
  public void onSlashCommand(SlashCommandEvent event) {
    if (!event.getName().equals("ping")) return; // make sure we handle the right command
    long time = System.currentTimeMillis();
    event
        .reply("Pong!")
        .setEphemeral(true) // reply or acknowledge
        .flatMap(
            v ->
                event
                    .getHook()
                    .editOriginalFormat(
                        "Pong: %d ms", System.currentTimeMillis() - time) // then edit original
            )
        .queue(); // Queue both reply and edit
  }
}
