package gametheory;

import java.util.Scanner;


public class TheGame 
{
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int t =scan.nextInt();
		for (int qq = 0; qq < t; qq++) {
			System.out.println(solve() != 0 ? "Tom Wins" : "Hanks Wins");
		}
		scan.close();
	}

	private static int solve() 
	{
		int n = scan.nextInt();
		int nimSum = 0;
		for (int i = 1; i <=n; i++) {
			int num = scan.nextInt();
			if (num%2==0) continue;
			else
				nimSum ^= i;
		}
		return nimSum;
	}
}
