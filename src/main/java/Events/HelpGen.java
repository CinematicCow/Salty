package Events;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

public class HelpGen extends Command {
    public HelpGen(){
        this.name="help-gen";
        this.aliases=new String[]{"Help gen","help generator","gen"};
        this.help="Returns Help for Generating Related queries";
    }
    @Override
    public void execute(CommandEvent event){
        EmbedBuilder builder=new EmbedBuilder();

        builder.setTitle("How to generate accounts");
        builder.setColor(0xffff80);
        builder.setAuthor("To Generate ");
        builder.addField("","---Free Accounts---",  false);
        builder.addField("Nord-Vpn", "!nord", true);
        builder.addField("Hulu","!hulu", true);
        builder.addField("Origin","!origin", true);
       // builder.addField("Zenmate-Vpn","!zenmate", true);
       // builder.addField("Razer","!razer", true);
      //  builder.addField("ViaPlay.se","!viaplay", true);
       // builder.addField("Tunnel Bear Vpn","!tunnel", true);
        builder.addField("","---Premium Accounts---",  false);
        builder.addField("Pandora","!pandora", true);
        builder.addField("Minecraft","!minecraft", true);
        builder.addField("Full Access Mail","!mail", true);
        builder.addField("PSN","!psn", true);
        builder.addField("Crunchy Role","!crunchy", true);
        builder.addField("Uplay","!uplay", true);
      //  builder.addField("Vyvr-Vpn","!vyvr", true);
        builder.addField("Napster","!napster", true);
       // builder.addField("Instant-Gaming","!instant", true);
       // builder.addField("HBO","!hbo", true);
        builder.addField("Buffalo Wings","!buffalo", true);
       // builder.addField("Steam","!steam", true);
        builder.addField("Wish","!wish", true);
       // builder.addField("Adidas","!adidas", true);
        builder.addField("Twitter","!twitter", true);
        builder.addField("Steam","!steam", true);
        builder.addField("Spotify","!spotify", true);
        builder.addField("Fitbit","!fitbit", true);
        builder.addField("Call Of Duty","!cod", true);
        builder.setFooter("You can only generate accounts in their respective channels, or you will get an error, i.e to generate free accounts, you go to the free-generator and visa versa.");
        event.getChannel().sendMessage("It's simple to generate accounts. All you gotta do is go to the **Stocks Channel** and see the available accounts. \nThen go to the respective generator.").queue();
        event.getChannel().sendMessage(builder.build()).queue();

    }
}
