package discordbot.watcher;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionChecker extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
       Member s = event.getGuild().getMemberById(343446932003487746L);


            if(event.getMember().getId().equals("343446932003487746")) {
                event.getReaction().removeReaction().queue();

            }
    }
}
