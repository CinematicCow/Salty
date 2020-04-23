import Events.*;
import Extensions.Magic;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;

public class Bot {
    public static JDA jda;

    //    public static String prefix="!";
    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder(AccountType.BOT).setToken("NjgxMDQ3NzU4MzAzNzg5MTM1.Xod0WA.w4bN7lBdgnhJZW0IF5cOXALZf7Q").build();

        /*Client Builder Initalize for Misc*/
        CommandClientBuilder clientBuilder = new CommandClientBuilder();
        clientBuilder.setStatus(OnlineStatus.IDLE);
        clientBuilder.setActivity(Activity.playing("Testing Testing"));
        clientBuilder.setShutdownAutomatically(true);

        /*Client Builder Builder Commands*/
        clientBuilder.setPrefix("!");
        clientBuilder.setOwnerId("681047758303789135");
        clientBuilder.addCommand(new Magic());
        clientBuilder.addCommand(new StockEvent());
        clientBuilder.setHelpWord("helpme");
        CommandClient client = clientBuilder.build();

        /*Calling all methods via JDA*/
        jda.addEventListener(client);
        jda.addEventListener(new FileEvent());
        jda.addEventListener(new HelpEvents());
        jda.addEventListener(new PingEvent());
      //  jda.addEventListener(new ReactEvent());
    }
}
