package Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class WelcomeEvent extends ListenerAdapter {

   public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


      try {
         String message = event.getMessage().getContentRaw();
         if (message.equalsIgnoreCase("!update_bot")) {
            if (Objects.requireNonNull(event.getMember()).isOwner()) {
               event.getChannel().sendMessage("Enter the file path").queue();
               String path = event.getMessage().getContentRaw();
            }
         }
         File file = new File("path");
         Scanner scanner = new Scanner(file);
         String text = scanner.nextLine();
         if (message.equalsIgnoreCase("!file")) {
            //System.out.println("hiii");
            event.getChannel().sendMessage("**CinematicCow-SHOP** \n" + text).queue();

         }
         scanner.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      //event.getChannel().sendMessage(message);

   }


   public void onUserTyping(@Nonnull UserTypingEvent event) {

   }

   {

   }
}
