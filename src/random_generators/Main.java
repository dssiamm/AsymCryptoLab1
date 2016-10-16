package random_generators;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Built_in_gen.getBit();
        Lehmer_gen.getBit();
        L20_gen.getBits();
        System.out.println();
        L89_gen.getBits();

        System.out.println();
        System.out.println("Geffe_gen");
        Geffe_gen l9 = new Geffe_gen(27, 9);
        Geffe_gen l10 = new Geffe_gen(9, 10);
        Geffe_gen l11 = new Geffe_gen(5, 11);

        l9.setRegisterValues(random.nextInt(500));
        l10.setRegisterValues(random.nextInt(1020));
        l11.setRegisterValues(random.nextInt(2040));

        for(int i = 0; i < 200; i++) {
            if(Geffe_gen.jiffyCoef(l9.registerStep(), l10.registerStep(), l11.registerStep())) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }

        Wolfram_gen.getBit();
        Library_gen.getBits();
        BlumMicali_gen.bitVersion();
        BlumMicali_gen.byteVersion();
        BlumBlumShub_gen.bitVersion();
        BlumBlumShub_gen.byteVersion();


    }
}
