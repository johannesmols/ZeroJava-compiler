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
        encPowLambda = helper.exponentiate(encryptedResult, privateLambda); // Will overflow
        nSquared = publicN * publicN; // Will overflow for large N's
        modNSquared = encPowLambda % nSquared;
        boundToL = helper.L(modNSquared, publicN);
        multByMu = boundToL * privateMu;
        result = multByMu % publicN;

        Prover.answer(result == decryptedResult);
    }
}

class Helpers {
    // Overflows easily for high exponents
    public int exponentiate(int base, int exponent) {
        int i = 0;
        int result = base;
        while (i < (exponent - 1)) {
            result *= base;
            i++;
        }
        return result;
    }

    public int L(int x, int n) {
        return (x - 1) / n;
    }
}
