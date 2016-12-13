package random_generators;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Library_gen {

    static void getBits() throws IOException{
        FileWriter wr = new FileWriter("library.txt");
        System.out.println("Library_gen(128 no 256");

        String content = new Scanner(new File("source.txt")).useDelimiter("\\Z").next();
        byte[] bytes = content.getBytes();
        int[] stat = new int[bytes.length];
        for(int i = 0; i < stat.length; i++) {
            stat[i] = bytes[i] & 0xFF;
            wr.write(stat[i] + " ");
        }
        //k = bytes[i] & 0xFF;
        /*try (FileReader fr = new FileReader("source.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                wr.write(c + " ");
                k++;
                if ( k % 1000 == 0) {
                    wr.write("\n");
                    k = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        wr.close();*/
    }
}
