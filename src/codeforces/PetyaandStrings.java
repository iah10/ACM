package codeforces;

import java.util.Scanner;

public class PetyaandStrings
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next().toLowerCase();
		String s2 = scan.next().toLowerCase();
		System.out.println(Integer.compare(s1.compareTo(s2),0));
		scan.close();
	}
}
