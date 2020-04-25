package Events;

import Extensions.FileDelete;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.graalvm.compiler.hotspot.replacements.HubGetClassNode;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class FileEvent extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


        /*All the embeded builders objects are here */
        EmbedBuilder mail = new EmbedBuilder();
        EmbedBuilder steam = new EmbedBuilder();
        EmbedBuilder nord = new EmbedBuilder();
        EmbedBuilder dominos = new EmbedBuilder();
        EmbedBuilder hulu = new EmbedBuilder();
        EmbedBuilder psn = new EmbedBuilder();
        //EmbedBuilder origin = new EmbedBuilder();
        EmbedBuilder ipvansih = new EmbedBuilder();
        EmbedBuilder minecraft = new EmbedBuilder();
        EmbedBuilder errorMsg= new EmbedBuilder();
        EmbedBuilder sent= new EmbedBuilder();

        /*All the paths are here*/
        String MAIL_PATH =      "Accounts/FullAccess.txt";
        String STEAM_PATH =     "Accounts/Steam.txt";
        String NORD_PATH =      "Accounts/Nord.txt";
        String DOMINOS_PATH=    "Accounts/Dominos.txt";
        String HULU_PATH=       "Accounts/Hulu.txt";
        String PSN_PATH=        "Accounts/Psn.txt";
        String IPVANISH_PATH=   "Accounts/IPvanish.txt";
        String MINECRAFT_PATH=  "Accounts/Minecraft.txt";

        /*All the file objects are here*/
        File Steam = new File(STEAM_PATH);
        File Mail = new File(MAIL_PATH);
        File Nord = new File(NORD_PATH);
        File Dominos = new File(DOMINOS_PATH);
        File Hulu = new File(HULU_PATH);
        File Psn = new File(PSN_PATH);
        //File Origin = new File(ORIGIN_PATH);
        File Ipvanish = new File(IPVANISH_PATH);
        File Minecraft=new File(MINECRAFT_PATH);

        /*This gets the message inputed on your channel to a variable*/
        String message=event.getMessage().getContentRaw();

        /*Channel Stuff along with some id's*/
        String channel_id=event.getChannel().getId().toString();

        /*Messages*/
        String freeMsg="Thanks for using "+event.getGuild().getName()+"'s Services "+event.getAuthor().getName()+". Contact Staff if this account is not working.";
        String paidMsg="Thanks for using "+event.getGuild().getName()+"'s premium services "+event.getAuthor().getName()+". Contact Staff if this account is not working.";

        errorMsg.setColor(Color.RED);
        errorMsg.setTitle("⚔ Error ⚔");
        errorMsg.setDescription(event.getAuthor().getAsMention()+" You cannot generate that here or you do not have the required permissions");
        errorMsg.setFooter("If you think this should not have happened please contact the staff");

        sent.setColor(Color.green);
        sent.setTitle("🟢 Successfully Sent");
        sent.setDescription(event.getAuthor().getAsMention()+"Your requested account was sent to via DM");

