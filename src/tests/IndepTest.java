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
        int kk = 0;
        int byte1 = 0;
        int byte2 = 0;

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if ((char) c == ' ' || (char) c == '\n')
                    continue;
                if(k <= 8) {
                    tempByte1 += (char) c;
                    k++; kk++;
                }
                else {
                    tempByte2 += (char) c;
                    k++; kk++;
                }
                if(k == 8) {
                    byte1 = Integer.parseInt(tempByte1, 2);
                }
                if(k == 17) {
                    byte2 = Integer.parseInt(tempByte2, 2);
                    k = 0;
                    bytePar[byte1][byte2]++;
                    tempByte1 = "";
                    tempByte2 = "";
                }
                if(kk == 1000000)
                    break;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        double X;
        double n = 0;
        double a = 0;
        double countIbit = 0;
        double countJbit = 0;

        for(int i = 0; i < 256; i++)
            for(int j = 0; j < 256; j++) {
                for(int m = 0; m < 256; m++) {
                    countIbit += bytePar[i][m];
                    countJbit += bytePar[m][j];
                }

                a += Math.pow(bytePar[i][j], 2) / ( countIbit * countJbit );
                countIbit = 0;
                countJbit = 0;
                n += bytePar[i][j];
            }

        a -= 1;
        X = n * a;
        double Xa;
        Xa = Math.sqrt(2 * Math.pow(255, 2)) * 1.2815515655 + Math.pow(255, 2);
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * Math.pow(255, 2)) * 2.326634787 + Math.pow(255, 2);
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * Math.pow(255, 2)) * 1.64485362 + Math.pow(255, 2);
        System.out.println(""+ X + " " + Xa);
    }

    public static void testQuabilityByte(String fileName) throws IOException {

        int bytePar[][] = new int[256][256];
        String tempByte1 = "";
        String tempByte2 = "";
        boolean another = true;
        int kk = 0;
        int byte1 = 0;
        int byte2 = 0;

        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) {
                if ((char) c == ' ' || (char) c == '\n') {
                    if(another && !tempByte1.equals("")) {
                        another = false;
                        byte1 = Integer.parseInt(tempByte1);
                        kk++;
                        if (kk == 1000000)
                            break;
                        continue;
                    }
                    if(!another && !tempByte2.equals("")){
                        another = true;
                        byte2 = Integer.parseInt(tempByte2);
                        tempByte1 = "";
                        tempByte2 = "";
                        bytePar[byte1][byte2]++;
                        kk++;
                        if (kk == 1000000)
                            break;
                        continue;
                    }
                }
                if(another && (char) c != ' ' && (char) c != '\n')
                    tempByte1 += (char) c;
                if(!another && (char) c != ' ' && (char) c != '\n')
                    tempByte2 += (char) c;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        double X;
        double n = 0;
        double a = 0;
        double countIbit = 0;
        double countJbit = 0;

        for(int i = 0; i < 256; i++)
            for(int j = 0; j < 256; j++) {
                for(int m = 0; m < 256; m++) {
                    countIbit += bytePar[i][m];
                    countJbit += bytePar[m][j];
                }

                if(countIbit == 0  || countJbit == 0 )
                    continue;
                a += Math.pow(bytePar[i][j], 2) / ( countIbit * countJbit );
                countIbit = 0;
                countJbit = 0;
                n += bytePar[i][j];
            }

        a -= 1;
        X = n * a;
        double Xa;
        Xa = Math.sqrt(2 * Math.pow(255, 2)) * 1.2815515655 + Math.pow(255, 2);
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * Math.pow(255, 2)) * 2.326634787 + Math.pow(255, 2);
        System.out.println(""+ X + " " + Xa);

        Xa = Math.sqrt(2 * Math.pow(255, 2)) * 1.64485362 + Math.pow(255, 2);
        System.out.println(""+ X + " " + Xa);
    }
}
