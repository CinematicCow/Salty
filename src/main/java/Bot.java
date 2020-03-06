import Events.FileEvent;
import Events.HelpEvents;
import Extensions.Tester;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;

public class Bot {
    public static JDA jda;

    //    public static String prefix="!";
    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder(AccountType.BOT).setToken("Enter Token here").build();

        CommandClientBuilder clientBuilder = new CommandClientBuilder();
        clientBuilder.setActivity(Activity.listening("for your next command"));
        clientBuilder.setShutdownAutomatically(true);

        clientBuilder.setPrefix("!");
        clientBuilder.setOwnerId("Enter bot Id here");
        clientBuilder.addCommand(new Tester());
        clientBuilder.setHelpWord("helpme");
        CommandClient client = clientBuilder.build();

        //   jda.addEventListener(new BotReply());
        jda.addEventListener(new FileEvent());
        jda.addEventListener(client);
        //jda.addEventListener(new BasicEvents());
        jda.addEventListener(new HelpEvents());
        //jda.addEventListener(new StockEvent());
        //      jda.addEventListener(new WelcomeEvent());
    }

    public static void onReady(ReadyEvent event) {
        System.out.println("bot is ready");
        System.out.println(event.getJDA().getToken());
    }
}
