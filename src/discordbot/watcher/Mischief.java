package discordbot.watcher;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Mischief extends ListenerAdapter {
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        Guild guild = event.getGuild();
        Role r = guild.getRoleById(778646951674773584L);
        Member keagan = guild.getMemberById(657652094760648712L);
        List<Member> members = guild.getMembers();

        /**
         * Idea is to list all of the channels available to the server (Guild) and iterate through all the returned channels and check whether keagan is contained within the particular channel, then to only execute the code while
         * keagan remains in the current channel. Note: This has a multitude of flaws, alternate solution needed.
         *
         */
//
//       List<GuildChannel> channels = guild.getChannels().stream().filter(c -> c.getMembers().contains(keagan));

        // Solution: I have concluded that since the JDA API does not provide a method for accessing
        //  the Member who initiated the move event, there would be no alternative way of isolating that the
        //  mover was in fact Keagan. The method described above would execute the code regardless of who
        //  initiated the move event, thus affecting Keagan even if he wasn't doing any malicious member moving.

        if (!event.getMember().equals(keagan)) {
            try {
//                System.out.println(keagan.getRoles());
                guild.removeRoleFromMember(keagan, r).queue();
                guild.deafen(keagan, true).queue();
                guild.mute(keagan, true).queue();
                try {
                    Thread.sleep(5000);
                    guild.addRoleToMember(keagan, r).queue();
                    guild.deafen(keagan, false).queue();
                    guild.mute(keagan, false).queue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (NullPointerException | UnsupportedOperationException | InsufficientPermissionException e) {
                e.printStackTrace();
            }

        }


    }


}
