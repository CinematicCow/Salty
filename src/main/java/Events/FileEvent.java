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
        FileDelete fileobj = new FileDelete();

        /*All the embeded builders objects are here */
        EmbedBuilder spotify = new EmbedBuilder();
        EmbedBuilder minecraft = new EmbedBuilder();
        EmbedBuilder origin = new EmbedBuilder();

        /*All the paths are here*/
        String SPOTIFY_PATH = "C:\\Users\\prajw\\Downloads\\combo.txt";
        //  String MINECRAFT_PATH="C:\\Users\\prajw\\Downloads\\100k_User_Pass_Gaming_Targetted_-_16.txt";
        String ORIGIN_PATH = "C:\\Users\\prajw\\Downloads\\combo.txt";

        /*All the file objects are here*/
        // File Minecraft=new File(MINECRAFT_PATH);
        File Spotify = new File(SPOTIFY_PATH);
        File Origin = new File(ORIGIN_PATH);

        try {
            Scanner ss = new Scanner(Spotify);
            String data_spotify = ss.nextLine().trim();
            String message = event.getMessage().getContentRaw();

            if (message.equalsIgnoreCase("!spotify")) {
                if (event.getChannel().getName().equalsIgnoreCase("delux-generator") || event.getChannel().getName().equalsIgnoreCase("premium-generator")) {
                    if (!event.getAuthor().isBot()) {
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
                    }
                } else {
                    event.getChannel().sendMessage("You can't use this command here").queue();
                }
                FileDelete.delete(data_spotify.trim(), SPOTIFY_PATH);
            }

            /*Scanner sm=new Scanner(Minecraft);
            String data_minecraft=sm.nextLine().trim();
            if(message.equalsIgnoreCase("!minecraft")){
           if(event.getChannel().getName().equalsIgnoreCase("free-generator")) {
               if (!event.getAuthor().isBot()) {
                   minecraft.setTitle(event.getGuild().getName(), "https://discord.gg/WcDpNQB");
                   minecraft.setThumbnail("http://minecrafterhelp.weebly.com/uploads/1/2/0/4/12046836/2170468_orig.png?151");
                   minecraft.setColor(Color.green);
                   minecraft.addField("Minecraft", data_minecraft, true);
                   minecraft.addBlankField(true);
                   event.getChannel().sendMessage("Account sent on DM " + event.getAuthor().getAsMention()).queue();
                   event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(minecraft.build())).queue();

                   sm.close();

               }
           }
           else{event.getChannel().sendMessage("You can't use this command here").queue();}
                FileDelete.delete(data_minecraft.trim(),MINECRAFT_PATH);
            }*/

            Scanner sn = new Scanner(Origin);
            String data_origin = sn.nextLine().trim();
            if (message.equalsIgnoreCase("!origin")) {
                if (event.getChannel().getName().equalsIgnoreCase("free-generator")) {

                    origin.setTitle(event.getGuild().getName(), "https://discord.gg/WcDpNQB");
                    origin.setThumbnail("https://2.bp.blogspot.com/-nNysw1fsLH4/Um6YOm2PPNI/AAAAAAAAB68/DIhBsjKVTQE/s1600/origin+logo+www.Battlefield247.Blogspot.com.png");
                    origin.setColor(Color.ORANGE);
                    origin.addField("Origin Account: ", data_origin, true);
                    origin.addBlankField(true);
                    event.getChannel().sendMessage("Account sent on DM to " + event.getAuthor().getAsMention()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(origin.build())).queue();
                    sn.close();
                } else {
                    event.getChannel().sendMessage("You can't use this command here").queue();
                }
                FileDelete.delete(data_origin.trim(), ORIGIN_PATH);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void Embed() {
        EmbedBuilder builder = new EmbedBuilder();


    }
}
