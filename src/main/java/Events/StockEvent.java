package Events;

import Extensions.StockExtension;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import net.dv8tion.jda.api.entities.Message;

import net.dv8tion.jda.api.entities.User;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StockEvent extends Command {

    public StockEvent() {
        this.name = "stonks";
        this.aliases=new String[]{"s","stock","inv"};
        this.help = "returns the stock left ";
      //  this.requiredRole = "OWNER";
        this.guildOnly=true;
    }

    @Override
    public void execute(CommandEvent event) {

        /*String Arrays || Datatables*/
            String[] name = {"Nord-Vpn", "Hulu", "Origin", "Razer", "Zenmate","Tunnel-Bear","Viaplay.se","Full Access Mail", "Crunchy Role", "Psn",  "Pandora", "Minecraft","Uplay","Vyvr-Vpn", "Napster","Buffalo Wings","Instant Gaming","HBO","Wish","Steam","Adidas","Twitter"};
            String[] path = {
                             "Accounts/Nord.txt",
                             "Accounts/Hulu.txt",
                             "Accounts/Origin.txt",
                             "Accounts/Razor.txt",
                             "Accounts/Zenmate.txt",
                             "Accounts/Tunnelbear.txt",
                             "Accounts/Viaplay.txt",
                             "Accounts/FullAccess.txt",
                             "Accounts/CrunchyRole.txt",
                             "Accounts/Psn.txt",
                             "Accounts/Pandora.txt",
                             "Accounts/Minecraft.txt",
                             "Accounts/Uplay.txt",
                             "Accounts/Vyvr-Vpn.txt",
                             "Accounts/Napster.txt",
                             "Accounts/Buffalowings.txt",
                             "Accounts/Instant-gaming.txt",
                             "Accounts/HBO.txt",
                             "Accounts/Wish.txt",
                             "Accounts/Steam.txt",
                             "Accounts/Adidas.txt",
                             "Accounts/Twitter.txt"

            };
             String[] stock = {null,null,null, null, null, null, null, null, null, null,null, null, null, null, null,null,null,null,null,null,null,null};
    
       
       try {
            stock[0] = Integer.toString(StockExtension.stock(path[0]));
            stock[1] = Integer.toString(StockExtension.stock(path[1]));
            stock[2] = Integer.toString(StockExtension.stock(path[2]));
            stock[3] = Integer.toString(StockExtension.stock(path[3]));
            stock[4] = Integer.toString(StockExtension.stock(path[4]));
            stock[5] = Integer.toString(StockExtension.stock(path[5]));
            stock[6] = Integer.toString(StockExtension.stock(path[6]));
            stock[7] = Integer.toString(StockExtension.stock(path[7]));
            stock[8] = Integer.toString(StockExtension.stock(path[8]));
            stock[9] = Integer.toString(StockExtension.stock(path[9]));
            stock[10] = Integer.toString(StockExtension.stock(path[10]));
            stock[11] = Integer.toString(StockExtension.stock(path[11]));
            stock[12] = Integer.toString(StockExtension.stock(path[12]));
            stock[13] = Integer.toString(StockExtension.stock(path[13]));
            stock[14] = Integer.toString(StockExtension.stock(path[14]));
            stock[15] = Integer.toString(StockExtension.stock(path[15]));
            stock[16] = Integer.toString(StockExtension.stock(path[16]));
            stock[17] = Integer.toString(StockExtension.stock(path[17]));
            stock[18] = Integer.toString(StockExtension.stock(path[18]));
            stock[19] = Integer.toString(StockExtension.stock(path[19]));
            stock[20] = Integer.toString(StockExtension.stock(path[20]));
            stock[21] = Integer.toString(StockExtension.stock(path[21]));



        } catch (IOException e) {
            e.printStackTrace();
        } finally {

           List<Message> messages = event.getJDA().getTextChannelById("706204277521252373").getHistory().retrievePast(2).complete();
           event.getJDA().getTextChannelById("706204277521252373").deleteMessages(messages).queue();
           /*Embeded Builder for Stock Display*/
           EmbedBuilder builder = new EmbedBuilder();
           builder.setAuthor( event.getGuild().getName() , "https://discord.gg/WcDpNQB");
           builder.setThumbnail(event.getGuild().getIconUrl());
           builder.setTitle("_Stock Remaning_");
           builder.setColor(0xd30438);
           builder.setDescription("Below are the amount of accounts we have in our storehouse. If you want to see/add  more accounts here, please contact the staff.");
           builder.addField("","```                 Free Accounts ```",false);
           builder.addField("**"+name[0]+"** \nAccounts" +": ", stock[0], true);
           builder.addField("**"+name[1]+"** \nAccounts" +": ", stock[1], true);
           builder.addField("**"+name[2]+"** \nAccounts" +": ", stock[2], true);
           builder.addField("**"+name[3]+"** \nAccounts" +": ", stock[3], true);
           builder.addField("**"+name[4]+"** \nAccounts" +": ", stock[4], true);
           builder.addField("**"+name[5]+"** \nAccounts" +": ", stock[5], true);
           builder.addField("**"+name[6]+"** \nAccounts" +": ", stock[6], true);
           builder.addField("","```                Premium Accounts ```",false);
           builder.addField("**"+name[7]+"** \nAccounts" +": ", stock[7], true);
           builder.addField("**"+name[8]+"** \nAccounts" +": ", stock[8], true);
           builder.addField("**"+name[9]+"** \nAccounts" +": ", stock[9], true);
           builder.addField("**"+name[10]+"** \nAccounts" +": ", stock[10], true);
           builder.addField("**"+name[11]+"** \nAccounts" +": ", stock[11], true);
           builder.addField("**"+name[12]+"** \nAccounts" +": ", stock[12], true);
           builder.addField("**"+name[13]+"** \nAccounts" +": ", stock[13], true);
           builder.addField("**"+name[14]+"** \nAccounts" +": ", stock[14], true);
           builder.addField("**"+name[15]+"** \nAccounts" +": ", stock[15], true);
           builder.addField("**"+name[16]+"** \nAccounts" +": ", stock[16], true);
           builder.addField("**"+name[17]+"** \nAccounts" +": ", stock[17], true);
           builder.addField("**"+name[18]+"** \nAccounts" +": ", stock[18], true);
           builder.addField("**"+name[19]+"** \nAccounts" +": ", stock[19], true);
           builder.addField("**"+name[20]+"** \nAccounts" +": ", stock[20], true);
           builder.addField("**"+name[21]+"** \nAccounts" +": ", stock[21], true);
           event.getJDA().getTextChannelById("706204277521252373").sendMessage(builder.build()).queue();

               }
        }
    }

