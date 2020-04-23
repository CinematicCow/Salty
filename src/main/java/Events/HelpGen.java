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
        event.getChannel().sendMessage("It's simple to generate accounts. All you gotta do is go to   #『\uD83D\uDCC8』stock『\uD83D\uDCC8』 and see the available accounts. \nThen go to the respective generator :").queue();
        EmbedBuilder builder=new EmbedBuilder();

        builder.setTitle("How to generate accounts");
        builder.setColor(0xffff80);
        builder.setAuthor("To Generate ");
        builder.addField("","---Free Accounts---",  false);
        builder.addField("Nord-Vpn", "!nord", true);
        builder.addField("Hulu","!hulu", true);
        builder.addField("Origin","!origin", true);
        builder.addField("","---Premium Accounts---",  false);
        builder.addField("IP-Vanish","!ipvanish", true);
        builder.addField("Minecraft","!minecraft", true);
        builder.addField("Domino's","!dominos", true);
        builder.addField("Spotify","!spotify", true);
        builder.addField("PSN","!psn", true);
        builder.addField("Steam","!steam", true);
        builder.setFooter("You can only generate accounts in their respective channels, or you will get an error, i.e to generate free accounts, you go to the free-generator and visa versa.");
        event.getChannel().sendMessage(builder.build()).queue();
    }
}
