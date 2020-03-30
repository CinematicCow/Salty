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
        String Spotify = "C:\\Users\\prajw\\IdeaProjects\\JavaBot\\Accounts\\Nonworking-acc.txt";
        String Steam = "C:\\Users\\prajw\\IdeaProjects\\JavaBot\\Accounts\\Stezm_acc.txt";
        String Nord = "\"C:\\Users\\prajw\\IdeaProjects\\JavaBot\\Accounts\\Nord-acc.txt\"";

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
            builder.addField("Stock remaning", "", false);
            builder.addBlankField(true);
            builder.addField("Spotify", "0", true);
            builder.addField("Steam", steam, true);
            builder.addField("Nord-Vpn", nord, true);

            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
