class BigIntTest {
    public static void main(String[] a) {
        int zero = 0;
        // Define base of values that will be represented by the integers (defined in configs.hpp of Zilch source) 
        // For 64-bit signed integers: (2^63)-1. Range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (9223372036854775807) (3037000499 squared)

        // Use bit shift operator on expxnt minus x as it works for powers of 2
        // I.e. (2<<14)-1 for 16-bit, (2<<30)-1 for 32-bit, (2<<62)-1 for 64-bit
        // int base = (2 << 62) - 1;

        
        // The numbers are stored in an array, where each index represents a single digit 
        // Both numbers a and b are read from x single file. The two first number represent
        //  the amount of digits thr numbers contain. 
        int[] x;
        int[] y;
        int[] result;

        int carry = zero;
        int x_digit_value = zero;
        int y_digit_value = zero;
        int tmp_val = zero;
        int rem_val = zero;
 
        
       
        int x_digit_i = zero;
        int y_digit_i = zero;
        int x_digit_i_r = zero;
        int y_digit_i_r = zero;

        // LOL SETTING THIS SHIT TO "ZERO" WORKED
        int x_number_of_digits = zero;
        int y_number_of_digits = zero;
        int result_number_of_digits = zero;

        // Index of a digit in a number    
        
       
        int result_digit_i = zero;

        int finished = zero;

        // int addition = 1;
        // int multiplication = 0;

        x_number_of_digits = PublicTape.read();

        
        x = new int[x_number_of_digits];
        while (x_digit_i < x_number_of_digits) {
            x[x_digit_i] = PublicTape.read();
            x_digit_i++;
        }

        y_number_of_digits = PublicTape.read();

        
        result_number_of_digits = (x_number_of_digits > y_number_of_digits) ? x_number_of_digits + 1 : y_number_of_digits + 1;

        y = new int[y_number_of_digits];
        result = new int[result_number_of_digits];
        while (y_digit_i < y_number_of_digits) {
            y[y_digit_i] = PublicTape.read();
            y_digit_i++;
        }
        

        //Setting this to "zero" bricks it
        x_digit_i = 0;
        y_digit_i = zero;
        result_digit_i = zero;
        

        while (result_digit_i < result_number_of_digits) {
            x_digit_i_r = result_number_of_digits - x_digit_i;
            x_digit_value = x[x_digit_i_r];
            if (x_digit_i < x_number_of_digits)
                x_digit_i++;
            y_digit_i_r = result_number_of_digits - y_digit_i;
            y_digit_value = y[y_digit_i_r];
            y_digit_i++;

            tmp_val = (y_digit_value + y_digit_value) + carry;
            
            if (tmp_val > 9) { 
                result[result_digit_i] = tmp_val - 10;
                carry = 1; 
            } else {
                result[result_digit_i] = tmp_val;
                carry = 0;
            }
            result_digit_i++;
        }

        
        // result[result_number_of_digits] = carry;
        
        if (carry > 0){
            result[result_number_of_digits] = carry;
            result_number_of_digits++;
        }
            
            
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

        Prover.answer(result[result_number_of_digits]);
    }
    
}

// cd ZeroJava-compiler/; java -jar target/zerojava-compiler-1.0.jar src/test/resources/biginteger-multiplication/BigInteger.java; cd ..; ./zilch --asm ZeroJava-compiler/src/test/resources/biginteger-multiplication/BigInteger.zmips
