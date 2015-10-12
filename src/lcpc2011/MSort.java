package lcpc2011;

import java.util.Scanner;

public class MSort 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int qq = 1; qq <=t; qq++) 
		{
			int n = scan.nextInt();
			int[] S = new int[n];
			for (int i = 0; i < n; i++) {
				S[i] = scan.nextInt();
			}
			System.out.println("Case #" + qq + ": " + solve(n,S));
		}
		scan.close();
	}

	public static int solve(int n, int[] s) 
	{
		int cost = 0;
		//for (int i = 0; i < s.length; i++) 
		int start = 0;
		int end = n-1;
		while(!isSorted(s))
		{
			int getMinIndex = getMinIndex(s, start, end);
			int getMaxIndex = getMaxIndex(s, start, end);
			cost += Math.abs(getMinIndex - getMaxIndex);
			
			//swap
			int temp = s[getMaxIndex];
			s[getMaxIndex]  = s[getMinIndex];
			s[getMinIndex] = temp;
			
			start++;
			end--;
		}
		return cost;
	}

	private static int getMinIndex(int[] s, int start, int end) 
	{
		int min = start;
		for (int i = start; i <=end; i++) 
		{
			min = s[min] < s[i] ? min : i;
		}
		return min;
	}

	public static int getMaxIndex(int[] s, int start, int end) 
	{
		int max = start;
		for (int i = start; i <= end; i++) 
		{
			max = s[max] > s[i] ? max : i;
		}
		return max;
	}

	public static boolean isSorted(int[] s) 
	{
		for (int i = 0; i < s.length-1; i++) {
			if (!(s[i+1] >=s[i])) {
				return false;
			}
		}
		return true;
	}
}
