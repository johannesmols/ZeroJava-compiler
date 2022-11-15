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
        int[] digits_s_num;
        int[] digits_l_num;

        // Temporary variables for addition
        int carry;
        int largest_size;
        int smallest_size;
        int a_val;
        int b_val;
        int tmp_res;

        // Temporary values for looping, reading in values, etc.
        int size;
        int digit;
        int i = 0;
        int j = 0;
        int k = 0;

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
        // largest_size = (digits_a.length) + (digits_b.length);

        largest_size = ((digits_a.length) >= (digits_b.length)) ? digits_a.length : digits_b.length;

        smallest_size = ((digits_a.length) < (digits_b.length)) ? digits_a.length : digits_b.length;
   
        
        //um, stupid overhead of copying data, but it makes easier on the algorithm to always know which 
        //of the numbers is larger. This somehow bugs out the calculation even when not used
        // i = 0;
        // while (i < (largest_size)){
        //     digits_l_num[i] = ((digits_a.length) >= (digits_b.length)) ? (digits_a[i]) : (digits_b[i]);
        //     i++;
        // }   
        
        // i = 0;
        // while (i  < (smallest_size)){
        //     digits_s_num[i] = ((digits_a.length) < (digits_b.length)) ? (digits_a[i]) : (digits_b[i]);
        //     i++;
        // }
        //its ok to give the result array more than needed space
        digits_res = new int[((largest_size + smallest_size) + 1)];
        i = 0;
        j = 0;
        //Iterate over the digits in the biggest number
        while (i < largest_size) {
            // j = 0;
            carry = 0;

            //Assign value of the digit to a temp variable. If iterator 
            //i is greater than the lenght of the number, then simply assign 0
            if (i < (largest_size)) {
                a_val = digits_a[i];
            } else {
                a_val = 0;
            }

            //for each digit og the larger number, compute long multiplication
            //by iterating over the digits in the smaller number

            //note that currently a is assumed to be the larger number

            while (j < smallest_size){
                k = i + j;

                if (j < (smallest_size)) {
                    b_val = digits_b[j];
                } else {
                    b_val = 0;
                }

                tmp_res = (carry) + (a_val * b_val);

                if ((tmp_res >= (base + 1)) && (tmp_res < 0)) { // base + 1 gets the minimum possible value (in negative space)
                    // Overflow occured
                    digits_res[k] = (tmp_res + base) + 2; // Overflow goes in negative numbers, so put it back into positive space
                    carry = (digits_res[k]) / base;
                    digits_res[k] = (digits_res[k]) % base;
                } else {
                    digits_res[k] = tmp_res;
                    carry = 0;
                }

                // digits_res[k] = tmp_res;
                // carry = (digits_res[k]) / base;
                // digits_res[k] = (digits_res[k]) % base;
                j++; 
            }
            digits_res[largest_size + j] = carry;
            
 
            // tmp_res = (a_val + b_val) + carry;
            // if ((tmp_res >= (base + 1)) && (tmp_res < 0)) { // base + 1 gets the minimum possible value (in negative space)
            //     // Overflow occured
            //     digits_res[i] = (tmp_res + base) + 2; // Overflow goes in negative numbers, so put it back into positive space
            //     carry = 1; // Set carry to 1
            // } else {
            //     digits_res[i] = tmp_res;
            //     carry = 0;
            // }
            i++;
            
            
        }


        if (carry > 0) {
            digits_res[largest_size] = carry;
        } else {
            // Accessing this index will otherwise throw a runtime exception (uninitialized)
            digits_res[largest_size] = 0;
        }

        // Print out resulting digits in base 10
        i = 0;
        // System.out.println(digits_res.length);
        while (i < (largest_size + smallest_size)) {
            System.out.println(digits_res[i]);
            i++;
        }

        // System.out.println(smallest_size);
        Prover.answer(digits_res[0]);
    }
}
// cd ZeroJava-compiler/; java -jar target/zerojava-compiler-1.0.jar src/test/resources/biginteger-multiplication/multiplication.java; cd ..; ./zilch --asm ZeroJava-compiler/src/test/resources/biginteger-multiplication/multiplication.zmips 
