package random_generators;


import java.math.BigInteger;
import java.util.Random;

class Lehmer_gen {
    private static Random random = new Random();
    private static final int bitsCount = 25;
    private static BigInteger a, c, m ,x;
    private static long xl;

    static void getBit() {
        xl = random.nextLong();
        if(xl <= 0)
            xl *= -1;

        m = BigInteger.valueOf(4294967296l);
        x = BigInteger.valueOf(xl);
        a = BigInteger.valueOf(65537);
        c = BigInteger.valueOf(119);

        System.out.println("Lehmer_gen(high)");
        for(int i = 0; i < bitsCount; i++) {
            System.out.print(x.toString(2).substring(0, 8));
            x = x.multiply(a);
            x = x.add(c);
            x = x.mod(m);
        }

        x = BigInteger.valueOf(xl);

        System.out.println("\nLehmer_gen(low)");
        for(int i = 0; i < bitsCount; i++) {
            System.out.print(x.toString(2).substring(x.bitLength() - 8, x.bitLength()));
            x = x.multiply(a);
            x = x.add(c);
            x = x.mod(m);
        }
        System.out.println();
    }
}
