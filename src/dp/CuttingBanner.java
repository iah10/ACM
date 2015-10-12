package dp;
import java.util.Scanner;

//http://codeforces.com/contest/538/problem/A
public class CuttingBanner 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		System.out.println(solveN(word));
		scan.close();
	}

	public static String solveBruteForce(String word) 
	{
		String yes = "YES";
		String no = "NO";
		String codeforces = "CODEFORCES";
		for (int i = 0; i < word.length(); i++) 
		{
			for (int j = i+1; j<=word.length(); j++) 
			{
				String sub = word.substring(0, i) + word.substring(j);
				if (sub.equals(codeforces)) {
					return yes;
				}
			}
		}
		return no;
	}

	private static String solveN(String word)
	{
		String yes = "YES";
		String no = "NO";
		int len = word.length();
		if(len<10) { 
			return no;
		}
		for(int i=0; i <= 10 ; i++)
		{
			String str1 = word.substring(0,i);
			String str2 = word.substring(i+len-10);
			if((str1+str2).equals("CODEFORCES")) {
				return yes;
			}
		}
		return no;
	}
}