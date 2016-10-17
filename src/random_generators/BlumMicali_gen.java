package random_generators;


import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class BlumMicali_gen {
    private static final int bitsCount = 100;
    private static Random random = new Random();
    private static BigInteger T;
    private static final BigInteger byteConst = new BigInteger("256", 10);
    private static String pValueString = "CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3";
    private static String aValueString = "5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356";

    static void bitVersion() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/blummicali_bit.txt");
        System.out.println("\nBlumMicali_gen");
        BigInteger pValue = new BigInteger(pValueString, 16);
        BigInteger aValue = new BigInteger(aValueString, 16);

        long temp;
        temp = random.nextLong();
        if(temp <= 0) {
            temp += 1;
            temp *= -1;
        }

        T = BigInteger.valueOf(temp);
        for(int i = 0; i < bitsCount; i++) {
            if (T.compareTo(pValue.subtract(BigInteger.ONE).divide(BigInteger.ONE.add(BigInteger.ONE))) == -1)
                wr.write("1");
            else
                wr.write("0");

            T = aValue.modPow(T, pValue);
        }
    wr.close();
    }

    static void byteVersion() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/blummicali_byte.txt");
        System.out.println("\nBlumMicali_gen");
        BigInteger pValue = new BigInteger(pValueString, 16);
        BigInteger aValue = new BigInteger(aValueString, 16);
        BigInteger kValue = BigInteger.ZERO;

        long temp;
        temp = random.nextLong();
        if(temp <= 0) {
            temp += 1;
            temp *= -1;
        }

        T = BigInteger.valueOf(temp);
        for(int i = 0; i < bitsCount; i++) {
            T = aValue.modPow(T, pValue);
            for(int j = 1; j <= 256; j++){
                if(kValue.compareTo(byteConst.multiply(T).divide(pValue.subtract(BigInteger.ONE))) == -1 &&
                        byteConst.multiply(T).divide(pValue.subtract(BigInteger.ONE)).compareTo(kValue.add(BigInteger.ONE)) == 0 ||
                                byteConst.multiply(T).divide(pValue.subtract(BigInteger.ONE)).compareTo(kValue.add(BigInteger.ONE)) == -1) {
                    wr.write(j + " ");
                    System.out.print(kValue + " ");
                    kValue = BigInteger.ZERO;
                    break;
                }
                    kValue = kValue.add(BigInteger.ONE);
            }
    wr.close();

        }
    }
}
