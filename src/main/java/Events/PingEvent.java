package Events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String msg= event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase("!ping")){
            long time=System.currentTimeMillis();
            event.getChannel().sendMessage("pong ! __***MOTHERFUCKER***__  \n"+"||"+(System.currentTimeMillis()-time)+"ms||").queue();
        }
    }
}
