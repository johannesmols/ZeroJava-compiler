// Compile to zMIPS: java -jar target/zerojava-compiler-1.0.jar src/test/resources/mpn-addition/MpnAddition.java --opts
// Run with Zilch: ./zilch --asm ZeroJava-compiler/src/test/resources/mpn-addition/MpnAddition.zmips

class MpnAddition {
    public static void main(String[] a) {
        int base = (2 << 30) - 1; // Equivalent to (2^31)-1 (max value of signed 32-bit integer)

        // Store actual values
        int[] digits_a;
        int[] digits_b;
        int[] digits_res;

        // Temporary variables for addition
        int carry;
        int largest_size;
        int a_val;
        int b_val;

        // Temporary values for looping, reading in values, etc.
        int size;
        int i = 0;
        boolean equal = false;

        // Read the number of digits and whether it is negative from the file
        // Digits need to be entered in Little-Endian order
        size = PublicTape.read();
        digits_a = new int[size];
        while (i < size) {
            digits_a[i] = PublicTape.read();
            i++;
        }

        i = 0;
        size = PrivateTape.read();
        digits_b = new int[size];
        while (i < size) {
            digits_b[i] = PrivateTape.read();
            i++;
        }

        // Addition of A and B
        carry = 0;
        i = 0;
        largest_size = ((digits_a.length) >= (digits_b.length)) ? digits_a.length : digits_b.length;
        // If there is no carry at the end, the array unfortunately still gets an additional element
        // Can't resize arrays, so we would have to check at the end and copy the values to a new array
        digits_res = new int[largest_size + 1];
        while (i < largest_size) {
            // Check if A has more digits
            if (i < (digits_a.length)) {
                a_val = digits_a[i];
            } else {
                a_val = 0;
            }

            // Check if B has more digits
            if (i < (digits_b.length)) {
                b_val = digits_b[i];
            } else {
                b_val = 0;
            }

            // Actual addition
            carry += a_val + b_val;
            digits_res[i] = carry % base;
            carry = carry / base;

            i++;
        }

        digits_res[largest_size] = carry;
        Prover.answer(true);
    }
}