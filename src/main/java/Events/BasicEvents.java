package Events;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BasicEvents extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String name = event.getMember().getUser().getName();
        String Message_sent = event.getMessage().getContentRaw();
        if (Message_sent.equalsIgnoreCase("hey") || Message_sent.equalsIgnoreCase("hi") || Message_sent.equalsIgnoreCase("hello") || Message_sent.equalsIgnoreCase("hola")) {
            if (!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("what you want nigga? :person_bouncing_ball: ").queue();
                System.out.println(event.getChannel().getPosition());

            }
        }
        if (Message_sent.equalsIgnoreCase("!donate")) {
            if (!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("Donate here : \n https://www.paypal.me/PrajwalKakkar69").queue();
                event.getChannel().sendTyping().queue();

            }
        }
        if (Message_sent.equalsIgnoreCase("!edit_bot")) {
            if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                event.getChannel().sendMessage("You can edit the bot if you want but I won't allow you to mess with my internals, \nBECAUSE " + event.getMember().getAsMention() + ", YOU DISGUST ME!").queue();
            } else {
                event.getChannel().sendMessage("Well, " + event.getMember().getAsMention() + " you do not have any special priviliges so why don't you bugger off!!!! :person_running:").queue();
            }
        }
        if (Message_sent.equalsIgnoreCase("!funny")) {
            if (!event.getAuthor().isBot())
                event.getMessage().addReaction("U+1F606").queue();
        }


    }


}
