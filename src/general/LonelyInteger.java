package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/lonely-integer">Problem</a>
 */
public class LonelyInteger 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i]= scan.nextInt(); 
		}
		System.out.println(lonelyinteger(nums));
		scan.close();
	}

	public static int lonelyinteger(int[] a) 
	{
		int lonely = a[0];
		for (int i = 1; i < a.length; i++) 
		{
			lonely ^=a[i];
		}
		return lonely;
	}
}
