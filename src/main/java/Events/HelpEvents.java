package Events;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelpEvents extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String name = event.getMember().getUser().getName();
        String Message_sent = event.getMessage().getContentRaw();
        EmbedBuilder embed = new EmbedBuilder();
        if (Message_sent.equalsIgnoreCase("!help")) {
            if (!event.getMember().getUser().isBot()) {

                embed.setTitle("Salty");
                embed.setDescription("HELP ");
                embed.setColor(0x6818fc);
                embed.setAuthor("🔥Lamentable Flame🔥", "https://discord.gg/JyBPnnq");
                embed.setThumbnail(event.getGuild().getIconUrl());
                embed.addField("-For help regarding generating accounts", "!help-gen", false);
                embed.addField("-To check my ping", "!ping", false);
                embed.addField("-To donate (well everyone knows,you'll not)", "!donate [btc/paypal/other]", false);
                embed.addField("-The most useless command ever", "!helpme", false);
                embed.addField("-To check remaning stock", "!stonks (This command is only avilabe on stocks channel)", false);
                embed.setFooter("If something is not working properly with me, don't hesitate to contact my creator CinematicCow");
                event.getChannel().sendMessage(embed.build()).queue();

            }
        }
    }

}

