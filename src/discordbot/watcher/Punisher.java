package discordbot.watcher;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class Punisher extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        Guild guild = event.getGuild();
        List<VoiceChannel> vcs = guild.getVoiceChannels();
        Member Splotchy = guild.getMemberById(343446932003487746L);

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if ((!event.getMember().equals(Splotchy))) {
//            EmbedBuilder denied = new EmbedBuilder();
//            denied.setTitle("Access Denied!!!");
//            denied.setDescription("Only the all powerful " + Splotchy.getEffectiveName() + " may invoke my wrath upon someone.");
//            denied.setColor(new Color(255, 0, 0));
//            denied.setFooter("Created by This Guy", Splotchy.getUser().getAvatarUrl());
//            event.getChannel().sendTyping().queue();
//            event.getChannel().sendMessageEmbeds(denied.build()).queue();
//            denied.clear();

        } else {
            if ((args.length != 2)) {
                EmbedBuilder augh = new EmbedBuilder();
                augh.setTitle("Incorrect Number Of Arguments!");
                augh.setDescription("Use the Watcher Bot Prefix followed by the command");
                augh.setColor(new Color(255, 0, 0));
                augh.setFooter("Created by This Guy", Splotchy.getUser().getAvatarUrl());
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(augh.build()).queue();
                augh.clear();
            } else if (!args[0].equals(Watcher.prefix + "punish")) {

            } else {

                EmbedBuilder success = new EmbedBuilder();
                success.setTitle("Punishing " + args[1] + "!");
                success.setDescription("My wrath will be swift and unwavering!!");
                success.setColor(new Color(50, 150, 100));
                success.setFooter("Created by This Guy", Splotchy.getUser().getAvatarUrl());
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(success.build()).queue();


                if (args[0].equalsIgnoreCase(Watcher.prefix + "punish")) {
                    List<Member> victims = guild.getMembersByEffectiveName(args[1], true);

                    if (victims.isEmpty()) {
                        EmbedBuilder noOne = new EmbedBuilder();
                        noOne.setTitle("Oops!");
                        noOne.setDescription("There aren't any members with that name :(");
                        noOne.setColor(new Color(255, 0, 0));
                        noOne.setFooter("Created by This Guy", Splotchy.getUser().getAvatarUrl());
                        event.getChannel().sendTyping().queue();
                        event.getChannel().sendMessageEmbeds(noOne.build()).queue();
                        noOne.clear();
                    } else {
                        for (Member victim : victims) {
                            for (VoiceChannel vc : vcs) {
                                guild.moveVoiceMember(victim, vc).queue();
                                try {
                                    Thread.sleep(1200);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            guild.moveVoiceMember(victim, null).queue();
                        }
                    }
                } else {
                    EmbedBuilder incorrect = new EmbedBuilder();
                    incorrect.setTitle("Incorrect command!");
                    incorrect.setDescription("Use the Watcher Bot Prefix followed by the command name.");
                    incorrect.setColor(new Color(255, 0, 0));
                    incorrect.setFooter("Created by This Guy", Splotchy.getUser().getAvatarUrl());
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessageEmbeds(incorrect.build()).queue();
                    incorrect.clear();
                }
            }
        }
    }

//    private void punish(String[] args, Guild guild, GuildMessageReceivedEvent)
}
