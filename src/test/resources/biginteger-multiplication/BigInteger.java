class BigIntTest {
    public static void main(String[] a) {
        int zero = 0;
   
        // Define base of values that will be represented by the integers (defined in configs.hpp of Zilch source) 
        // For 64-bit signed integers: (2^63)-1. Range of -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (9223372036854775807) (3037000499 squared)

        // Use bit shift operator on expxnt minus x as it works for powers of 2
        // I.e. (2<<14)-1 for 16-bit, (2<<30)-1 for 32-bit, (2<<62)-1 for 64-bit
        // int base = (2 << 62) - 1;

        
        int[] x;
        int[] y;
        int[] result;

        int result_r = zero;
        int carry = zero;
        int x_digit_value = zero;
        int y_digit_value = zero;
        int tmp_val = zero;
        int input_val = zero;
 
 
        // int x_digit_i = zero;
        // int y_digit_i = zero;
        int i = zero;

        int x_digit_i_r = zero;
        int y_digit_i_r = zero;

        // LOL SETTING THIS SHIT TO "ZERO" WORKED
        int x_number_of_digits = zero;
        int y_number_of_digits = zero;
        int result_number_of_digits = zero;

  
        int result_digit_i = zero;

        int finished = zero;

        // int addition = 1;
        // int multiplication = 0;

        x_number_of_digits = PublicTape.read();
        x = new int[x_number_of_digits];

        while (i < x_number_of_digits) {
            input_val = PublicTape.read();
            x[i] = input_val;
            i++;
        }

        i = zero;

        y_number_of_digits = PublicTape.read();
        y = new int[y_number_of_digits];
        
        result_number_of_digits = (x_number_of_digits > y_number_of_digits) ? x_number_of_digits + 1 : y_number_of_digits + 1;

        
        result = new int[result_number_of_digits];

        while (i < y_number_of_digits) {
            y[i] = PublicTape.read();
            i++;
        }
        
        i = zero;


        while (i < (result.length)) { 
            x_digit_i_r = (x.length) - i;
            y_digit_i_r = (y.length) - i;

            x_digit_value = (x[i]);
            y_digit_value = y[i];
         

            tmp_val = (y_digit_value + y_digit_value) + carry;
            
            if (tmp_val > 9) { 
                result[i] = tmp_val - 10;
                carry = 1; 
            } else {
                result[i] = tmp_val;
                carry = 0;
            }
            i++;
        }

        //setting this to "zero" bricks it
        i = 0;

        
        if (carry > 0)
            result[result_number_of_digits] = 1;
        else
            // Accessing this index will otherwise throw a runtime exception (uninitialized)
            result[result_number_of_digits] = 0;
    

        // Print out resulting digits in base 10
        // System.out.println(result_number_of_digits);

        //nice this prints out 0. awesome.
        System.out.println(result_number_of_digits);
  
        while (i < result_number_of_digits) {
   
            result_r = result_r + (result[i]);
            // System.out.println(result_r);
            System.out.println(result[i]);
            i++;
        }

        Prover.answer(result[2]);
    }
    
}

// cd ZeroJava-compiler/; java -jar target/zerojava-compiler-1.0.jar src/test/resources/biginteger-multiplication/BigInteger.java; cd ..; ./zilch --asm ZeroJava-compiler/src/test/resources/biginteger-multiplication/BigInteger.zmips
