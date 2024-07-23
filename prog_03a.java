3a.  Write a Java program to read two integers a and b. Compute a/b and print, when b is not zero. Raise an exception when b is equal to zero.

package divideexception1;
import java.util.Scanner;

class DivideByZeroException extends ArithmeticException {
    String message;

    public DivideByZeroException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}

public class DivideException1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b, result;
        
        try {
            System.out.println("Input the numerator");
            a = s.nextInt();
            System.out.println("Input the denominator");
            b = s.nextInt();
            if (b == 0) throw new DivideByZeroException("You cannot divide by zero");
            result = a / b;
            System.out.println("The result is " + result);
        } catch (DivideByZeroException dbze) {
            System.out.println(dbze.toString());
        }
    }
}
