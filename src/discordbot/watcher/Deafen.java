package discordbot.watcher;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceDeafenEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Deafen extends ListenerAdapter {

    public void onGuildVoiceDeafen(GuildVoiceDeafenEvent event) {
        Guild guild = event.getGuild();
        Role r = guild.getRoleById(778646951674773584L);

        if (event.getMember().equals(guild.getMemberById(617402849466253330L))) {
            if(event.getMember().getVoiceState().isGuildDeafened()) {
                Member member = guild.getMemberById(617402849466253330L);
                System.out.println(member.getEffectiveName());
                try {
                System.out.println(member.getRoles());
                    guild.removeRoleFromMember(member, r).queue();
                System.out.println(member.getRoles());
                    timeOutTime(member, r, guild);

                } catch (NullPointerException  | UnsupportedOperationException | InsufficientPermissionException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void timeOutTime(Member member, Role role, Guild guild) {
        try {
            Thread.sleep(10000);
            guild.addRoleToMember(member,role).queue();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
