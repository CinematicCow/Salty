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

                eb.setTitle("Help for Javabot");
                eb.setColor(Color.CYAN);
                eb.addField("prefix", "!", false);
                //  eb.addField("","",false);
                eb.setAuthor("CinematicCow#8325", "https://discord.gg/WcDpNQB", "https://i.pinimg.com/736x/6c/fa/a9/6cfaa9135276c3a207e560f67953fa0e.jpg");
                eb.addField("for Spotify", "spotify", false);
                eb.addField("for Minecraft", "minecraft", false);
                eb.addField("for Netflix", "netflix", false);
                eb.addField("to donate", "donate", false);
                eb.addField("!edit_bot ", "to humiliate yourself", false);
                eb.setFooter("to execute a command !command without space is necessary to work", "https://www.snopes.com/tachyon/2007/09/ermeypress.jpg?fit=1080,540");
                eb.setImage("https://www.snopes.com/tachyon/2007/09/ermeypress.jpg?fit=1080,540");
                eb.setThumbnail("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FZS_P8oEjxTA%2Fmaxresdefault.jpg&f=1&nofb=1");
                event.getChannel().sendMessage(eb.build()).queue();

                // event.getChannel().sendMessage("Bugger off "+name+". I need some rest"+"\n"+"Come back later!").queue();
            }
        }
    }

}

