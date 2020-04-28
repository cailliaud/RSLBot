package com.cailliaud.chatbot.rsl.domain.message;

import com.cailliaud.chatbot.rsl.domain.HeroDto;
import com.cailliaud.chatbot.rsl.service.HeroService;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static com.cailliaud.chatbot.rsl.domain.Utils.AYUMILOVE;

public class HeroCommand implements ICommandAnswer {


    private HeroService heroService;


    @Override
    public void publishAnswer(MessageReceivedEvent event, Object... args) {
        MessageChannel channel = event.getChannel();
        HeroDto hero = (HeroDto) args[0];

        MessageEmbed msgEmbedded = new EmbedBuilder()
                .setColor(Color.RED)
                .setAuthor(AYUMILOVE, hero.getGuideUrl(), hero.getIconUrl())
                .setTitle(hero.getName(), hero.getGuideUrl())
                .setDescription(hero.getName() + " | Raid Shadow Legends Guide Maîtrise")
                .setImage(hero.getImageUrl())
                .setFooter("Informations récupérées par vos humbles serviteurs Ori, Orokir, Moahh, Gafi, Tampax et Yaszawel.")
                .build();
        channel.sendMessage(msgEmbedded).queue();
    }
}
