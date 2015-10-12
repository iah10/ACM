package dp;

import java.util.Scanner;

//http://acm.timus.ru/problem.aspx?space=1&num=1260
public class NudnikPhotographer 
{
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int [n+1];
		if (n<3) {
			System.out.println(1);
		}
		else if (n==3){
			System.out.println(3);
		}
		else {
			a[1] = 1; a[2] = 1; a[3] = 2;
			for (int i = 3; i <=n; i++) {
				a[i] = a[i-1] + a[i-3] + 1;
			}
			System.out.println(a[n]);
		}
	}
}
