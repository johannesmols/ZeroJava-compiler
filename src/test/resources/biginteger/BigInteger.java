class BigIntTest {
    public static void main(String[] a) {
        // Define base of values that will be represented by the integers (defined in configs.hpp of Zilch source)
        // For 64-bit signed integers: (2^63)-1. Range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // For 32-bit signed integers: (2^31)-1. Range of -2,147,483,648 to 2,147,483,647
        // For 16-bit signed integers: (2^15)-1. Range of -32,768 to 32,767
        // Use bit shift operator on exponent minus one as it works for powers of 2
        // I.e. (2<<14)-1 for 16-bit, (2<<30)-1 for 32-bit, (2<<62)-1 for 64-bit
        int base = (2 << 62) - 1;

        // Store actual values
        int[] digits_a;
        int[] digits_b;
        int[] digits_res;

        // Temporary variables for addition
        int carry;
        int largest_size;
        int a_val;
        int b_val;
        int tmp_res;

        // Temporary values for looping, reading in values, etc.
        int size;
        int digit;
        int i = 0;

        // Read the number of digits and whether it is negative from the file
        // Digits need to be entered in Little-Endian order
        size = PublicTape.read();
        digits_a = new int[size];
        while (i < size) {
            digits_a[i] = PublicTape.read();
            i++;
        }

        i = 0;
        size = PublicTape.read();
        digits_b = new int[size];
        while (i < size) {
            digits_b[i] = PublicTape.read();
            i++;
        }

        // Does not print out negative numbers correctly (treats them not as 2-complements, but regular binary)
        //System.out.println(digits_a[0]);
        //System.out.println(digits_b[0]);

        // Addition of A and B
        carry = 0;
        i = 0;
        largest_size = ((digits_a.length) >= (digits_b.length)) ? digits_a.length : digits_b.length;
        // If there is no carry at the end, the array unfortunately still gets an additional element
        // Can't resize arrays, so we would have to check at the end and copy the values to a new array
        digits_res = new int[largest_size];
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

            tmp_res = (a_val + b_val) + carry;
            if ((tmp_res >= (base + 1)) && (tmp_res < 0)) { // base + 1 gets the minimum possible value (in negative space)
                // Overflow occured
                digits_res[i] = (tmp_res + base) + 2; // Overflow goes in negative numbers, so put it back into positive space
                carry = base; // Set carry to max value
            } else {
                digits_res[i] = tmp_res;
            }
            i++;
        }

        // Print out resulting digits in base 10
        i = 0;
        System.out.println(largest_size);
        while (i < largest_size) {
            System.out.println(digits_res[i]);
            i++;
        }

        Prover.answer(digits_res[1]);
    }
}