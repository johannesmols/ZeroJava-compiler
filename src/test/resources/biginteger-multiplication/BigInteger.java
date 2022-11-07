class BigIntTest {
    public static void main(String[] a) {
        // Define base of values that will be represented by the integers (defined in configs.hpp of Zilch source)
        // For 64-bit signed integers: (2^63)-1. Range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (9223372036854775807) (3037000499 squared)
        // For 32-bit signed integers: (2^31)-1. Range of -2,147,483,648 to 2,147,483,647
        // For 16-bit signed integers: (2^15)-1. Range of -32,768 to 32,767
        // Use bit shift operator on exponent minus one as it works for powers of 2
        // I.e. (2<<14)-1 for 16-bit, (2<<30)-1 for 32-bit, (2<<62)-1 for 64-bit
        // int base = (2 << 62) - 1;

        // Store actual values
        int[] a_num;
        int[] b_num;
        int[] res_num;

        int carry = 0;
        int a_val = 0;
        int b_val = 0;
        int tmp_val = 0;


        // Temporary values for looping, reading in values, etc.
        int a_digits = 0;
        int b_digits = 0;
        int res_digits = 0;

        // Index of a digit in a number    
        int a_i;
        int b_i;
        int res_i;

        // int addition = 1;
        // int multiplication = 0;

        // Read the number of digits and whether it is negative from the file
        // Digits need to be entered in Little-Endian order
        a_digits = PublicTape.read();
        a_num = new int[a_digits];
        while (a_i < a_digits) {
            digits_a[a_i] = PublicTape.read();
            a_i++;
        }
        a_i = 0;

        b_digits = PublicTape.read();
        b_num = new int[b_digits];
        while (b_i < b_digits) {
            digits_b[b_i] = PublicTape.read();
            b_i++;
        }
        b_i = 0;

       
   
        if ((a_digits) > (b_digits))
            res_digits = a_digits;
        else
            res_digits = b_digits + 1;

        res_num = new int[res_digits];



        // Addition of A and B
        
        while (res_i < res_digits) {
            a_val = a_num[a_i];
            a_i++;
            b_val = b_num[b_i];
            b_i++;

            tmp_val = (a_val + b_val) + carry;
            if (tmp_val > 9) { 
                // Overflow occured
                res_num[res_i] = tmp_val - 10;
                carry = 1; // Set carry to 1
            } else {
                res_num[res_i] = tmp_val;
                carry = 0;
            }
            res_i++;
        }
        if (carry > 0)
            res_num[res_digits] = carry;
        else
            // Accessing this index will otherwise throw a runtime exception (uninitialized)
            res_num[res_digits] = 0;
    

        // Print out resulting digits in base 10
        System.out.println(res_digits);
        res_i = 0;
        while (res_i < res_digits) {
           
            System.out.println(res_num[res_i]);
            res_i++;
        }

        Prover.answer(res_num[0]);
    }
    
}