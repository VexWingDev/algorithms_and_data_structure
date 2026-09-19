import java.math.BigDecimal;

/*
4. A) Write a program that calculates the sum of 0.1 and 0.2 and stores the result in a double type of variable. 
Print the variable value. What do you notice?

B) Write a program that compares if the sum of 0.1 and 0.2 equals 0.3 (using the equality operator).
 What do you notice? How to fix the program?

*/
public class FloatingPointTest 
{
    public static void main(String[] args)
    {
        // This is where A starts working
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;

        System.out.println("--- Part A ---");
        System.out.println("0.1 + 0.2 = " + sum);
        System.out.println("Notice: the result is not exactly 0.3, it's " + sum
                + " because 0.1 and 0.2 cannot be represented exactly in binary.");

        // And this is where B starts working
        double c = 0.3;
        boolean isEqual = (sum == c);

        System.out.println("\n--- Part B ---");
        System.out.println("(0.1 + 0.2 == 0.3) is: " + isEqual);
        System.out.println("Notice: this prints false, even though it is true mathematically.");
        System.out.println("This is because of floating point rounding error, not a bug in the logic.");

        // First fix; Comparing with a small tolerance (epsilon) instead of ==
        // This is generally well enough for most purpose numeric comparisons.
        double epsilon = 1e-9;
        boolean isCloseEnough = Math.abs(sum - c) < epsilon;
        System.out.println("\nFix 1 - epsilon comparison: Math.abs(sum - 0.3) < 1e-9 -> " + isCloseEnough);

        // Second fix; Use of BigDecimal, consutructed from Strings, for exact decimal arithmetic. 
        // Consturing from a String, not a double, avoids copying the already imprecise binary floating point value. This is the approach to use for money/financial math.
        BigDecimal bdA = new BigDecimal("0.1");
        BigDecimal bdB = new BigDecimal("0.2");
        BigDecimal bdSum = bdA.add(bdB);
        BigDecimal bdC = new BigDecimal("0.3");

        System.out.println("\nFix 2 - BigDecimal: 0.1 + 0.2 = " + bdSum);
        System.out.println("BigDecimal sum equals 0.3? " + bdSum.equals(bdC));
    }
}