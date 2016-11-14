package tests;

import java.io.FileReader;
import java.io.IOException;

public class QuabilityTest {
    private static double avgCountOfBytes = 488.28125;
    private static double avgCountOfBytess = 3921.5686;

    public static void testQuability(String fileName) throws IOException {

        String tempByte = "";
        int k = 0;
        int arrInd = 0;
        int kValueArr[] = new int[125000];
        int countOfBytes[] = new int[256];

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if ((char) c == ' ' || (char) c == '\n')
                    continue;
                tempByte += (char) c;
                k++;
                if (k == 8) {
                    k = 0;
                    kValueArr[arrInd] = Integer.parseInt(tempByte, 2);

                    for (int i = 0; i < 256; i++)
                        if (kValueArr[arrInd] == i)
                            countOfBytes[i]++;

                    arrInd++;
                    if (arrInd == 125000)
                        break;
                    tempByte = "";
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        double X = 0;
        for (int i = 1; i < 255; i++) {
            X += Math.pow((countOfBytes[i] - avgCountOfBytes), 2) / avgCountOfBytes;
        }

        double Xa;
        Xa = Math.sqrt(2 * 255) * 0.1 + 255;
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * 255) * 0.01 + 255;
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * 255) * 0.05 + 255;
        System.out.println(""+ X + " " + Xa);
    }

    public static void testQuabilityByte(String fileName) throws IOException {

        boolean k = true;
        int arrInd = 0;
        int kValueArr[] = new int[1000000];
        int countOfBytes[] = new int[256];
        String temp = "1";

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if ((char) c == ' ' || (char) c == '\n') {
                    k = false;
                    continue;
                }
                if(!k){
                    kValueArr[arrInd] = Integer.parseInt(temp);
                    for (int i = 0; i < 256; i++)
                        if (kValueArr[arrInd] == i)
                            countOfBytes[i]++;
                    arrInd++;

                    if (arrInd == 1000000)
                        break;

                    temp = "";
                }
                k = true;
                temp += (char) c;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        double X = 0;
        for (int i = 1; i < 255; i++) {
            X += Math.pow((countOfBytes[i] - avgCountOfBytess), 2) / avgCountOfBytess;
        }

        double Xa;
        Xa = Math.sqrt(2 * 255) * 0.1 + 255;
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * 255) * 0.01 + 255;
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * 255) * 0.05 + 255;
        System.out.println(""+ X + " " + Xa);
    }







































































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
