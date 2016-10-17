package random_generators;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Library_gen {
    private static String alphabetRus = "abcdefghijklmnopqrstuvwxyz";
    private static String alphabetBigRus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static void getBits() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/library.txt");
        System.out.println("Library_gen");
        try (FileReader fr = new FileReader("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/source.txt")) {
            int c;
            byte b;
            char a;
            while ((c = fr.read()) != -1)
                for (int i = 0; i < alphabetRus.length(); i++) {
                    if ((char) c == alphabetBigRus.charAt(i) || (char) c == alphabetRus.charAt(i)) {
                        a = (char) c;
                        b = (byte) a;
                        wr.write(b + " ");
                    }
                }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        wr.close();
    }
}
