package discordbot.watcher;

import com.fasterxml.jackson.databind.JsonNode;
import net.dv8tion.jda.api.EmbedBuilder;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.web.util.WebUtils;

import java.awt.*;
import java.util.Random;

public class Commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Guild guild = event.getGuild();
        Member Splotchy = guild.getMemberById(343446932003487746L);

        if (args[0].equalsIgnoreCase(Watcher.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("👀 Information");
            info.setDescription("I watch for people (not including Splotchy but especially Keegs) moving others from one voice channel to another. Naughty Naughty");
            info.setColor(0x4251f5);
            info.setFooter("Created by Splotchy", Splotchy.getUser().getAvatarUrl());


            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }
    }
}
