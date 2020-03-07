package Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StockEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] mesasge = event.getMessage().getContentRaw().split(" ");
        String msg = event.getMessage().getContentRaw();
        long GC = 676625827043213312l;
        String spotify_path = "C:\\Users\\prajw\\Downloads\\text.txt";
        String minecraft_path = "C:\\Users\\prajw\\Downloads\\100k_User_Pass_Gaming_Targetted_-_16.txt";
        String netflix_path = "C:\\Users\\prajw\\Downloads\\MINECRAFT_UNCHECKED.txt";
      /*  File spotify_file = new File(spotify_path);
        File minecraft_file = new File(minecraft_path);
        File netflix_file = new File(netflix_path);*/


        if (msg.equalsIgnoreCase("!stock")/* && mesasge[1].equalsIgnoreCase("spotify")*/) {
            try {
                event.getChannel().sendMessage("Spotify stock remaning : " + Extensions.StockEvent.stock(spotify_path)).queue();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(event.getChannel().getName());

        }
    }
}
