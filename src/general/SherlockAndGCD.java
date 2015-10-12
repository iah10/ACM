package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/sherlock-and-gcd">Problem</a> <br>
 * 
 * This question can be reduced to a simpler one: Check if there is a non-empty
 * subset such that the Greatest Common Divisor (GCD) of the whole subset is 1.
 * Note that if you have a and b such that GCD(a,b) is 1, then GCD(a,b,x,y,z...)
 * will always be 1. So, if the whole array has GCD 1, then print YES, else
 * print NO.
 */
public class SherlockAndGCD 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int T =scan.nextInt();
		for(int i=0;i<T;i++)
		{
			int N = scan.nextInt();
			int[] a = new int[N];
			int gcd = 0;
			for(int j=0;j<N;j++)
			{
				a[j] = scan.nextInt();
				gcd = gcd(gcd,a[j]);
			}

			String out = gcd==1 ? "YES" : "NO";
			System.out.println(out);
		}
		scan.close();
	}

	public static int gcd(int m, int n)
	{
		while(n>0){
			int tmp = n;
			n = m % n;
			m = tmp;
		}
		return m;
	}
}
