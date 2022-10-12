class PaillierDecryption {
    public static void main(String[] args) {
        // Result components
        int decryptedResult;
        int encryptedResult;

        // Key components
        int publicN;
        int privateLambda;
        int privateMu;

        // Intermediate variables
        Helpers helper;
        int encPowLambda;
        int nSquared;
        int modNSquared;
        int boundToL;
        int multByMu;

        // Result
        int result;

        // Read data from tapes
        publicN = PublicTape.read();
        decryptedResult = PublicTape.read();
        encryptedResult = PublicTape.read();
        privateLambda = PrivateTape.read();
        privateMu = PrivateTape.read();

        // Initialize helper
        helper = new Helpers();

        // Calculate decryption
        encPowLambda = helper.exponentiateBitwise(encryptedResult, privateLambda); // Will overflow quickly
        nSquared = publicN * publicN; // Will overflow for large N's
        modNSquared = encPowLambda % nSquared;
        boundToL = helper.L(modNSquared, publicN);
        multByMu = boundToL * privateMu;
        result = multByMu % publicN;

        System.out.println(result);

        Prover.answer(result == decryptedResult);
    }
}

class Helpers {
    // Exponentiate a base and an exponent
    // Overflows very fast, even if result should be in integer range (use bitwise method below)
    public int exponentiate(int base, int exponent) {
        int i = 0;
        int result = base;
        while (i < (exponent - 1)) {
            result *= base;
            i++;
        }
        return result;
    }

    // Fast exponentation using bit manipulation. O(log n) complexity
    // Source: https://www.geeksforgeeks.org/fast-exponention-using-bit-manipulation/
    public int exponentiateBitwise(int base, int exponent) {
        int last_bit;
        int result = 1;
        while (exponent > 0) {
            last_bit = (exponent & 1);
            if (last_bit > 0) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

    public int L(int x, int n) {
        return (x - 1) / n;
    }
}
