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
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class FileEvent extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


        /*All the embeded builders objects are here */
        EmbedBuilder mail = new EmbedBuilder();
        EmbedBuilder cr = new EmbedBuilder();
        EmbedBuilder nord = new EmbedBuilder();
        EmbedBuilder hulu = new EmbedBuilder();
        EmbedBuilder psn = new EmbedBuilder();
        EmbedBuilder origin = new EmbedBuilder();
        EmbedBuilder ipvansih = new EmbedBuilder();
        EmbedBuilder minecraft = new EmbedBuilder();
        EmbedBuilder napster = new EmbedBuilder();
        EmbedBuilder razer=new EmbedBuilder();
        EmbedBuilder vyvr=new EmbedBuilder();
        EmbedBuilder zenmate=new EmbedBuilder();
        EmbedBuilder uplay=new EmbedBuilder();
        EmbedBuilder buffalo=new EmbedBuilder();
        EmbedBuilder hbo=new EmbedBuilder();
        EmbedBuilder instant=new EmbedBuilder();
        EmbedBuilder tunnelbear=new EmbedBuilder();
        EmbedBuilder wish=new EmbedBuilder();
        EmbedBuilder viaplay=new EmbedBuilder();
        EmbedBuilder steam=new EmbedBuilder();
        EmbedBuilder adidas=new EmbedBuilder();
        EmbedBuilder twitter=new EmbedBuilder();
        EmbedBuilder errorMsg= new EmbedBuilder();
        EmbedBuilder sent= new EmbedBuilder();
        EmbedBuilder sorry =new EmbedBuilder();


        /*All the paths are here*/
        String MAIL_PATH =      "Accounts/FullAccess.txt";
        String CR_PATH =        "Accounts/CrunchyRole.txt";
        String NORD_PATH =      "Accounts/Nord.txt";
        String TWITTER_PATH=    "Accounts/Twitter.txt";
        String HULU_PATH=       "Accounts/Hulu.txt";
        String PSN_PATH=        "Accounts/Psn.txt";
        String IPVANISH_PATH=   "Accounts/IPvanish.txt";
        String MINECRAFT_PATH=  "Accounts/Minecraft.txt";
        String ORIGIN_PATH=     "Accounts/Origin.txt";
        String NAPSTER_PATH=     "Accounts/Napster.txt";
        String RAZER_PATH=     "Accounts/Razor.txt";
        String ZENMATE_PATH=     "Accounts/Zenmate.txt";
        String VYVR_PATH=     "Accounts/Vyvr-Vpn.txt";
        String UPLAY_PATH=    "Accounts/Uplay.txt";
        String BUFFALO_PATH=    "Accounts/Buffalowings.txt";
        String HBO_PATH=    "Accounts/HBO.txt";
        String INSTANT_PATH=    "Accounts/Instant-gaming.txt";
        String TUNNELBEAR_PATH=    "Accounts/Tunnelbear.txt";
        String WISH_PATH=    "Accounts/Wish.txt";
        String VIAPLAY_PATH=    "Accounts/Viaplay.txt";
        String STEAM_PATH=    "Accounts/Steam.txt";
        String ADIDAS_PATH=    "Accounts/Adidas.txt";


        /*All the file objects are here*/
        File Cr = new File(CR_PATH);
        File Mail = new File(MAIL_PATH);
        File Nord = new File(NORD_PATH);
        //File Dominos = new File(DOMINOS_PATH);
        File Hulu = new File(HULU_PATH);
        File Psn = new File(PSN_PATH);
        File Origin = new File(ORIGIN_PATH);
        File Ipvanish = new File(IPVANISH_PATH);
        File Minecraft=new File(MINECRAFT_PATH);
        File Napster=new File(NAPSTER_PATH);
        File Vyvr=new File(VYVR_PATH);
        File Zenmate=new File(ZENMATE_PATH);
        File Razer=new File(RAZER_PATH);
        File Uplay=new File(UPLAY_PATH);
        File Buffalo=new File(BUFFALO_PATH);
        File Hbo=new File(HBO_PATH);
        File Instant=new File(INSTANT_PATH);
        File Tunnelbear=new File(TUNNELBEAR_PATH);
        File Wish=new File(WISH_PATH);
        File Viaplay=new File(VIAPLAY_PATH);
        File Steam=new File(STEAM_PATH);
        File Twitter=new File(TWITTER_PATH);
        File Adidas=new File(ADIDAS_PATH);


        /*This gets the message inputed on your channel to a variable*/
        String message=event.getMessage().getContentRaw();

        /*Channel Stuff along with some id's*/
        String channel_id=event.getChannel().getId().toString();

        /*Messages*/
        String freeMsg="Thanks for using "+event.getGuild().getName()+"'s Services "+event.getAuthor().getName()+". Contact Staff if this account is not working.";
        String paidMsg="Thanks for using "+event.getGuild().getName()+"'s premium services "+event.getAuthor().getName()+". Contact Staff if this account is not working.";

        errorMsg.setColor(Color.RED);
        errorMsg.setTitle("🔴 Error");
        errorMsg.setDescription(event.getAuthor().getAsMention()+" You cannot generate that here or you do not have the required permissions");
        errorMsg.setFooter("If you think this should not have happened please contact the staff");

        sent.setColor(Color.green);
        sent.setTitle("🟢 Successfully Sent");
        sent.setDescription(event.getAuthor().getAsMention()+"Your requested account was sent to via DM");

        sorry.setColor(Color.BLACK);
        sorry.setTitle("So Sorry");
        sorry.setDescription(event.getAuthor().getAsTag()+", The account you are looking for is currently not avilabe with us.\nTo know more please check the stocks on our server");
        sorry.setFooter("If you think this should not have happened, please contact the staff");

        /************************************************````````````PAID````````````*********************************************/

       /***For Mail **/
        if (message.equalsIgnoreCase("!mail")) {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
            try {
                ss = new Scanner(Mail);
                String data_mail = ss.nextLine().trim();

                mail.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                mail.setThumbnail("https://positivecoach.org/media/521921/email.gif");
                mail.setColor(Color.RED);
                mail.addField("Full Access Mail Account ", data_mail, true);
                mail.setFooter(paidMsg,event.getGuild().getIconUrl());

                event.getChannel().sendMessage(sent.build()).queue();
                event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(mail.build())).queue();

                //System.out.println(data);
                ss.close();
                // }
                FileDelete.delete(MAIL_PATH);
            }  catch (NoSuchElementException | FileNotFoundException e) {
                if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                   event.getChannel().sendMessage(sorry.build()).queue();}
                else e.printStackTrace();
            }

        }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Crunchy Role **/
            if(message.equalsIgnoreCase("!crunchy")) {
                Scanner sm = null;
                if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                    try {
                        sm = new Scanner(Cr);
                        String data_cr = sm.nextLine().trim();

                        // if (!event.getAuthor().isBot()) {
                        cr.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                        cr.setTitle("Try using this account here ", "https://www.crunchyroll.com/login");
                        cr.setThumbnail("https://cdn.dribbble.com/users/1818304/screenshots/6240772/dribbble.gif");
                        cr.setColor(0xff9a3b);
                        cr.addField("Crunchy Role", data_cr, true);
                        cr.setFooter(paidMsg,event.getGuild().getIconUrl());
                        event.getChannel().sendMessage(sent.build()).queue();
                        event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(cr.build())).queue();

                        sm.close();
                        // }
                        FileDelete.delete(CR_PATH);
                    } catch (NoSuchElementException | FileNotFoundException e) {
                        if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                         else e.printStackTrace();
                        }

                } else {
                    event.getChannel().sendMessage(errorMsg.build()).queue();
                }
            }


        /***For Adidas **/  /*Paid*/
        if (message.equalsIgnoreCase("!adidas")) {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Adidas);
                    String data_adidas = ss.nextLine().trim();

                    // if (!event.getAuthor().isBot()) {
                    //event.getChannel().sendMessage("here you go \n"+data).queue();
                    adidas.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    adidas.setTitle("Try using this account here ", "https://www.adidas.com/us/account-login");
                    adidas.setThumbnail("https://cdn.dribbble.com/users/392441/screenshots/2606850/adidas.gif");
                    adidas.setColor(Color.BLACK);
                    adidas.addField("Adidas Account",data_adidas, true);
                    adidas.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(adidas.build())).queue();


                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(ADIDAS_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For PSN **/
        if (message.equalsIgnoreCase("!psn")) {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Psn);
                    String data_psn = ss.nextLine().trim();

                    // if (!event.getAuthor().isBot()) {
                    //event.getChannel().sendMessage("here you go \n"+data).queue();
                    psn.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    psn.setTitle("Try using this account here ", "https://auth.api.sonyentertainmentnetwork.com/login.jsp?service_entity=psn&request_theme=liquid");
                    psn.setThumbnail("https://thumbs.gfycat.com/HardPiercingEastrussiancoursinghounds-max-1mb.gif");
                    psn.setColor(Color.BLUE);
                    psn.addField("PSN Account",data_psn, true);
                    psn.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(psn.build())).queue();


                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(PSN_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For IP-Vanish **/
        if (message.equalsIgnoreCase("!ipvanish")) {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Ipvanish);
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
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Minecraft **/
        if (message.equalsIgnoreCase("!minecraft")) {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Minecraft);
                    String data_minecraft = ss.nextLine().trim();

                    minecraft.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    minecraft.setTitle("Try using this account here ", "https://my.minecraft.net/en-us/login/");
                    minecraft.setThumbnail("https://4.bp.blogspot.com/-7BcY3Lh0gng/UBBePooBAPI/AAAAAAAAAxw/WqRdaCCkbiM/s1600/minecraft+band.gif");
                    minecraft.setColor(Color.green);
                    minecraft.addField("Minecraft Account",data_minecraft, true);
                    minecraft.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(minecraft.build())).queue();


                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(MINECRAFT_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Napster **/
        if (message.equalsIgnoreCase("!napster"))  {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Napster);
                    String data_napster = ss.nextLine().trim();

                    napster.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    napster.setThumbnail("https://66.media.tumblr.com/0d0997ac9e1e7962a75ce86bc8f77f01/tumblr_nwt7b22bGc1snv52fo1_500.gif");
                    napster.setTitle("Try it here","https://app.napster.com/login/?goto=/&c=us&l=en");
                    napster.setColor(Color.BLACK);
                    napster.addField("Napster Account", data_napster, true);
                    napster.setFooter(paidMsg,event.getGuild().getIconUrl());

                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(napster.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(NAPSTER_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Vyvr-Vpn **/
        if (message.equalsIgnoreCase("!vyvr"))  {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Vyvr);
                    String data_vyvr = ss.nextLine().trim();

                    vyvr.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    vyvr.setThumbnail("https://freedomhacker.net/wp-content/uploads/2013/09/Interview-with-VyprVPN.jpg");
                    vyvr.setTitle("Try it here","https://www.vyprvpn.com/login");
                    vyvr.setColor(0xfff200);
                    vyvr.addField("Vyvr Vpn", data_vyvr, true);
                    vyvr.setFooter(paidMsg,event.getGuild().getIconUrl());

                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(vyvr.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(VYVR_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Uplay **/
        if (message.equalsIgnoreCase("!uplay"))  {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Uplay);
                    String data_uplay = ss.nextLine().trim();

                    uplay.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    uplay.setThumbnail("https://thumbs.gfycat.com/PlaintiveGloomyFieldspaniel-size_restricted.gif");
                    uplay.setTitle("Try it here","https://lb-prod-accountmgmt-pdc.ubisoft.com/en-US/login");
                    uplay.setColor(0x039dfc);
                    uplay.addField("Uplay Account", data_uplay, true);
                    uplay.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(uplay.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(UPLAY_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Buffalo wings **/
        if (message.equalsIgnoreCase("!buffalo"))  {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Buffalo);
                    String data_buffalo = ss.nextLine().trim();

                    buffalo.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    buffalo.setThumbnail("https://mms.businesswire.com/media/20180829005405/en/675463/23/Buffalo-Wild-Wings-Logo.jpg");
                    buffalo.setTitle("Try it here","https://www.buffalowildwings.com/en/account/log-in/");
                    buffalo.setColor(0x8B4513);
                    buffalo.addField("Buffalo Wild Wings", data_buffalo, true);
                    buffalo.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(buffalo.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(BUFFALO_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Hbo **/
        if (message.equalsIgnoreCase("!hbo"))  {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Hbo);
                    String data_hbo = ss.nextLine().trim();

                    hbo.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    hbo.setThumbnail("https://66.media.tumblr.com/681efcdb57d24c395b880e85e86e46bc/tumblr_my4jzimHkB1qznlbio1_400.gif");
                    //uplay.setTitle("Try it here","https://www.buffalowildwings.com/en/account/log-in/");
                    hbo.setColor(0x808080);
                    hbo.addField("HBO account ", data_hbo, true);
                    hbo.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(hbo.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(HBO_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Instant gaming **/
        if (message.equalsIgnoreCase("!instant"))  {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Instant);
                    String data_instant = ss.nextLine().trim();

                    instant.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    instant.setThumbnail("https://i.ytimg.com/vi/gCNB1GTTQsc/hqdefault.jpg");
                    instant.setTitle("Try it here","https://www.instant-gaming.com/en/");
                    instant.setColor(0xff944d);
                    instant.addField("Instant Gaming  account ", data_instant, true);
                    instant.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(instant.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(INSTANT_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Wish **/
        if (message.equalsIgnoreCase("!wish")) {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Wish);
                    String data_wish = ss.nextLine().trim();

                    wish.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    wish.setTitle("Try it here","https://merchant.wish.com/login");
                    wish.setThumbnail("https://cdn.dribbble.com/users/88429/screenshots/4151215/wish-3x4.gif");
                    wish.setColor(0x26dde0);
                    wish.addField("Wish Account ", data_wish, true);
                    wish.setFooter(paidMsg,event.getGuild().getIconUrl());

                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(wish.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(WISH_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Steam **/
        if (message.equalsIgnoreCase("!steam"))  {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Steam);
                    String data_steam = ss.nextLine().trim();

                    steam.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    steam.setThumbnail("https://i2.wp.com/windowscustomization.com/wp-content/uploads/2018/11/steam-neon-logo.gif  ");
                    steam.setTitle("Try it here","https://store.steampowered.com/login/");
                    steam.setColor(0x5552b3);
                    steam.addField("Steam account ", data_steam, true);
                    steam.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(steam.build())).queue();

                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(STEAM_PATH);
                }  catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Twitter **/
        if (message.equalsIgnoreCase("!twitter")) {
            Scanner ss = null;
            if(channel_id.equals("716275240044593152")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Twitter);
                    String data_twitter = ss.nextLine().trim();

                    twitter.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    twitter.setTitle("Try using this account here ", "https://twitter.com/login/");
                    twitter.setThumbnail("http://cumberlandhotel.net.au/wp-content/uploads/2016/08/twitter.gif");
                    twitter.setColor(0xDA1F2);
                    twitter.addField("Twitter Account",data_twitter, true);
                    twitter.setFooter(paidMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(twitter.build())).queue();


                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(TWITTER_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }
/************************************************````````````FREE````````````*********************************************/

           /***For NordVpn **/ /*Free*/
        if (message.equalsIgnoreCase("!nord")) {
            Scanner sn = null;
            if(channel_id.equals("716275306956193839")||channel_id.equals("707311400292450415")) {

                try {
                    sn = new Scanner(Nord);
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
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Hulu **/
        if (message.equalsIgnoreCase("!hulu")) {
            Scanner ss = null;
            if(channel_id.equals("716275306956193839")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Hulu);
                    String data_hulu = ss.nextLine().trim();

                    // if (!event.getAuthor().isBot()) {
                    //event.getChannel().sendMessage("here you go \n"+data).queue();
                    hulu.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    hulu.setTitle("Try using this account here ", "https://auth.hulu.com/web/login?next=http://secure.hulu.com/account");
                    hulu.setThumbnail("https://images.squarespace-cdn.com/content/v1/52a11797e4b05f836261a40b/1496169348385-TIS8CKFNC0DD2W3A4F9Y/ke17ZwdGBToddI8pDm48kLxnK526YWAH1qleWz-y7AFZw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVH-2yKxPTYak0SCdSGNKw8A2bnS_B4YtvNSBisDMT-TGt1lH3P2bFZvTItROhWrBJ0/hulu_gradient2.gif");
                    hulu.setColor(0x3DBB3D);
                    hulu.addField("HULU Account",data_hulu, true);
                    hulu.setFooter(freeMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(hulu.build())).queue();


                    //System.out.println(data);
                    ss.close();
                    // }
                    FileDelete.delete(HULU_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Origin **/
        if (message.equalsIgnoreCase("!origin")) {
            Scanner ss = null;
            if(channel_id.equals("716275306956193839")||channel_id.equals("707311400292450415")){
                try {
                    ss = new Scanner(Origin);
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
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Razer **/
        if (message.equalsIgnoreCase("!razer")) {
            Scanner sn = null;
            if(channel_id.equals("716275306956193839")||channel_id.equals("707311400292450415")) {

                try {
                    sn = new Scanner(Razer);
                    String data_razer = sn.nextLine().trim();


                    razer.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    razer.setTitle("Try using this account here ", "https://razerid.razer.com/");
                    razer.setThumbnail("https://linustechtips.com/main/uploads/monthly_2017_08/razer_loop.gif.889f887d89a62a5d0641b00a6702854b.gif");
                    razer.setColor(0x53ff30);
                    razer.addField("Razer Account: ", data_razer, true);
                    razer.setFooter(freeMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(razer.build())).queue();
                    sn.close();

                    FileDelete.delete(RAZER_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Zenmate **/
        if (message.equalsIgnoreCase("!zenmate")) {
            Scanner sn = null;
            if(channel_id.equals("716275306956193839")||channel_id.equals("707311400292450415")) {

                try {
                    sn = new Scanner(Zenmate);
                    String data_zenmate = sn.nextLine().trim();


                    zenmate.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    zenmate.setTitle("Try using this account here ", "https://account.zenmate.com/login");
                    zenmate.setThumbnail("https://tenor.com/view/steam-gif-5833555");
                    zenmate.setColor(0x6effec);
                    zenmate.addField("ZENMATE  VPN Account: ", data_zenmate, true);
                    zenmate.setFooter(freeMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(zenmate.build())).queue();
                    sn.close();

                    FileDelete.delete(ZENMATE_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For Tunnelbear **/
        if (message.equalsIgnoreCase("!tunnel")) {
            Scanner sn = null;
            if(channel_id.equals("716275306956193839")||channel_id.equals("707311400292450415")) {

                try {
                    sn = new Scanner(Tunnelbear);
                    String data_tunnel = sn.nextLine().trim();


                    tunnelbear.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    tunnelbear.setTitle("Try using this account here ", "https://www.tunnelbear.com/account/login");
                    tunnelbear.setThumbnail("https://venturebeat.com/wp-content/uploads/2018/04/yummy-logins-ee5ddb3.gif");
                    tunnelbear.setColor(Color.yellow);
                    tunnelbear.addField("Tunnel Bear Vpn  Account: ", data_tunnel, true);
                    tunnelbear.setFooter(freeMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(tunnelbear.build())).queue();
                    sn.close();

                    FileDelete.delete(TUNNELBEAR_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

        /***For viaplay **/
        if (message.equalsIgnoreCase("!viaplay")) {
            Scanner sn = null;
            if(channel_id.equals("716275306956193839")||channel_id.equals("707311400292450415")) {

                try {
                    sn = new Scanner(Viaplay);
                    String data_viaplay= sn.nextLine().trim();


                    viaplay.setAuthor(event.getGuild().getName(),"https://discord.gg/JyBPnnq");
                    viaplay.setTitle("Try using this account here ", "https://account.zenmate.com/login");
                    viaplay.setThumbnail("https://pro2-bar-s3-cdn-cf2.myportfolio.com/98ad8927-039f-4a76-a8a7-d2ede54bbafc/d1448ca9-1ca1-49b4-85c3-802f4e80ad3b_car_4x3.gif");
                    viaplay.setColor(Color.magenta);
                    viaplay.addField("Viaplay.se Account: ", data_viaplay, true);
                    viaplay.setFooter(freeMsg,event.getGuild().getIconUrl());
                    event.getChannel().sendMessage(sent.build()).queue();
                    event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage(viaplay.build())).queue();
                    sn.close();

                    FileDelete.delete(VIAPLAY_PATH);
                } catch (NoSuchElementException | FileNotFoundException e) {
                    if(e.toString().startsWith("java.util.NoSuchElementException: No line found")){
                       event.getChannel().sendMessage(sorry.build()).queue();}
                    else e.printStackTrace();
                }

            }
            else{
                event.getChannel().sendMessage(errorMsg.build()).queue();
            }
        }

    }
}