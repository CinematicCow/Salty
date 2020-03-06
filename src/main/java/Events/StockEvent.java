package Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

public class StockEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] mesasge = event.getMessage().getContentRaw().split(" ");
        long GC = 676625827043213312l;
        String spotify_path = "C:\\Users\\prajw\\Downloads\\combo.txt";
        String minecraft_path = "C:\\Users\\prajw\\Downloads\\100k_User_Pass_Gaming_Targetted_-_16.txt";
        String netflix_path = "C:\\Users\\prajw\\Downloads\\MINECRAFT_UNCHECKED.txt";
        File spotify_file = new File(spotify_path);
        File minecraft_file = new File(minecraft_path);
        File netflix_file = new File(netflix_path);
        int spotify_counter = 0;

        if (mesasge[0].equalsIgnoreCase("!stock") && mesasge[1].equalsIgnoreCase("spotify") && event.getChannel().equals(GC)) {
            event.getChannel().sendMessage("Spotify stock remaning : "/*+stock(spotify_path)*/).queue();
            System.out.println(event.getChannel().getName());
        }

    }

   /* public static int  stock(String path) throws IOException {

    }*/
}
