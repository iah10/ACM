package codeforces;

import java.util.Scanner;

public class AsphaltingRoads 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean[] roadsH = new boolean[n+1];
		boolean[] roadsV = new boolean[n+1];
		for (int i = 1; i <= n*n; i++) 
		{
			int hi = scan.nextInt();
			int vi = scan.nextInt();
			
			if (!roadsH[hi] && !roadsV[vi]) {
				System.out.print(i +" ");
				roadsH[hi] = roadsV[vi] = true;
			}
		}
		scan.close();
	}
}
