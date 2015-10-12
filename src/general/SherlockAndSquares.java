package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/sherlock-and-squares"> Problem</a>
 */
public class SherlockAndSquares 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++)
		{
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			//SOLVE
            int c = (int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
			System.out.println(c);
		}
		scan.close();
	}
}
