class BigIntTest {
    public static void main(String[] input_string) {
        // Define base of values that will be represented by the integers (defined in configs.hpp of Zilch source) 
        // For 64-bit signed integers: (2^63)-1. Range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (9223372036854775807) (3037000499 squared)

        // Use bit shift operator on exponent minus one as it works for powers of 2
        // I.e. (2<<14)-1 for 16-bit, (2<<30)-1 for 32-bit, (2<<62)-1 for 64-bit
        // int base = (2 << 62) - 1;

        
        // The numbers are stored in an array, where each index represents a single digit 
        // Both numbers a and b are read from one single file, where the digits of each number..
        // ..are prepend by the amount of digits that number contains 
        int[] a;
        int[] b;
        int[] result;

        int carry = 0;
        int a_digit_value = 0;
        int b_digit_value = 0;
        int tmp_val = 0;
        int rem_val = 0;

        int a_number_of_digits = 0;
        int b_number_of_digits = 0;
        int result_number_of_digits = 0;

        // Index of a digit in a number    
        int a_digit_i;
        int b_digit_i;
        int result_digit_i;

        // int addition = 1;
        // int multiplication = 0;

        a_digit_i = 0;
        a_number_of_digits = PublicTape.read();
        a = new int[a_number_of_digits];
        while (a_digit_i < a_number_of_digits) {
            a[a_digit_i] = PublicTape.read();
            a_digit_i++;
        }
        a_digit_i = 0;

        b_digit_i = 0;
        b_number_of_digits = PublicTape.read();
        b = new int[b_number_of_digits];
        while (b_digit_i < b_number_of_digits) {
            b[b_digit_i] = PublicTape.read();
            b_digit_i++;
        }
        b_digit_i = 0;

        result_number_of_digits = ((a_number_of_digits) >= (b_number_of_digits)) ? a_number_of_digits + 1 : b_number_of_digits + 1;

        result = new int[result_number_of_digits];
 
        while (result_digit_i < result_number_of_digits) {
            a_digit_value = a[a_digit_i];
            a_digit_i++;
            b_digit_value = b[b_digit_i];
            b_digit_i++;

            tmp_val = (a_digit_value + b_digit_value) + carry;
            
            if (tmp_val > 9) { 
                result[result_digit_i] = tmp_val - 10;
                carry = 1; 
            } else {
                result[result_digit_i] = tmp_val;
                carry = 0;
            }
            result_digit_i++;
        }


        if (carry > 0)
            result[result_number_of_digits] = carry;
        else
            // Accessing this index will otherwise throw a runtime exception (uninitialized)
            result[result_number_of_digits] = 0;
    

        // Print out resulting digits in base 10
        System.out.println(result_number_of_digits);
        result_digit_i = 0;
        while (result_digit_i < result_number_of_digits) {
           
            System.out.println(result[result_digit_i]);
            result_digit_i++;
        }

        Prover.answer(result[0]);
    }
    
}

// cd ZeroJava-compiler/; java -jar target/zerojava-compiler-1.0.jar src/test/resources/biginteger-multiplication/BigInteger.java; cd ..; ./zilch --asm ZeroJava-compiler/src/test/resources/biginteger-multiplication/BigInteger.zmips
