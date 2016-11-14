package tests;

import java.io.FileReader;
import java.io.IOException;

public class QuabilityTest {
    private static double avgCountOfBytes = 488.28125;

    public static void testQuability(String fileName) throws IOException{

        String tempByte = "";
        int k = 0;
        int arrInd = 0;
        int kValueArr[] = new int[125000];
        int countOfBytes[] = new int[256];

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if((char) c == ' ' || (char) c == '\n')
                    continue;
                tempByte += (char) c;
                k++;
                if(k == 8) {
                    k = 0;
                    kValueArr[arrInd] = Integer.parseInt(tempByte, 2);

                    for(int i = 0; i < 256; i++)
                        if(kValueArr[arrInd] == i)
                            countOfBytes[i]++;

                    arrInd++;
                    if(arrInd == 125000)
                        break;
                    tempByte = "";
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        double X = 0;
        for(int i = 0; i < 255; i++){
            X += Math.pow( ( countOfBytes[i] - avgCountOfBytes ), 2 ) / avgCountOfBytes;
        }
        System.out.print("" + X + " ");

        double Xa = 0;
        Xa = Math.sqrt( 2*256 ) * 0.01 + 256;
        System.out.println("" + Xa);
        if(X <= Xa)
            System.out.println("1 OK");
        else
            System.out.println("1 NO");







































































        /*Byte[] byteArr = new Byte[125000];
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

        System.out.println(bytes);*/
    }
}
