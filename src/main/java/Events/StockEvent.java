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
        this.requiredRole = "OWNER";

    }

    @Override
    public void execute(CommandEvent event) {
        String path1 = "C:\\Users\\prajw\\Downloads\\text.txt";
        String path2 = "C:\\Users\\prajw\\Downloads\\text1.txt";
        String path3 = "C:\\Users\\prajw\\Downloads\\text2.txt";

        String spotify = null;
        String minecraft = null;
        String origin = null;
        try {
            spotify = Integer.toString(Extensions.StockEvent.stock(path1));
            minecraft = Integer.toString(Extensions.StockEvent.stock(path2));
            origin = Integer.toString(Extensions.StockEvent.stock(path3));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EmbedBuilder builder = new EmbedBuilder();
            builder.addField("Stock remaning", "", false);
            builder.addBlankField(true);
            builder.addField("Spotify", spotify, true);
            builder.addField("Minecraft", minecraft, true);
            builder.addField("Origin", origin, true);

            event.getChannel().sendMessage(builder.build()).queue();
        }
    }
}
