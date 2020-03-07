package Events;

import Extensions.FileDelete;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


        /*All the embeded builders objects are here */
        EmbedBuilder spotify = new EmbedBuilder();
        EmbedBuilder minecraft = new EmbedBuilder();
        EmbedBuilder origin = new EmbedBuilder();

        /*All the paths are here*/
        String SPOTIFY_PATH = "C:\\Users\\prajw\\Downloads\\text.txt";
        String MINECRAFT_PATH = "C:\\Users\\prajw\\Downloads\\text1.txt";
        String ORIGIN_PATH = "C:\\Users\\prajw\\Downloads\\text2.txt";

        /*All the file objects are here*/
        File Minecraft = new File(MINECRAFT_PATH);
        File Spotify = new File(SPOTIFY_PATH);
        File Origin = new File(ORIGIN_PATH);

        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("!spotify")) {
            Scanner ss = null;
            try {
                ss = new Scanner(Spotify);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String data_spotify = ss.nextLine().trim();

            // if (!event.getAuthor().isBot()) {
            //event.getChannel().sendMessage("here you go \n"+data).queue();
            spotify.setTitle(event.getGuild().getName(), "https://discord.gg/WcDpNQB");
            spotify.setThumbnail("https://techtalk.at/wp-content/uploads/2018/03/spotify-square.png");
            spotify.setColor(Color.RED);
            spotify.addField("Spotify", data_spotify, true);
            spotify.addBlankField(true);
            event.getChannel().sendMessage("Account sent on DM " + event.getAuthor().getAsMention()).queue();
            event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(spotify.build())).queue();

            //System.out.println(data);
            ss.close();
            // }
            FileDelete.delete(SPOTIFY_PATH);
        }

            if(message.equalsIgnoreCase("!minecraft")) {
                Scanner sm = null;
                try {
                    sm = new Scanner(Minecraft);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_minecraft = sm.nextLine().trim();

                // if (!event.getAuthor().isBot()) {
                minecraft.setTitle(event.getGuild().getName(), "https://discord.gg/WcDpNQB");
                minecraft.setThumbnail("http://minecrafterhelp.weebly.com/uploads/1/2/0/4/12046836/2170468_orig.png?151");
                minecraft.setColor(Color.green);
                minecraft.addField("Minecraft", data_minecraft, true);
                minecraft.addBlankField(true);
                event.getChannel().sendMessage("Account sent on DM " + event.getAuthor().getAsMention()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(minecraft.build())).queue();

                sm.close();
                // }
                FileDelete.delete(MINECRAFT_PATH);
            }

            if (message.equalsIgnoreCase("!origin")) {
                Scanner sn = null;
                try {
                    sn = new Scanner(Origin);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_origin = sn.nextLine().trim();


                origin.setTitle(event.getGuild().getName(), "https://discord.gg/WcDpNQB");
                origin.setThumbnail("https://2.bp.blogspot.com/-nNysw1fsLH4/Um6YOm2PPNI/AAAAAAAAB68/DIhBsjKVTQE/s1600/origin+logo+www.Battlefield247.Blogspot.com.png");
                origin.setColor(Color.ORANGE);
                origin.addField("Origin Account: ", data_origin, true);
                origin.addBlankField(true);
                event.getChannel().sendMessage("Account sent on DM to " + event.getAuthor().getAsMention()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(origin.build())).queue();
                sn.close();

                FileDelete.delete(ORIGIN_PATH);
            }


    }
}
