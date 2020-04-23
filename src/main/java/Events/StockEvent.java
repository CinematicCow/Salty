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
        this.aliases = new String[]{"Stock,STOCK"};
        this.help = "returns the stock left ";
      //  this.requiredRole = "OWNER";
        this.guildOnly=true;
    }

    @Override
    public void execute(CommandEvent event) {

        /*String Arrays || Datatables*/
            String[] name = {"Nord-Vpn", "Hulu", "Origin", "Domino's", "Steam", "Psn", "Origin", "Ip-vansih", "Minecraft"};
            String[] path = {
                             "Accounts/Nord-acc.txt",
                             "Accounts/Stezm_acc.txt",
                             "Accounts/testing.txt",
                             "Accounts/testing.txt",
                             "Accounts/testing.txt",
                             "Accounts/testing.txt",
                             "Accounts/Nonworking-acc.txt",
                             "Accounts/testing.txt",
                             "Accounts/testing.txt"
            };
             String[] stock = {null, null, null, null, null, null, null, null,null};
    
       
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

           List<Message> messages = event.getJDA().getTextChannelById("702601231398600865").getHistory().retrievePast(2).complete();
           event.getJDA().getTextChannelById("702601231398600865").deleteMessages(messages).queue();
           /*Embeded Builder for Stock Display*/
           EmbedBuilder builder = new EmbedBuilder();
           builder.setAuthor("   🔥" + event.getGuild().getName() + "🔥", "https://discord.gg/WcDpNQB");
           builder.setThumbnail(event.getGuild().getIconUrl());
           builder.setTitle("_Stock Remaning_");
           builder.setColor(0xd30438);
           builder.setDescription("Below are the amount of accounts we have in our storehouse. If you want to see/add  more accounts here, please contact the staff.");
           builder.addField("","```                 Free Accounts ```",false);
           builder.addField("**"+name[0]+"** Accounts" +": ", stock[0], true);
           builder.addField("**"+name[1]+"** Accounts" +": ", stock[1], true);
           builder.addField("**"+name[2]+"** Accounts" +": ", stock[2], true);
           builder.addField("","```                Premium Accounts ```",false);
           builder.addField("**"+name[3]+"** Accounts" +": ", stock[3], true);
           builder.addField("**"+name[4]+"** Accounts" +": ", stock[4], true);
           builder.addField("**"+name[5]+"** Accounts" +": ", stock[5], true);
           builder.addField("**"+name[6]+"** Accounts" +": ", stock[6], true);
           builder.addField("**"+name[7]+"** Accounts" +": ", stock[7], true);
           builder.addField("**"+name[8]+"** Accounts" +": ", stock[8], true);
           event.getJDA().getTextChannelById("702601231398600865").sendMessage(builder.build()).queue();

               }
        }
    }

