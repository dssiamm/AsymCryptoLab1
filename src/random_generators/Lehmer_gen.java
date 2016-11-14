package random_generators;


import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

class Lehmer_gen {
    private static Random random = new Random();
    private static final int bitsCount = 125000;
    private static BigInteger a, c, m ,x;
    private static long xl;

    static void getBit() throws IOException{
        FileWriter wr = new FileWriter("lehmer.txt");
        xl = random.nextLong();
        if(xl <= 0)
            xl = -xl;

        x = BigInteger.valueOf(xl);
        m = BigInteger.valueOf(4294967296l);
        a = BigInteger.valueOf(65537);
        c = BigInteger.valueOf(119);

        System.out.println("Lehmer_gen(high)");
        for(int i = 0; i < bitsCount; i++) {
            if(i % 125 == 0)
                wr.write("\n");
            wr.write(x.toString(2).substring(0, 8));
            x = x.multiply(a);
            x = x.add(c);
            x = x.mod(m);
        }
        wr.close();
        x = BigInteger.valueOf(xl);

        wr = new FileWriter("lehmer_low.txt");
        System.out.println("Lehmer_gen(low)");
        for(int i = 0; i < bitsCount; i++) {
            if(i % 125 == 0)
                wr.write("\n");
            wr.write(x.toString(2).substring(x.bitLength() - 8, x.bitLength()));
            x = x.multiply(a);
            x = x.add(c);
            x = x.mod(m);
        }
        wr.close();
    }
}
