class BigIntTest {
    public static void main(String[] a) {
        // Define base for each digit that fits into bit-size (for signed 32-bit ints, this is (2^30)-1)
        int base = (2 << 30) - 1; // equal to ((2^30)*2)-1

        int size;
        int[] digits;
        int i = 0;

        size = PublicTape.read();
        digits = new int[size];
        while (i < size) {
            digits[i] = PublicTape.read();
            i++;
        }

        System.out.println(base);

        Prover.answer(0);
    }
}