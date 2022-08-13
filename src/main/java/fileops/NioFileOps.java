package fileops;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author jatin.bansal on 13/08/22
 */
public class NioFileOps {
    public static void main(String[] args) {
        try (RandomAccessFile inFile = new RandomAccessFile("src/main/resources/file-reading.txt", "r");
             RandomAccessFile outFile = new RandomAccessFile("src/main/resources/file-writing.txt", "rw")) {
            FileChannel inChannel = inFile.getChannel();
            FileChannel outChannel = outFile.getChannel();
            long size = inChannel.size();
            System.out.println("size = " + size);
            inChannel.transferTo(0, size, outChannel);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
