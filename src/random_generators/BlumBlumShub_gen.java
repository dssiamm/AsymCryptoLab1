package random_generators;


import java.math.BigInteger;
import java.util.Random;

public class BlumBlumShub_gen {
    private static final int bitsCount = 200;
    private static Random random = new Random();
    private static String mod = "256";
    private static String pValueString = "D5BBB96D30086EC484EBA3D7F9CAEB07";
    private static String qValueString = "425D2B9BFDB25B9CF6C416CC6E37B59C1F";

    static void bitVersion() {
        System.out.println("\nBlumBlumShub_gen");
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
            r = r.modPow(BigInteger.ONE.add(BigInteger.ONE), n);

            if (r.mod(BigInteger.ONE.add(BigInteger.ONE)).equals(BigInteger.ONE))
                System.out.print("1");
            else
                System.out.print("0");
        }

    }

    static void byteVersion() {
        System.out.println("\nBlumBlumShub_gen");
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
            r = r.modPow(BigInteger.ONE.add(BigInteger.ONE), n);
            System.out.print(r.mod(modValue) + " ");
        }

    }
}
