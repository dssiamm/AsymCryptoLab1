package random_generators;


import java.io.FileReader;
import java.io.IOException;

public class Library_gen {
    private static String alphabetRus = "abcdefghijklmnopqrstuvwxyz";
    private static String alphabetBigRus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static void getBits() {
        System.out.println("\nLibrary_gen");
        try (FileReader fr = new FileReader("C:\\Users\\fraps\\IdeaProjects\\AsymCryptoLab1\\src\\source_txt\\source.txt")) {
            int c;
            byte b;
            char a;
            while ((c = fr.read()) != -1)
                for (int i = 0; i < alphabetRus.length(); i++) {
                    if ((char) c == alphabetBigRus.charAt(i) || (char) c == alphabetRus.charAt(i)) {
                        a = (char) c;
                        b = (byte) a;
                        System.out.print(b + " ");
                    }
                }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
