package codeforces;

import java.util.Scanner;

public class WayTooLongWords 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int N =  scan.nextInt();
		while (N-->0) 
		{
			String s = scan.next();
			if (s.length()<=10) {
				System.out.println(s);
			} else {
				System.out.println(s.charAt(0)+""+(s.length()-2)+""+s.charAt(s.length()-1));
			}
		}
		scan.close();
	}
}
