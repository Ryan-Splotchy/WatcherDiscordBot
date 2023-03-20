package discordbot.watcher;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ShrikeChecker extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        Guild guild = event.getGuild();
//        Member shrike = guild.getMemberById(477082166988374017L);
        Member shrike = guild.getMemberById(617402849466253330L);
        if(event.getMember().getId().equals("617402849466253330") || event.getMember().getId().equals("353891983980363806")) {
           event.getMessage().delete().queue();
        }
    }
}
