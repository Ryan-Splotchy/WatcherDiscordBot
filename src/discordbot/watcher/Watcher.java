package discordbot.watcher;

//Note: Created by Ryan Shelton @ 14:20pm 2021/07/25

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Watcher {
    public static JDA jda;
    public final static String prefix = "-";

    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault("not-my-token").build();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);
//            jda.getPresence().setActivity(Activity.playing("Protecting SplotchyBoss47's Sanity"));
            jda.getPresence().setActivity(Activity.watching(" For Scrumptious Prey"));

            jda.addEventListener(new ShrikeChecker());
            jda.addEventListener(new Commands());
//            jda.addEventListener(new Mischief());
            jda.addEventListener(new ReactionChecker());
            jda.addEventListener(new MessageOfTheDay());
            jda.addEventListener(new Punisher());
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}




