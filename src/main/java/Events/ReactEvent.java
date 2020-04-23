package Events;

import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class ReactEvent extends ListenerAdapter {

    public void onGenericGuildMessageReaction(GenericGuildMessageReactionEvent event){
        if(event.getReaction().getMessageIdLong()== 702644878177206273L){
         /*  event.getReaction().removeReaction(Objects.requireNonNull(event.getUser())).queue();*/
            event.getChannel().sendMessage(event.getReactionEmote().getEmote().getId()).queue();

            }

        }

    }



