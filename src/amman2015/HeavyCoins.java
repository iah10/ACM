package amman2015;

import java.util.Scanner;

public class HeavyCoins 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-->0) 
		{
			int n = scan.nextInt();
			int s = scan.nextInt();
			int[]coins = new int[n];
			for (int i = 0; i < n; i++) {
				coins[i] = scan.nextInt();
			}
			
			int ans = 0;
			for (int mask = 0; mask < (1 << n); mask++) 
			{
				int sum = 0;
				for (int i = 0; i < n; i++) {
					if ((mask & (1 << i)) != 0) {
						sum += coins[i];
					}
				}
				//check if subset obeys the rule
				if (sum >= s) 
				{
					boolean ok = true;
					for (int i = 0; i < n; i++) 
					{
						if ((mask & (1 << i)) != 0) {
							if (sum-coins[i] >= s) {
								ok = false;
								break;
							}
						}
					}   
					if (ok) {
						ans = Math.max(ans, Integer.bitCount(mask));
					}
				}
			}
			System.out.println(ans);
		}
		scan.close();
	}
}