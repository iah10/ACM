package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/service-lane">Problem</a>
 */
public class ServiceLane 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		int [] highWay = new int[n];
		//fill the highway
		for (int i = 0; i < n; i++) {
			highWay[i]=scan.nextInt();
		}

		for (int k = 0; k < t; k++) 
		{
			int i = scan.nextInt();
			int j = scan.nextInt();

			int largestVechile = solve(highWay, i,j);
			System.out.println(largestVechile);
		}
		scan.close();
	}

	private static int solve(int[] highWay, int i, int j) 
	{
		int largestVechile=highWay[i];
		for (int k = i+1; k <= j; k++) 
		{
			largestVechile = highWay[k] < largestVechile ? highWay[k] : largestVechile;
			if (largestVechile==1) {
				break;
			}
		}
		return largestVechile;
	}
}
