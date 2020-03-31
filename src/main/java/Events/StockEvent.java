package Events;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class StockEvent extends Command {

    public StockEvent() {
        this.name = "stock";
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
            spotify = Integer.toString(Extensions.StockEvent.stock(Spotify));
            steam = Integer.toString(Extensions.StockEvent.stock(Steam));
            nord = Integer.toString(Extensions.StockEvent.stock(Nord));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Stock Remaning : ");
          //  builder.addBlankField(true);
            builder.addField("**Spotify Accounts** \n```note these Spotify accounts are not working at the moment as they were added for testing purposes. New Accounts will be added soon !```", spotify, false);
            builder.addField("**Steam Accounts**", steam, false);
            builder.addField("**Nord-Vpn Accounts**", nord, false);

            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
