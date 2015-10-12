package lcpc2011;

import java.util.Scanner;

public class Wimbeldon 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int qq = 0; qq < T; qq++) 
		{
			int[] probs = new int[2];
			scan.next(); scan.next();
			probs[0] = scan.nextInt();

			scan.next(); scan.next();
			probs[1] = scan.nextInt();
			
			solve(probs);
		}
		scan.close();
	}

	private static void solve(int[] probs)
	{
		int p1Sets = 0;
		int p2Sets = 0;
		
		int totalGames = 0;
		while (p1Sets !=3 && p2Sets !=3) 
		{
			int turn = 0;
			
			int p1Games = 0;
			int p2Games = 0; 
			
			while (p1Games <6 && p2Games<6) 
			{
				if (turn==0) {
					if (probs[turn] >= probs[1]) {
						p1Games++;
					}
					else{
						p2Games++;
					}
					turn=1;
				} 
				else if (turn==1) 
				{
					if (probs[turn] >= probs[0]) {
						p2Games++;
					}
					else{
						p1Games++;
					}
					turn=0;
				}
			}
			totalGames += p1Games;
			totalGames +=p2Games;
			if (p1Games > p2Games) {
				p1Sets++;
			} else {
				p2Sets++;
			}
		}
		System.out.println(totalGames*5);
	}
}