package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/cut-the-sticks">Problem</a>
 */
public class CutTheSticks 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] sticks = new int[n];
		for (int i = 0; i < n; i++) {
			sticks[i] = scan.nextInt();
		}
		
		int min = getMin(sticks);
		while (min !=0) 
		{
			int cut = 0;
			for (int i = 0; i < n; i++) 
			{
				if (sticks[i] >0) {
					sticks[i]-=min;
					cut++;
				}
			}
			System.out.println(cut);
			min = getMin(sticks);
		}
		scan.close();
	}

	//returns non zero min
	private static int getMin(int[] sticks) 
	{
		int min = 0;
		for (int i = 0; i < sticks.length; i++) 
		{
			if (min==0) {
				min = sticks[i];
				continue;
			}
			if (sticks[i] != 0 && sticks[i] < min) {
				min = sticks[i];
			}
		}
		return min;
	}
}
