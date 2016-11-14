package random_generators;

import tests.QuabilityTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/geffe.txt");
        Random random = new Random();

        try {
            Built_in_gen.getBit();
            QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/built_in_gen.txt");

            BlumBlumShub_gen.bitVersion();
            QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/blumblum_bit.txt");

            BlumBlumShub_gen.byteVersion();
            Wolfram_gen.getBit();
            QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/wolf.txt");

            //Library_gen.getBits();
            //QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/library.txt");

            Lehmer_gen.getBit();
            QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/lehmer.txt");
            QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/lehmer_low.txt");

            L20_gen.getBits();
            QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/l20.txt");

            L89_gen.getBits();
            QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/l89.txt");

            //BlumMicali_gen.bitVersion();
            //BlumMicali_gen.byteVersion();
        }   catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Geffe_gen");
        Geffe_gen l9 = new Geffe_gen(27, 9);
        Geffe_gen l10 = new Geffe_gen(9, 10);
        Geffe_gen l11 = new Geffe_gen(5, 11);

        l9.setRegisterValues(random.nextInt(500));
        l10.setRegisterValues(random.nextInt(1020));
        l11.setRegisterValues(random.nextInt(2040));

        for(int i = 0; i < 1000000; i++) {
            if(i % 1000 == 0)
                wr.write("\n");
            if(Geffe_gen.jiffyCoef(l9.registerStep(), l10.registerStep(), l11.registerStep())) {
                wr.write("1");
            } else {
                wr.write("0");
            }
        }
        wr.close();

        QuabilityTest.testQuability("/home/dssiam/workspace/IntelliJ_IDEA_projects/AsymCryptoLab1/src/source_txt/geffe.txt");

    }
}
