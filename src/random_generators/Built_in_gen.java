package random_generators;


import java.util.Random;

class Built_in_gen {
    private static final int bitsCount = 200;
    private static Random random = new Random();

    static void getBit() {
        System.out.println("Built_in_gen");
        for(int i = 0; i < bitsCount; i++) {
            if (random.nextBoolean()) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }

}
