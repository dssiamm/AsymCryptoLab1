package random_generators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class Wolfram_gen {

    private static final int bitsCount = 1000000;
    private static Random random = new Random();
    private static long r, rl, rr, temp;


    static void getBit() throws IOException{
        FileWriter wr = new FileWriter("/home/dssiam/IdeaProjects/AsymCryptoLab1/src/source_txt/wolf.txt");
        System.out.println("Wolfram_gen");
        r = random.nextLong() % 4294967296l;
            if (r <= 0) {
                r += 1;
                r *= -1;
            }

        for(int i = 0; i < bitsCount; i++){
            if(i % 1000 == 0)
                wr.write("\n");
            if(r % 2 == 1)
                wr.write("1");
            else
                wr.write("0");

            rr = r;
            rl = r;

            rr = rightCycleShift(rr);
            rl = leftCycleShift(rl);

            temp = Long.parseLong(or(r, rl), 2);
            r = Long.parseLong(xor(temp, rr), 2);
        }
        wr.close();
    }

    static String or(long x, long y) {
        String res = "";
        String xx = "";
        String yy = "";

        for(int i = 0; i < 32 - Long.toBinaryString(x).length(); i++){
            xx += "0";
        }
        xx += Long.toBinaryString(x);

        for(int i = 0; i < 32 - Long.toBinaryString(y).length(); i++){
            yy += "0";
        }
        yy += Long.toBinaryString(y);

        for(int i = 0; i < 32; i++){
            if(xx.charAt(i) == '0' && yy.charAt(i) == '0')
                res += "0";
            if(xx.charAt(i) == '0' && yy.charAt(i) == '1')
                res += "1";
            if(xx.charAt(i) == '1' && yy.charAt(i) == '0')
                res += "1";
            if(xx.charAt(i) == '1' && yy.charAt(i) == '1')
                res += "1";
        }

        return res;
    }

    static String xor(long x, long y) {
        String res = "";
        String xx = "";
        String yy = "";

        for(int i = 0; i < 32 - Long.toBinaryString(x).length(); i++){
            xx += "0";
        }
        xx += Long.toBinaryString(x);

        for(int i = 0; i < 32 - Long.toBinaryString(y).length(); i++){
            yy += "0";
        }
        yy += Long.toBinaryString(y);

        for(int i = 0; i < 32; i++){
            if(xx.charAt(i) == '0' && yy.charAt(i) == '0')
                res += "0";
            if(xx.charAt(i) == '0' && yy.charAt(i) == '1')
                res += "1";
            if(xx.charAt(i) == '1' && yy.charAt(i) == '0')
                res += "1";
            if(xx.charAt(i) == '1' && yy.charAt(i) == '1')
                res += "0";
        }

        return res;
    }

    static long rightCycleShift(long r) {
        if (Long.toBinaryString(r).charAt(Long.toBinaryString(r).length() - 1) == '1') {
            r = r >>> 1;
            r += 2147483648l;
        } else {
            r = r >>> 1;
        }

        return r;
    }

    static long leftCycleShift(long r) {
        if (Long.toBinaryString(r).length() == 32) {
            r -= 2147483648l;
            r = r << 1;
            r += 1;
        } else {
            r = r << 1;
        }

        return r;
    }

}
