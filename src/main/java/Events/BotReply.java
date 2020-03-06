package Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotReply extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String name = event.getMember().getUser().getName();
        String Message_sent = event.getMessage().getContentRaw();
        //if(Message_sent.equalsIgnoreCase("hey")||Message_sent.equalsIgnoreCase("hi")||Message_sent.equalsIgnoreCase("hello")||Message_sent.equalsIgnoreCase("hola")){
        // if(Message_sent.equalsIgnoreCase("Fu**ed @Javabot to death.:joy:"))
        if (event.getAuthor().isBot()) {
            if (!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("STFU NIGGA").queue();
            }
        }
    }

    //}
    public void onUserTyping(UserTypingEvent event) {
        String name = event.getMember().getUser().getName();
        event.getChannel().sendMessage("OMFGOD " + name + " types so SLOW!");
    }
}
