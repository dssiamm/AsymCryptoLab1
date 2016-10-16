package random_generators;


import java.util.Random;

public class L89_gen {
    private static int length = 89;
    private static boolean[] startValue = new boolean[length];
    private static boolean temp;
    private static final int bitsCount = 200;
    private static Random random = new Random();

    static void getBits() {
        for(int i = 0; i < length; i++)
            startValue[i] = random.nextBoolean();

        System.out.println("L89_gen");
        for(int i = 0; i < bitsCount; i ++) {
            temp = startValue[length - 1] ^ startValue[length - 52];
            if(temp)
                System.out.print("1");
            else
                System.out.print("0");
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
