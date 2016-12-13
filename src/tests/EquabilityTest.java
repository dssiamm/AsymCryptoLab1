package tests;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dssiam on 15.11.16.
 */
public class EquabilityTest {

    public static void testQuability(String fileName) throws IOException {

        int k = 0;
        int m = 5000;
        int arrId = 0;
        String tempbyte = "";
        int massByte[] = new int[125000];

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if ((char) c == ' ' || (char) c == '\n')
                    continue;

                tempbyte += "" + (char) c;
                k++;
                if(k == 8) {
                    massByte[arrId] = Integer.parseInt(tempbyte, 2);
                    tempbyte = "";
                    arrId++;
                    if(arrId == 125000)
                        break;
                    k = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        int countByte = 0;
        int countByteR = 0;
        int n = 125000;
        double X = 0;
        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 25; j++){
                for(int t = 0; t < massByte.length; t++) {
                    if (i == massByte[t])
                        countByte++;
                    if (t >= j * m && t < j * m + m)
                        if (i == massByte[t])
                            countByteR++;
                }
                X += Math.pow(countByteR, 2) / ( countByte * m );
                countByte = 0;
                countByteR = 0;
            }
        }
        X -= 1;
        X *= n;

        int l = 255 * 24;
        double Xa;
        Xa = Math.sqrt(2*l)*1.2815515655 + l;
        System.out.println(X + " " + Xa);

        Xa = Math.sqrt(2*l)*2.326634787 + l;
        System.out.println(X + " " + Xa);

        Xa = Math.sqrt(2*l)*1.64485362 + l;
        System.out.println(X + " " + Xa);
    }

    public static void testQuabilityByte(String fileName) throws IOException {

        int m = 25000;
        int arrId = 0;
        boolean kk = true;
        String tempbyte = "1";
        int massByte[] = new int[1000000];

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if ((char) c == ' ' || (char) c == '\n') {
                    kk = false;
                    continue;
                }
                if(!kk){
                    massByte[arrId] = Integer.parseInt(tempbyte);
                    arrId++;

                    if (arrId == 1000000)
                        break;

                    tempbyte = "";
                }
                kk = true;
                tempbyte += (char) c;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        int countByte = 0;
        int countByteR = 0;
        int n = 1000000;
        double X = 0;
        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 40; j++){
                for(int t = 0; t < massByte.length; t++) {
                    if (i == massByte[t])
                        countByte++;
                    if (t >= j * m && t < j * m + m)
                        if (i == massByte[t])
                            countByteR++;
                }
                if( countByte == 0)
                    continue;
                X += Math.pow(countByteR, 2) / ( countByte );
                countByte = 0;
                countByteR = 0;
            }
        }
        X = X /m;
        X -= 1;
        X *= n;

        int l = 255 * 39;
        double Xa;
        Xa = Math.sqrt(2*l)*1.2815515655 + l;
        System.out.println(X + " " + Xa);

        Xa = Math.sqrt(2*l)*2.326634787 + l;
        System.out.println(X + " " + Xa);

        Xa = Math.sqrt(2*l)*1.64485362 + l;
        System.out.println(X + " " + Xa);
    }
}
