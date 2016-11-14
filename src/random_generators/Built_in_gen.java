package random_generators;


import java.io.*;
import java.util.Random;

class Built_in_gen {
    private static final int bitsCount = 1000000;
    private static Random random = new Random();

    static void getBit() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/built_in_gen.txt");
        System.out.println("Built_in_gen");
        for(int i = 0; i < bitsCount; i++) {
            if(i % 1000 == 0)
                wr.write("\n");
            if (random.nextBoolean()) {
                wr.write("1");
            } else {
                wr.write("0");
            }
        }
        wr.close();
    }

}
