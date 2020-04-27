package Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Random;


public class WantTo extends ListenerAdapter {
   public Color color(){
       Random random = new Random();
       final float hue = random.nextFloat();
       final float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
       final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
       Color color = Color.getHSBColor(hue, saturation, luminance);
       return color;
   }

   public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        EmbedBuilder wts=new EmbedBuilder();
        EmbedBuilder wtb =new EmbedBuilder();
        String[]msg=event.getMessage().getContentRaw().split("-");
        if(msg[0].equalsIgnoreCase("!wts")){
            if(event.getMember().getRoles().toString().contains("683611696337780745")||event.getMember().getRoles().toString().contains("681762390366355470")){
            if(msg.length != 3){

                wts.setTitle("🔴 Error");
                wts.setDescription("To use this command : \n`` !wts-<Thing you want to sell>-<Price>[N-Negotiable / NN-Non Negotiable] ``\n|| **For example** \n!wts-xyz accounts-$X N/NN");
                wts.setFooter("If you are still getting this error, please open a ticket, They'll get back to you soon");
                wts.setColor(Color.RED);
                event.getChannel().sendMessage(wts.build()).queue();
                return;
            }
            else {

//                String url="https://dummyimage.com/200x200/000/fff.jpg&text=".concat(msg[1]).replaceAll("\\s","%20");
                wts.setAuthor("🏪 Want To Sell 🏪");
                wts.setTitle(msg[1]);
                wts.setColor(Objects.requireNonNull(event.getMember()).getColor());
                wts.setDescription("Merchant :"+event.getAuthor().getAsMention()+"\nPrice :"+msg[2]);
                wts.setTimestamp(Instant.now());
                wts.setColor(color());
                wts.setFooter("DM его, чтобы начать переговоры");
            }

            Objects.requireNonNull(event.getJDA().getTextChannelById("704364043967660082")).sendMessage(wts.build()).queue();
        }
            else {
                    wts.setTitle("⚔ Denial ⚔");
                    wts.setDescription(event.getAuthor().getAsMention()+", you do not have the required permissions to access this feature");
                    wts.setColor(Color.RED);
                    wts.addField("Reason :","T access this feature you must have ***PREMIUM***",false);
                    wts.setFooter("If you think this message should not have appeared, please open a ticket.");
                    event.getChannel().sendMessage(wts.build()).queue();
            }
    }

       if(msg[0].equalsIgnoreCase("!wtb")){
           if(Objects.requireNonNull(event.getMember()).getRoles().toString().contains("683611696337780745")||event.getMember().getRoles().toString().contains("681762390366355470")){
               if(msg.length != 2){

                   wtb.setTitle("🔴 Error");
                   wtb.setDescription("To use this command : \n`` !wtb-<Thing you want to buy> ``\n|| **For example** \n!wtb-xyz accounts");
                   wtb.setFooter("If you are still getting this error, please open a ticket, They'll get back to you soon");
                   wtb.setColor(Color.RED);
                   event.getChannel().sendMessage(wts.build()).queue();
                   return;
               }
               else {

//                String url="https://dummyimage.com/200x200/000/fff.jpg&text=".concat(msg[1]).replaceAll("\\s","%20");
                   wtb.setAuthor("🛒 Want To Buy 🛒");
                   wtb.setTitle(msg[1]);
                   wtb.setDescription("Buyer :"+event.getAuthor().getAsMention());
                   wtb.setTimestamp(Instant.now());
                   wtb.setColor(color());
                   wtb.setFooter("DM его, чтобы начать переговоры");
               }

               Objects.requireNonNull(event.getJDA().getTextChannelById("704363995611660423")).sendMessage(wtb.build()).queue();
           }
           else {
               wtb.setTitle("⚔ Denial ⚔");
               wtb.setDescription(event.getAuthor().getAsMention()+", you do not have the required permissions to access this feature");
               wtb.setColor(Color.RED);
               wtb.addField("Reason :","T access this feature you must have ***PREMIUM***",false);
               wtb.setFooter("If you think this message should not have appeared, please open a ticket.");
               event.getChannel().sendMessage(wts.build()).queue();
           }
       }
}}
//!wts-Minecraft accounts-$10