package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/taum-and-bday">Problem</a>
 */
public class TaumAndBday
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) 
		{
			long b = scan.nextInt(); //black
			long w = scan.nextInt(); //white
			
			long x = scan.nextInt(); //black price
			long y = scan.nextInt(); //white price
			long z = scan.nextInt(); //pen
			
			long bPrice = Math.min(x, y+z);
			long wPrice = Math.min(y, x+z);
			
			System.out.println(b*bPrice + w*wPrice);
		}
		scan.close();
	}
}
