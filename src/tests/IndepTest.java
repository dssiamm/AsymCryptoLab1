package tests;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dssiam on 01.11.16.
 */
public class IndepTest {

    public static void testQuability(String fileName) throws IOException {

        int bytePar[][] = new int[256][256];
        String tempByte1 = "";
        String tempByte2 = "";
        int k = 0;
        int byte1 = 0;
        int byte2 = 0;


        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if ((char) c == ' ' || (char) c == '\n')
                    continue;
                if(k <= 8) {
                    tempByte1 += (char) c;
                    k++;
                }
                else {
                    tempByte2 += (char) c;
                    k++;
                }
                if(k == 8) {
                    byte1 = Integer.parseInt(tempByte1, 2);
                }
                if(k == 16) {
                    byte2 = Integer.parseInt(tempByte2, 2);
                    k = 0;
                    bytePar[byte1][byte2]++;
                    tempByte1 = "";
                    tempByte2 = "";
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
