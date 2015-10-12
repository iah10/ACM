package general;
import java.util.Scanner;

//http://www.spoj.com/problems/LCPC12F/ 
public class JohnnyTheGambler 
{
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) 
		{
			int X = scan.nextInt();
			int N = scan.nextInt();
			
			int[] tally = new int[100001];	//store all possible numbers
			
			long counter = 0; 
			for(int j = 0; j < N; j++)
			{
				int number = scan.nextInt();
				
				if(X - number >= 0) {
					counter += tally[X - number];
					tally[number]++;
				}
			}
			System.out.println((i+1) + ". " + counter);
		}
		scan.close();
	}
}