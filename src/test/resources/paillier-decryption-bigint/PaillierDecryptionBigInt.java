class PaillierDecryptionBigInt {
    public static void main(String[] args) {
        // Define base of values that will be represented by the integers (defined in configs.hpp of Zilch source)
        // For 64-bit signed integers: (2^63)-1. Range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // For 32-bit signed integers: (2^31)-1. Range of -2,147,483,648 to 2,147,483,647
        // For 16-bit signed integers: (2^15)-1. Range of -32,768 to 32,767
        // Use bit shift operator on exponent minus one as it works for powers of 2
        // I.e. (2<<14)-1 for 16-bit, (2<<30)-1 for 32-bit, (2<<62)-1 for 64-bit
        int base = (2 << 62) - 1;

        // Digits of input numbers to the program
        int[] encResDigits;
        int[] decResDigits;
        int[] publicNDigits;
        int[] privateLambdaDigits;
        int[] privateMuDigits;
 
        // Temporary variables
        int size;
        int i = 0;

        // Read encrypted result
        size = PublicTape.read();
        encResDigits = new int[size];
        while (i < size) {
            encResDigits[i] = PublicTape.read();
            i++;
        }

        // Read decrypted result
        i = 0;
        size = PublicTape.read();
        decResDigits = new int[size];
        while (i < size) {
            decResDigits[i] = PublicTape.read();
            i++;
        }

        // Read N of the public key
        i = 0;
        size = PublicTape.read();
        publicNDigits = new int[size];
        while (i < size) {
            publicNDigits[i] = PublicTape.read();
            i++;
        }

        // Read Lambda of the private key
        i = 0;
        size = PublicTape.read();
        privateLambdaDigits = new int[size];
        while (i < size) {
            privateLambdaDigits[i] = PublicTape.read();
            i++;
        }

        // Read Mu of the private key
        i = 0;
        size = PublicTape.read();
        privateMuDigits = new int[size];
        while (i < size) {
            privateMuDigits[i] = PublicTape.read();
            i++;
        }

        Prover.answer(base);
    }
}