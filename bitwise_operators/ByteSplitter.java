import java.util.Scanner;

/*
2. Write a program that takes a 32-bit integer and splits it into four pieces each containing a byte / 8-bits. 
Use hexadecimal values to represent each byte (in printf use the %x format specifier to print a hexadecimal).
*/

public class ByteSplitter 
{
    // Masks for each of the four bytes in a 32-bit int
    static final int mask1 = 0xFF000000; // leftmost byte
    static final int mask2 = 0x00FF0000;
    static final int mask3 = 0x0000FF00;
    static final int mask4 = 0x000000FF; // rightmost byte

    public static void splitAndPrint(int num)
    {
        /* As mentioned in the submitted .docx
        & mask turns off every bit except the byte we want. 
        >>> shifts the byte to the rightmost position so it can be printed correctly.
        This means that it will print out a plain 2 digit hex value (0x00-0xFF) instead of a value still sitting in its original bit position.
        We use >>> instead of >> so that the sign bit from mask1 is filled with 0s not 1s during the shift.
        */

        int byte1 = (num & mask1) >>> 24;
        int byte2 = (num & mask2) >>> 16;
        int byte3 = (num & mask3) >>> 8;
        int byte4 = (num & mask4);

        System.out.printf("Number: 0x%08X%n", num);
        System.out.printf("Byte 1 (bits 31-24): 0x%02X%n", byte1);
        System.out.printf("Byte 2 (bits 23-16): 0x%02X%n", byte2);
        System.out.printf("Byte 3 (bits 15-8) : 0x%02X%n", byte3);
        System.out.printf("Byte 4 (bits 7-0)  : 0x%02X%n", byte4);
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int demo = 0x7ABC1234; // Быстрое встроенное демо-значение
        System.out.println("--- Demo value ---");
        splitAndPrint(demo);

        // Позвольте пользователю ввести своё HEX-значение
        System.out.print("\nEnter a hex integer (e.g. 1A2B3C4D): ");
        int number = s.nextInt(16);

        System.out.println("--- Your value ---");
        splitAndPrint(number);

        s.close();
    }
}