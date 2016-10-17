package random_generators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/geffe.txt");
        Random random = new Random();

        try {
            Built_in_gen.getBit();
            //BlumMicali_gen.bitVersion();
            //BlumMicali_gen.byteVersion();
            BlumBlumShub_gen.bitVersion();
            BlumBlumShub_gen.byteVersion();
            Wolfram_gen.getBit();
            Library_gen.getBits();
            Lehmer_gen.getBit();
            L20_gen.getBits();
            L89_gen.getBits();
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


    }
}
