package general;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/angry-children">Problem</a>
 */
public class MaxMin 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		long[] list = new long[n];
		for(int i = 0; i < n; i ++) {
			list[i] = in.nextInt();
		}
		Arrays.sort(list);
		long min = list[k -1] - list[0];
		for(int i = 1; i <=n - k + 1; i++)
		{
			if(min > (list[k + i - 1] - list[i])){
				min = list[k + i - 1] - list[i];
			}
		}
		in.close();
		System.out.println(min);
	}
}