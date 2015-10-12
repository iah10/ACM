package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/filling-jars">Problem</a>
 */
public class FillingJars 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		long candy = 0;
		for (int i = 0; i < m; i++) 
		{
			long a = scan.nextInt();
			long b = scan.nextInt();
			long k = scan.nextInt();
			
			candy += (b-a+1)*k;
		}
		System.out.println(candy/n);
		scan.close();
	}
}
