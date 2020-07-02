package com.cailliaud.rsl.chatbot.domain.command;

import com.cailliaud.rsl.chatbot.domain.HeroDto;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static com.cailliaud.rsl.chatbot.utils.Utils.AYUMILOVE;

public class HeroAlucareCommand implements ICommandAnswer {

    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        HeroDto hero = (HeroDto) args[0];
        channel.sendMessage(hero.getAlucareUrl()).queue();
    }
}
