package random_generators;


import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class BlumBlumShub_gen {
    private static final int bitsCount = 1000000;
    private static Random random = new Random();
    private static String mod = "256";
    private static String pValueString = "D5BBB96D30086EC484EBA3D7F9CAEB07";
    private static String qValueString = "425D2B9BFDB25B9CF6C416CC6E37B59C1F";

    static void bitVersion() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/blumblum_bit.txt");
        System.out.println("BlumBlumShub_gen");
        BigInteger pValue = new BigInteger(pValueString, 16);
        BigInteger qValue = new BigInteger(qValueString, 16);
        BigInteger n = pValue.multiply(qValue);

        long temp;
        temp = random.nextLong();
        if(temp <= 0) {
            temp += 1;
            temp *= -1;
        }

        BigInteger r = BigInteger.valueOf(temp);

        for(int i = 0; i < bitsCount; i++) {
            if(i % 1000 == 0)
                wr.write("\n");

            r = r.modPow(BigInteger.ONE.add(BigInteger.ONE), n);
            if (r.mod(BigInteger.ONE.add(BigInteger.ONE)).equals(BigInteger.ONE))
                wr.write("1");
            else
                wr.write("0");
        }
        wr.close();
    }

    static void byteVersion() throws IOException {
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/blumblum_byte.txt");
        System.out.println("BlumBlumShub_gen");
        BigInteger pValue = new BigInteger(pValueString, 16);
        BigInteger qValue = new BigInteger(qValueString, 16);
        BigInteger modValue = new BigInteger(mod, 10);
        BigInteger n = pValue.multiply(qValue);

        long temp;
        temp = random.nextLong();
        if(temp <= 0) {
            temp += 1;
            temp *= -1;
        }

        BigInteger r = BigInteger.valueOf(temp);

        for(int i = 0; i < bitsCount; i++) {
            if(i % 1000 == 0)
                wr.write("\n");
            r = r.modPow(BigInteger.ONE.add(BigInteger.ONE), n);
            wr.write(r.mod(modValue).toString() + " ");
        }
    wr.close();
    }
}
