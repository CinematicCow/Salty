package Events;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelpEvents extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String name = event.getMember().getUser().getName();
        String Message_sent = event.getMessage().getContentRaw();
        EmbedBuilder eb = new EmbedBuilder();
        if (Message_sent.equalsIgnoreCase("!help")) {
            if (!event.getMember().getUser().isBot()) {

                eb.setTitle("***Help for Salty***");
                eb.setColor(Color.CYAN);
                eb.addField("prefix", "!", true);
                //  eb.addField("","",false);
                eb.setAuthor(event.getGuild().getName().toString(), "https://discord.gg/WcDpNQB");
                eb.addField("To generate Spotify", " spotify", false);
                eb.addField("To generate Steam", " steam", false);
                eb.addField("To generate Nord Vpn", " nordvpn", false);
                eb.addField("To check the remaning stock of avilable accounts", " stock", false);
                eb.addField("To donate", " donate", false);
                //eb.addField("!edit_bot ", "to humiliate yourself", false);
                eb.addField("Useless commands list", " helpme", false);
                eb.setFooter("to execute a command '!command' WITHOUT SPACE is necessary to work" );
                eb.setFooter("All of the above commands will run on their specified channels" );
                eb.setThumbnail(event.getGuild().getIconUrl());
                event.getChannel().sendMessage(eb.build()).queue();

                // event.getChannel().sendMessage("Bugger off "+name+". I need some rest"+"\n"+"Come back later!").queue();
            }
        }
    }

}

