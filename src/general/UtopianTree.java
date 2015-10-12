package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/utopian-tree">Problem</a>
 */
public class UtopianTree 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) 
		{
			int height = 1;
			int cycle = scan.nextInt();
			boolean growByTwo = true;
			while(cycle-- > 0)
			{
				if (growByTwo) {
					height *=2; 
					growByTwo = false;
				} else {
					height +=1;
					growByTwo = true;
				}
			}
			System.out.println(height);
		}
		scan.close();
	}
}
