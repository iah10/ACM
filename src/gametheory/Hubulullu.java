package gametheory;

import java.util.Scanner;

public class Hubulullu 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
			scan.nextInt();
			int m  = scan.nextInt();
			if (m==0) {
				System.out.println("Airborne wins.");
			} else {
				System.out.println("Pagfloyd wins.");
			}
		}
		scan.close();
	}
}
