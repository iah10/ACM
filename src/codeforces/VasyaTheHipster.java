package codeforces;

import java.util.Scanner;

//http://codeforces.com/contest/581/problem/A
public class VasyaTheHipster 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int redSocks = scan.nextInt();
		int blueSocks = scan.nextInt();
		int fashionPairs = Math.min(redSocks, blueSocks);
		redSocks -= fashionPairs;
		blueSocks -= fashionPairs;
		int remainingPairs = redSocks/2 + blueSocks/2;
		System.out.println(fashionPairs +" " + remainingPairs);
		scan.close();
	}
}
