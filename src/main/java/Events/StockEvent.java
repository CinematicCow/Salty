package Events;

import Extensions.StockExtension;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class StockEvent extends Command {

    public StockEvent() {
        this.name = "stonks";
        this.aliases = new String[]{"Stock,STOCK"};
        this.help = "returns the stock left ";
      //  this.requiredRole = "OWNER";


    }

    @Override
    public void execute(CommandEvent event) {
        String Spotify = "Accounts/Nonworking-acc.txt";
        String Steam = "Accounts/Stezm_acc.txt";
        String Nord = "Accounts/Nord-acc.txt";

        String spotify = null;
        String nord = null;
        String steam = null;
        try {
            spotify = Integer.toString(StockExtension.stock(Spotify));
            steam = Integer.toString(StockExtension.stock(Steam));
            nord = Integer.toString(StockExtension.stock(Nord));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("------Stock Remaning------");
          //  builder.addBlankField(true);
            builder.addField("**Spotify Accounts**", spotify +" :Spotify: ", true);
            builder.addField("**Steam Accounts**", steam, false);
            builder.addField("**Nord-Vpn Accounts**", nord, false);
                    event.getJDA().getTextChannelById("701858991994699777").sendMessage(builder.build()).queue();
           // event.getJDA().getTextChannelById("701858991994699777").sendMessage("```----Stocks Remaning------ \nSpotify: "+spotify+" :Spotify: ```").queue();

                if(Integer.parseInt(spotify)<15) {
                    String finalcount = spotify;
                    event.getGuild().getOwner().getUser().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("This is to remind you that you have to restock Spotify as there are only " + finalcount + " accounts left")).queue();
                }
            if(Integer.parseInt(steam)<15) {
                String finalcount = steam;
                event.getGuild().getOwner().getUser().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("This is to remind you that you have to restock Steam as there are only " + finalcount + " accounts left")).queue();
            }
            if(Integer.parseInt(nord)<15) {
                String finalcount = nord;
                event.getGuild().getOwner().getUser().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("This is to remind you that you have to restock Nord Vpn as there are only " + finalcount + " accounts left")).queue();
            }
        }
    }

}
