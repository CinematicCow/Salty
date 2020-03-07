package Extensions;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDelete {

    public static void delete(String fileName) {
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            //Initial write position
            long writePosition = raf.getFilePointer();
            raf.readLine();
            // Shift the next lines upwards.
            long readPosition = raf.getFilePointer();

            byte[] buff = new byte[1024];
            int n;
            while (-1 != (n = raf.read(buff))) {
                raf.seek(writePosition);
                raf.write(buff, 0, n);
                readPosition += n;
                writePosition += n;
                raf.seek(readPosition);
            }
            raf.setLength(writePosition);
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
