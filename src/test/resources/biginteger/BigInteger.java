class BigIntTest {
    public static void main(String[] args) {
        BigInteger a;
        BigInteger b;

        // Useless variables that are only needed because methods have to return something
        boolean aux01;
        boolean aux02;
        boolean aux03;

        int c;
        int c2;

        // Define base of values that will be represented by the integers (defined in configs.hpp of Zilch source)
        // For 64-bit signed integers: (2^63)-1. Range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // For 32-bit signed integers: (2^31)-1. Range of -2,147,483,648 to 2,147,483,647
        // For 16-bit signed integers: (2^15)-1. Range of -32,768 to 32,767
        // Use bit shift operator on exponent minus one as it works for powers of 2
        // I.e. (2<<14)-1 for 16-bit, (2<<30)-1 for 32-bit, (2<<62)-1 for 64-bit
        int base = (2 << 62) - 1;

        a = new BigInteger();
        aux01 = a.Init();

        b = new BigInteger();
        aux02 = b.Init();

        Prover.answer(base);
    }
}

class BigInteger {
    int size;
    int[] digits;
    boolean is_negative;
    
    // Read the number of digits and whether it is negative from the file
    // Digits need to be entered in Big-Endian order
    public boolean Init() {
        int digit;
        int i = 0;
        size = PublicTape.read();
        is_negative = (PublicTape.read()) == 1;
        digits = new int[size];
        while (i < size) {
            digit = PublicTape.read();
            if (is_negative) {
                digit = digit * -1;
            }
            digits[i] = digit;
            i++;
        }
        return true;
    }

    public int GetLength() {
        return digits.length;
    }

    public boolean Add(BigInteger other) {
        return true;
    }

    public boolean Subtract(BigInteger other) {
        return true;
    }

    public boolean Multiply(BigInteger other) {
        return true;
    }

    public boolean Divide(BigInteger other) {
        return true;
    }

    // Apparently max. 6 functions in a class?????????
    /*public boolean Modulo(BigInteger other) {
        return true;
    }*/
}