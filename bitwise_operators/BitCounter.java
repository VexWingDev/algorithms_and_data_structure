import java.util.Scanner;

public class BitCounter 
{
    public static int countSetBits(int num)
    {
    	int bit, counter = 0;
    	
    	for (bit = 1<<30; bit > 0; bit = bit >> 1)
    	{
    		if ( (num & bit ) !=0 )
    		   counter++;
    	}
    	return counter;
    }
    
    public static int countSetBitsV2(int num)
    {
        int counter = 0;
        
        while (num != 0) {
            
            // Check the last bit
            counter += num & 1; 

            // Move the number by 1
            num >>= 1;        
        }
        return counter;
    }
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int hexNum = 0x7ABC;
		System.out.println("The number is binary:" + Integer.toBinaryString(hexNum));
		System.out.println("The number has "+BitCounter.countSetBitsV2(hexNum)+" bits set.");
		
		System.out.print("Enter an integer value:");
		int number = s.nextInt(16);
		
		System.out.println("The number is binary:" + Integer.toBinaryString(number));
		
		System.out.println("The number has "+BitCounter.countSetBitsV2(number)+" bits set.");
	}

}
