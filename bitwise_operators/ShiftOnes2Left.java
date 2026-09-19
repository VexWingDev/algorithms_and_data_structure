import java.util.Scanner;

/* 
3. Write a program that will take the bits in a number and shift them to the left end. For example 01010110 would become 11110000. 
Unlike C/C++/C#, Java does not have unsigned integer data types.
 In an integer field leave the leftmost bit unused (zero).
*/
public class ShiftOnes2Left 
{
    public static int shiftOnesLeft(int num)
    {
    	int shiftedNum = 0;
    	int bit;
    	int mask = 1<<30;
    	
    	for (bit = 1<<30; bit > 0; bit = bit >> 1)
    	{
    		// If the bit is set on (1)
    		if ( (num & bit ) !=0 )
    		{
    			// Set the next leftmost bit in
    			shiftedNum = shiftedNum | mask;
    			
    			// Shift the mask one bit position to the right
    			mask = mask >> 1;
    		}
    	}
    	return shiftedNum;
    }
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);

		int demoNum = 0b01010110;
		System.out.println("Demo input : " + Integer.toBinaryString(demoNum));
		System.out.println("Demo result: " + Integer.toBinaryString(shiftOnesLeft(demoNum)));

		System.out.print("\nEnter an integer value: ");
		int number = s.nextInt();

		System.out.println("Input : " + Integer.toBinaryString(number));
		System.out.println("Result: " + Integer.toBinaryString(shiftOnesLeft(number)));

		s.close();
	}

}