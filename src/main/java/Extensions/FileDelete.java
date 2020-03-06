package Extensions;

import java.io.*;
import java.util.Scanner;

public class FileDelete {
    public static void main(String[] args) {

        // String d=" funphenomenal:Time13                                                                                                                ";
        //  delete(d.trim(),"C:\\Users\\prajw\\Downloads\\100k_User_Pass_Gaming_Targetted_-_16.txt");
    }

    public static void delete(String removeTerm, String Filepath) {
        String tempFile = "temp.txt";
        File oldFile = new File(Filepath);
        File newFile = new File(tempFile);
        String has;
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            Scanner x = new Scanner(new File(Filepath));
            //  x.useDelimiter("[\n]");

            while (x.hasNext()) {
                has = x.next();

                if (!has.equals(removeTerm)) {
                    pw.println(has);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            boolean hasDelete = oldFile.delete();

            File dump = new File(Filepath);
            boolean has_renamed = newFile.renameTo(dump);
           /* if(hasDelete && has_renamed){
                System.out.println("Operation Sucessful !");
            }*/

        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
