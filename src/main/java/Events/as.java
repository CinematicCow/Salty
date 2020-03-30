/*
public class FileEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {



        */
/*All the paths are here*//*

        String SPOTIFY_PATH = "enter path here";
        String MINECRAFT_PATH = "enter path here";
        String ORIGIN_PATH = "enter path here";

        */
/*All the file objects are here*//*

        File Minecraft = new File(MINECRAFT_PATH);
        File Spotify = new File(SPOTIFY_PATH);
        File Origin = new File(ORIGIN_PATH);

        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("!spotify")) {
            Scanner ss = null;
            try {
                ss = new Scanner(Spotify);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String data_spotify = ss.nextLine().trim();

            event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("sup")).queue();
            ss.close();

            FileDelete.delete(data_spotify.trim(), SPOTIFY_PATH);
        }

        if (message.equalsIgnoreCase("!minecraft")) {
            Scanner sm = null;
            try {
                sm = new Scanner(Minecraft);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String data_minecraft = sm.nextLine().trim();


            event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("sup")).queue();
            sm.close();

            FileDelete.delete(data_minecraft.trim(), MINECRAFT_PATH);
        }

        if (message.equalsIgnoreCase("!origin")) {
            Scanner sn = null;
            try {
                sn = new Scanner(Origin);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String data_origin = sn.nextLine().trim();


            event.getAuthor().openPrivateChannel().flatMap(privateChannel -> privateChannel.sendMessage("sup")).queue();
            sn.close();

            FileDelete.delete(data_origin.trim(), ORIGIN_PATH);
        }


    }
}
*/
