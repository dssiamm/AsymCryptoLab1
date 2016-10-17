package random_generators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class L20_gen {
    private static int length = 20;
    private static boolean[] startValue = new boolean[length];
    private static boolean temp;
    private static final int bitsCount = 1000000;
    private static Random random = new Random();

    static void getBits() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/l20.txt");
        for(int i = 0; i < length; i++)
            startValue[i] = random.nextBoolean();

        System.out.println("L20_gen");
        for(int i = 0; i < bitsCount; i ++) {
            if(i % 1000 == 0)
                wr.write("\n");
            temp = startValue[length - 1] ^ startValue[length - 12] ^ startValue[length - 16] ^ startValue[length - 18];
            if(temp)
                wr.write("1");
            else
                wr.write("0");
            startValue = rightShift(startValue, temp);
        }
    wr.close();


    }

    static boolean[] rightShift(boolean[] mass, boolean res) {
        for(int i = length - 1; i > 0; i--)
            mass[i] = mass[i-1];
        if(res)
            mass[0] = true;
        else
            mass[0] = false;
        return mass;
    }

}
