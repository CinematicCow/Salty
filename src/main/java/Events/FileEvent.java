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
        EmbedBuilder steam = new EmbedBuilder();
        EmbedBuilder nord = new EmbedBuilder();

        /*All the paths are here*/
        String SPOTIFY_PATH = "Accounts/Nonworking-acc.txt";
        String STEAM_PATH = "Accounts/Nord-acc.txt";
        String NORD_PATH = "Accounts/Stezm_acc.txt";

        /*All the file objects are here*/
        File Steam = new File(STEAM_PATH);
        File Spotify = new File(SPOTIFY_PATH);
        File Nord = new File(NORD_PATH);

        /*This gets the message inputed on your channel to a variable*/
        String message = event.getMessage().getContentRaw();
        /***Channel Stuff along with some id's*/
        String channel_id=event.getChannel().getId().toString();
        String general_channel_id="676625827043213314";
        String delux_channel_id="683611441575624751";
        String preminum_channel_id="683611405932691459";
        String free_channel_id="683595742836817940";
        /***For Spotify **/
        if (message.equalsIgnoreCase("!spotify")) {
            Scanner ss = null;
            if(channel_id.equals(preminum_channel_id)||channel_id.equals(delux_channel_id)){
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
            //event.getChannel().sendMessage("Account sent on DM " + event.getAuthor().getAsMention()).queue();
            event.getChannel().sendMessage("Spotify Accounts are out of stock. \nPlease check back later or contact "+event.getGuild().getOwner().getAsMention()).queue();
                // event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(spotify.build())).queue();
            //event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("")).queue();

            //System.out.println(data);
            ss.close();
            // }
            FileDelete.delete(SPOTIFY_PATH);
        }
            else{
                event.getChannel().sendMessage("You cannot do that here "+event.getAuthor().getAsMention().toString()).queue();
            }
        }

        /***For Steam **/
            if(message.equalsIgnoreCase("!steam")) {
                Scanner sm = null;
                if (channel_id.equals(preminum_channel_id) || channel_id.equals(delux_channel_id)) {
                    try {
                        sm = new Scanner(Steam);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    String data_minecraft = sm.nextLine().trim();

                    // if (!event.getAuthor().isBot()) {
                    steam.setTitle(event.getGuild().getName(), "https://discord.gg/WcDpNQB");
                    steam.setThumbnail("https://www.pcgamesn.com/wp-content/uploads/2018/07/steam-logo-580x332.jpg");
                    steam.setColor(Color.CYAN);
                    steam.addField("STEAM", data_minecraft, true);
                    steam.addBlankField(true);
                    event.getChannel().sendMessage("Account sent on DM " + event.getAuthor().getAsMention()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(steam.build())).queue();

                    sm.close();
                    // }
                    FileDelete.delete(STEAM_PATH);
                } else {
                    event.getChannel().sendMessage("You cannot do that here " + event.getAuthor().getAsMention().toString()).queue();
                }
            }
             /***For NordVpn **/
            if (message.equalsIgnoreCase("!nordvpn")) {
                Scanner sn = null;
                if(!channel_id.equals(general_channel_id)) {

                        try {
                            sn = new Scanner(Nord);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        String data_nord = sn.nextLine().trim();


                        nord.setTitle(event.getGuild().getName(), "https://discord.gg/WcDpNQB");
                        nord.setThumbnail("https://thebestvpn.uk/wp-content/uploads/2015/06/NordVPN-review-1280x600-1024x480.png");
                        nord.setColor(Color.BLUE);
                        nord.addField("NORD VPN Account: ", data_nord, true);
                        nord.addBlankField(true);
                        event.getChannel().sendMessage("Account sent on DM to " + event.getAuthor().getAsMention()).queue();
                        event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(nord.build())).queue();
                        sn.close();

                        FileDelete.delete(NORD_PATH);
                    }
                else{
                    event.getChannel().sendMessage("You cannot do that here "+event.getAuthor().getAsMention().toString()).queue();
                }
                }


    }
}
