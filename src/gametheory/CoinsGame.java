package gametheory;

import java.util.Scanner;

//http://www.spoj.com/problems/MCOINS/
public class CoinsGame 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int l = scan.nextInt();
		int n = scan.nextInt();
		int[] values = new int[n];
		
		int max = -1;
		for (int i = 0; i < n; i++) 
		{
			values[i] = scan.nextInt();
			if (values[i] > max) {
				max = values[i];
			}
		}
		
		int[] memo = new int[max + 1];
		for (int i = 1; i <= max; i++) 
		{
			if (memo[i - 1] == 0 || (i >= k && memo[i - k] == 0) || (i >= l && memo[i - l] == 0)) {
				memo[i] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(memo[values[i]] == 1 ? "A" : "B");
		}
		scan.close();
	}
}
