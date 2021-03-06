package random_generators;


class Geffe_gen {
    private int value, registercoeficientt, length;

    Geffe_gen(int registercoeficientt, int length) {
        this.length = length;
        this.registercoeficientt = registercoeficientt;
    }

    boolean registerStep(){
        boolean res;
        if( (this.value & 1) == 0)
            res = false;
        else
            res = true;
        int temp = this.value & this.registercoeficientt;
        this.value = this.value >>> 1;
        if(Integer.bitCount(temp) % 2 == 1)
            this.value = this.value + pow(2, this.length - 2);
        return res;
    }

    int pow(int x, int y){
        int res = x;
        for(int i = 0; i < y; i++)
            res *= x;
        return res;
    }

    void setRegisterValues(int values){
        this.value = values;
    }

    static boolean jiffyCoef(boolean x, boolean y, boolean s){
        boolean res;
        return res = s & x ^ !s & y;
    }
}
