package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/sherlock-and-the-beast"> Problem</a> <br>
 * we will see if N is divisible by 3. If not, we will check for all i whether N−i is divisible by 3 and i by 5. 
 * The first i to satisfy these conditions will be the number of threes and N−i the number of fives.
 */
public class SherlockAndTheBeast 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			System.out.println(sherlock(n));
		}
		scan.close();
	}
	
	private static String sherlock(int n) 
	{
	    int threes = 0;
	    int fives = 0;
	    for (int i = n; i >=0; i--) 
	    {
	    	if (i%3==0 && (n-i)%5==0) 
	    	{
	    		fives = i;
	    		threes = n-i;
	    		break;
			}
		}
	    
	    StringBuilder b = new StringBuilder();
	    if (threes == 0 && fives == 0) 
	    {
	    	return "-1";
		} 
	    else 
		{
			for (int i = 0; i < fives; i++) {
				b.append("5");
			}
			for (int i = 0; i < threes; i++) {
				b.append("3");
			}
		}
	    return b.toString();
	}
}
