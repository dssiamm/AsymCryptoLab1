package random_generators;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Library_gen {

    static void getBits() throws IOException{
        int k = 0;
        FileWriter wr = new FileWriter("library.txt");
        System.out.println("Library_gen(128 no 256");
        try (FileReader fr = new FileReader("C:\\Users\\fraps\\IdeaProjects\\AsymCryptoLab1\\src\\source_txt\\source.txt")) {
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
        wr.close();
    }
}
