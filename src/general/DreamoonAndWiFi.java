package general;

import java.util.Scanner;

//http://codeforces.com/problemset/problem/476/B
public class DreamoonAndWiFi
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		
		int supposedPosition = 0;
		for (int i = 0; i < s1.length(); i++)
		{
			if (s1.charAt(i)=='+') {
				supposedPosition++;
			} else {
				supposedPosition--;
			}
		}
		scan.close();
		
		//bit masking
		//double answerBitMask = solveBitMask(s1,s2, supposedPosition);
		//System.out.printf("%.12f\n",answerBitMask);
		
		//dfs
		solveDFS(s1.length(), 0, 0, s2, supposedPosition);
		System.out.printf("%.12f\n", correctWays/ways);
	}

	static double correctWays = 0;
	static double ways = 0;
	public static void solveDFS(int len, int indexS2, int position, String s2, int supposedPosition) 
	{
		if (indexS2==len)
		{
			ways++;
			if (position==supposedPosition) {
				correctWays++;
			}
		} else {
			if (s2.charAt(indexS2)=='+') {
				solveDFS(len, indexS2+1, position+1, s2, supposedPosition);
			} else if(s2.charAt(indexS2)=='-') {
				solveDFS(len, indexS2+1, position-1, s2, supposedPosition);
			} else {
				solveDFS(len, indexS2+1, position-1, s2, supposedPosition);
				solveDFS(len, indexS2+1, position+1, s2, supposedPosition);
			}
		}
	}

	public static double solveBitMask(String s1, String s2, int supposedPosition) 
	{
		//0 --> -
		//1 --> +
		int countQusetionMarks = 0;
		int expectedPosition = 0;
		for (int i = 0; i < s2.length(); i++) 
		{
			if (s2.charAt(i)=='?') {
				countQusetionMarks++;
			} else if(s2.charAt(i)=='+'){
				expectedPosition++;
			} else {
				expectedPosition--;
			}
		}
		
		double c =0;
		for (int mask = 0; mask < (1 << countQusetionMarks); mask++) 
		{
			int tempPosition = expectedPosition;
			for (int j = 0; j < countQusetionMarks; j++) 
			{
				if ((mask & (1<<j)) !=0 ) 
				{
					tempPosition++;
				} else {
					tempPosition--;
				}
			}
			
			if (tempPosition==supposedPosition) {
				c++;
			}
		}
		return c/(1<<countQusetionMarks);
	}
}