/************************************************````````````PAID````````````*********************************************/

        /***For Mail **/  /*Paid*/
        if (message.equalsIgnoreCase("!mail"))/*Then Why The Fuck Is It Not Working Here?*/  {
            Scanner ss = null;
            if(channel_id.equals("701870798088044665")||channel_id.equals("676627317669494785")){
            try {
                ss = new Scanner(Mail);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String data_mail = ss.nextLine().trim();

            mail.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
            mail.setThumbnail("https://www.salesforce.com/content/dam/blogs/ca/Blog%20Posts/digital-direct-mail-og.png");
            mail.setColor(Color.RED);
            mail.addField("Full Access Mail Account ", data_mail, true);
            mail.setFooter(paidMsg,event.getGuild().getIconUrl());

            event.getChannel().sendMessage(sent.build()).queue();
            event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(mail.build())).queue();

            //System.out.println(data);
            ss.close();
            // }
            FileDelete.delete(MAIL_PATH);
        }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Steam **/   /*Paid*/
            if(message.equalsIgnoreCase("!steam")) {
                Scanner sm = null;
                if(channel_id.equals("701870798088044665")||channel_id.equals("676627317669494785")){
                    try {
                        sm = new Scanner(Steam);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    String data_steam = sm.nextLine().trim();

                    // if (!event.getAuthor().isBot()) {
                    steam.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    steam.setTitle("Try using this account here ", "https://store.steampowered.com/login/");
                    steam.setThumbnail("https://www.pcgamesn.com/wp-content/uploads/2018/07/steam-logo-580x332.jpg");
                    steam.setColor(Color.CYAN);
                    steam.addField("STEAM", data_steam, true);
                    steam.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(steam.build())).queue();

                    sm.close();
                    // }
                    FileDelete.delete(STEAM_PATH);
                } else {
                    event.getChannel().sendMessage(errorMsg.build()).queue();
                }
            }

        /***For Dominoz **/  /*Paid*/
        if (message.equalsIgnoreCase("!dominos")) {
            Scanner ss = null;
            if(channel_id.equals("701870798088044665")||channel_id.equals("676627317669494785")){
                try {
                    ss = new Scanner(Dominos);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_dominos = ss.nextLine().trim();

                // if (!event.getAuthor().isBot()) {
                //event.getChannel().sendMessage("here you go \n"+data).queue();
                dominos.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                dominos.setTitle("Try using this account here ", "https://www.dominos.com/en/");
                dominos.setThumbnail("https://1000logos.net/wp-content/uploads/2017/08/Domino%E2%80%99s-symbol.jpg");
                dominos.setColor(0xFF0000);
                dominos.addField("Domino's Account",data_dominos, true);
                dominos.setFooter(paidMsg,event.getGuild().getIconUrl());
                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(dominos.build())).queue();


                //System.out.println(data);
                ss.close();
                // }
                FileDelete.delete(DOMINOS_PATH);
            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For PSN **/  /*Paid*/
        if (message.equalsIgnoreCase("!psn")) {
            Scanner ss = null;
            if(channel_id.equals("701870798088044665")||channel_id.equals("676627317669494785")){
                try {
                    ss = new Scanner(Psn);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_psn = ss.nextLine().trim();

                // if (!event.getAuthor().isBot()) {
                //event.getChannel().sendMessage("here you go \n"+data).queue();
                psn.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                psn.setTitle("Try using this account here ", "https://auth.api.sonyentertainmentnetwork.com/login.jsp?service_entity=psn&request_theme=liquid");
                psn.setThumbnail("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn3-www.playstationlifestyle.net%2Fassets%2Fuploads%2F2019%2F04%2Fplaystation-network-listing-thumb-03-en-24oct18_1540473503370_960x540.png&f=1&nofb=1");
                psn.setColor(Color.BLUE);
                psn.addField("PSN Account",data_psn, true);
                psn.setFooter(paidMsg,event.getGuild().getIconUrl());
                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(psn.build())).queue();


                //System.out.println(data);
                ss.close();
                // }
                FileDelete.delete(PSN_PATH);
            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For IP-Vanish **/  /*Paid*/
        if (message.equalsIgnoreCase("!ipvanish")) {
            Scanner ss = null;
            if(channel_id.equals("701870798088044665")||channel_id.equals("676627317669494785")){
                try {
                    ss = new Scanner(Ipvanish);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_ipvanish = ss.nextLine().trim();

                // if (!event.getAuthor().isBot()) {
                //event.getChannel().sendMessage("here you go \n"+data).queue();
                ipvansih.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                ipvansih.setTitle("Try using this account here ", "https://account.ipvanish.com/login");
                ipvansih.setThumbnail("https://account.ipvanish.com/assets/img/logo.png");
                ipvansih.setColor(0x85ff54);
                ipvansih.addField("IP Vanish Account",data_ipvanish, true);
                ipvansih.setFooter(paidMsg,event.getGuild().getIconUrl());
                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(ipvansih.build())).queue();


                //System.out.println(data);
                ss.close();
                // }
                FileDelete.delete(IPVANISH_PATH);
            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Minecraft **/  /*Paid*/
        if (message.equalsIgnoreCase("!minecraft")) {
            Scanner ss = null;
            if(channel_id.equals("701870798088044665")||channel_id.equals("676627317669494785")){
                try {
                    ss = new Scanner(Minecraft);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_minecraft = ss.nextLine().trim();

                minecraft.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                minecraft.setTitle("Try using this account here ", "https://my.minecraft.net/en-us/login/");
                minecraft.setThumbnail("http://minecrafterhelp.weebly.com/uploads/1/2/0/4/12046836/2170468_orig.png?151");
                minecraft.setColor(Color.green);
                minecraft.addField("Minecraft Account",data_minecraft, true);
                minecraft.setFooter(paidMsg,event.getGuild().getIconUrl());
                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(minecraft.build())).queue();


                //System.out.println(data);
                ss.close();
                // }
                FileDelete.delete(MINECRAFT_PATH);
            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

/************************************************````````````FREE````````````*********************************************/

        /***For NordVpn **/  /*Free*/
        if (message.equalsIgnoreCase("!nord")) {
            Scanner sn = null;
            if(channel_id.equals("702137079798431744")||channel_id.equals("676627317669494785")) {

                try {
                    sn = new Scanner(Nord);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_nord = sn.nextLine().trim();


                nord.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                nord.setTitle("Try using this account here ", "https://ucp.nordvpn.com/login/");
                nord.setThumbnail("https://thebestvpn.uk/wp-content/uploads/2015/06/NordVPN-review-1280x600-1024x480.png");
                nord.setColor(Color.BLUE);
                nord.addField("NORD VPN Account: ", data_nord, true);
                nord.setFooter(freeMsg,event.getGuild().getIconUrl());
                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(nord.build())).queue();
                sn.close();

                FileDelete.delete(NORD_PATH);
            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Hulu **/  /*Free*/
        if (message.equalsIgnoreCase("!hulu")) {
            Scanner ss = null;
            if(channel_id.equals("702137079798431744")||channel_id.equals("676627317669494785")){
                try {
                    ss = new Scanner(Hulu);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_hulu = ss.nextLine().trim();

                // if (!event.getAuthor().isBot()) {
                //event.getChannel().sendMessage("here you go \n"+data).queue();
                hulu.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                hulu.setTitle("Try using this account here ", "https://auth.hulu.com/web/login?next=http://secure.hulu.com/account");
                hulu.setThumbnail("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe4%2FHulu_Logo.svg%2F1200px-Hulu_Logo.svg.png&f=1&nofb=1");
                hulu.setColor(Color.GREEN);
                hulu.addField("HULU Account",data_hulu, true);
                hulu.setFooter(freeMsg,event.getGuild().getIconUrl());
                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(hulu.build())).queue();


                //System.out.println(data);
                ss.close();
                // }
                FileDelete.delete(HULU_PATH);
            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

       /* *//***For Origin **//*  *//*Free*//*
        if (message.equalsIgnoreCase("!origin")) {
            Scanner ss = null;
            if(channel_id.equals("702137079798431744")||channel_id.equals("676627317669494785")){
                try {
                    ss = new Scanner(Origin);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String data_origin = ss.nextLine().trim();

                // if (!event.getAuthor().isBot()) {
                //event.getChannel().sendMessage("here you go \n"+data).queue();
                origin.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                origin.setTitle("Try using this account here ", "https://signin.ea.com/p/originX/login?execution=e1688357639s1&initref=https%3A%2F%2Faccounts.ea.com%3A443%2Fconnect%2Fauth%3Fresponse_type%3Dcode%26client_id%3DORIGIN_SPA_ID%26display%3DoriginXWeb%252Flogin%26locale%3Den_US%26release_type%3Dprod%26redirect_uri%3Dhttps%253A%252F%252Fwww.origin.com%252Fviews%252Flogin.html");
                origin.setThumbnail("https://2.bp.blogspot.com/-nNysw1fsLH4/Um6YOm2PPNI/AAAAAAAAB68/DIhBsjKVTQE/s1600/origin+logo+www.Battlefield247.Blogspot.com.png");
                origin.setColor(0xe35f0e);
                origin.addField("ORIGIN Account",data_origin, true);
                origin.setFooter(freeMsg,event.getGuild().getIconUrl());
                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(origin.build())).queue();


                //System.out.println(data);
                ss.close();
                // }
                FileDelete.delete(ORIGIN_PATH);
            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }*/


    }
}
