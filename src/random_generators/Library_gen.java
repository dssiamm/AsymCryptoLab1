package random_generators;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Library_gen {

    static void getBits() throws IOException{
        int k = 0;
        FileWriter wr = new FileWriter("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/library.txt");
        System.out.println("Library_gen");
        try (FileReader fr = new FileReader("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/source.txt")) {
            int c;
            byte b;
            char a;
            while ((c = fr.read()) != -1) {
                a = (char) c;
                b = (byte) a;
                wr.write(b + " ");
                k++;
                if ( k % 1000 == 0) {
                    wr.write("\n");
                    k = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        wr.close();
    }
}
