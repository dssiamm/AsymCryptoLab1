package random_generators;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class L89_gen {
    private static int length = 89;
    private static boolean[] startValue = new boolean[length];
    private static boolean temp;
    private static final int bitsCount = 1000000;
    private static Random random = new Random();

    static void getBits() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/l89.txt");
        for(int i = 0; i < length; i++)
            startValue[i] = random.nextBoolean();

        System.out.println("L89_gen");
        for(int i = 0; i < bitsCount; i ++) {
            if(i % 1000 == 0)
                wr.write("\n");
            temp = startValue[length - 1] ^ startValue[length - 52];
            if(temp)
                wr.write("1");
            else
                wr.write("0");
            startValue = rightShift(startValue, temp);
        }

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
