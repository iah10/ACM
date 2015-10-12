package gametheory;

import java.util.Scanner;


public class MMM 
{
	private static Scanner scan;

	public static void main(String[] args) 
	{
		scan = new Scanner(System.in);
		int t =scan.nextInt();
		for (int qq = 0; qq < t; qq++) {
			System.out.println(solve() ? "John" : "Brother");
		}
		scan.close();
	}

	private static boolean solve() {
		int n = scan.nextInt();
		boolean allOnes = true;
		int nimSum = 0;
		for (int i = 0; i < n; i++) 
		{
			int ai = scan.nextInt();
			if (ai != 1) {
				allOnes=false;
			}
			nimSum ^=ai;
		}
		if (allOnes) {
			return n%2==0;
		} else {
			return nimSum!=0;
		}
	}
}