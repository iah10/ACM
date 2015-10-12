package scpc2013;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Triangles 
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));

	public static void main(String[] args) 
	{
		int t  = nextInt();
		while(t-- >0) 
		{
			int level = nextInt();
			int tCount = countTraingles(level);
			System.out.println(tCount*3);
		}
	}
	
	public static int countTraingles(int L)
	{
		int count = 0;
		for (int i = 1; i <= L; i++) {
			count += i*2 -1;
		}
		return count;
//		if (L< level) {
//			previousRow +=2;
//			tCount += previousRow;
//			countTraingles(L+1, previousRow);
//		}
	}
	
	static int nextInt() 
	{
		try {
			scan.nextToken();
			return (int) scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}
}
