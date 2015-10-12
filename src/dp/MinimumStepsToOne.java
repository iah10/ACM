package dp;

import java.util.Scanner;

//http://www.codechef.com/wiki/tutorial-dynamic-programming  first problem
public class MinimumStepsToOne 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] memo = new int[n+1];
		//base cases
		memo[2] = 1;
		memo[3] = 1;
		for (int i = 4; i <=n; i++) {
			if (i%2==0) {
				memo[i] = 1+ memo[n/2];
			} else if (i%3==0){
				memo[i] = 1+ memo[n/3];
			} else {
				memo[i] = 1+ memo[n-1];
			}
		}
		System.out.println(memo[n]);
		scan.close();
	}
}
