package random_generators;

import tests.IndepTest;
import tests.QuabilityTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException{
        FileWriter wr = new FileWriter("geffe.txt");
        Random random = new Random();

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
        QuabilityTest.testQuability("geffe.txt");
        IndepTest.testQuability("geffe.txt");

        try {
            Built_in_gen.getBit();
            QuabilityTest.testQuability("built_in_gen.txt");
            IndepTest.testQuability("built_in_gen.txt");

            BlumBlumShub_gen.bitVersion();
            QuabilityTest.testQuability("blumblum_bit.txt");
            IndepTest.testQuability("blumblum_bit.txt");

            BlumBlumShub_gen.byteVersion();
            QuabilityTest.testQuabilityByte("blumblum_byte.txt");
            //IndepTest.testQuabilityByte("blumblum_byte.txt");

            Wolfram_gen.getBit();
            QuabilityTest.testQuability("wolf.txt");
            IndepTest.testQuability("wolf.txt");

            Library_gen.getBits();
            QuabilityTest.testQuabilityByte("library.txt");
            //IndepTest.testQuabilityByte("library.txt");

            L20_gen.getBits();
            QuabilityTest.testQuability("l20.txt");
            IndepTest.testQuability("l20.txt");

            L89_gen.getBits();
            QuabilityTest.testQuability("l89.txt");
            IndepTest.testQuability("l89.txt");

            BlumMicali_gen.bitVersion();
            QuabilityTest.testQuability("blummicali_bit.txt");
            IndepTest.testQuability("blummicali_bit.txt");

            BlumMicali_gen.byteVersion();
            QuabilityTest.testQuabilityByte("blummicali_byte.txt");
            //IndepTest.testQuabilityByte("blummicali_byte.txt");

            Lehmer_gen.getBit();
            QuabilityTest.testQuability("lehmer.txt");
            IndepTest.testQuability("lehmer.txt");
            QuabilityTest.testQuability("lehmer_low.txt");
            IndepTest.testQuability("lehmer_low.txt");
        }   catch (IOException e) {
            e.printStackTrace();
        }

    }
}
