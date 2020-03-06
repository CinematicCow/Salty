package Extensions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.Message;

import java.util.concurrent.TimeUnit;

public class Tester extends Command {

    public Tester() {
        this.name = "magic";
        this.aliases = new String[]{"magictrick,wow"};
        this.help = "Gives the information about the server";
    }

    @Override
    public void execute(CommandEvent event) {
        event.getChannel().sendTyping().delay(2, TimeUnit.SECONDS).completeAfter(1, TimeUnit.SECONDS);

        event.getChannel().sendMessage("magic it is!!").delay(3, TimeUnit.SECONDS).flatMap(Message::delete).queue();
        //event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendTyping().delay(1,TimeUnit.SECONDS)).queue();
        //event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("This message gonna diss.....!").delay(2, TimeUnit.SECONDS)).flatMap(Message::delete).queue();
    }

}