package general;
import java.util.Scanner;

//http://www.spoj.com/problems/LCPC12A/
public class JohnyDividesByTwo 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			String s = scan.next();
			solve(i, s);
		}
		scan.close();
	}

	private static void solve(int i, String s) 
	{
		int is=0, isNot=0;
		for (int j = 0; j < s.length(); j++)
		{
			if ((s.charAt(j) - '0') % 2 ==0) {
				is +=j+1;
			} else {
				isNot+=j+1;
			}
		}
		System.out.printf("%d. %d %d\n", i, is, isNot);
	}
}