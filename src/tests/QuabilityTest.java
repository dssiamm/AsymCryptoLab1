package tests;


import java.io.FileReader;
import java.io.IOException;

public class QuabilityTest {
    private static FileReader rf;

    public static void testQuability(String fileName) throws IOException{
        Byte[] byteArr = new Byte[125000];
        int k = 0;
        int k1 = 0;
        int kByte = 0;
        String bytes = "";
        String tempB = "";

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if((char) c == ' ' || (char) c == '\n')
                    continue;
                tempB += (char) c;
                k++;
                k1++;
                if(k == 7) {
                    byteArr[kByte] = Byte.parseByte(tempB, 2);
                    k = 0;
                    tempB = "";
                    //kByte++;
                }
                if(k1 == 8)
                    kByte++;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        for(int i = 0; i < 10000; i++) {
            System.out.print(byteArr[i] + " ");
        }

        System.out.println(bytes);
    }
}
