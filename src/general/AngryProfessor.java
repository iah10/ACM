package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/angry-professor">Problem</a>
 */
public class AngryProfessor 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) 
		{
			int n = scan.nextInt();
			int k = scan.nextInt();
			
			for (int j = 0; j < n; j++)
			{
				int student = scan.nextInt();
				if (student <=0) {
					k--;
				}
			}
			
			if (k<=0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		scan.close();
	}
}
