package general;

import java.util.Scanner;

public class StandingOvation 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int qq = 1; qq <=t; qq++) 
		{
			int Smax = scan.nextInt();
			int[] shyness = new int[Smax+1];
			String freq = scan.next();
			for (int i = 0; i <=Smax; i++) {
				shyness[i] = freq.charAt(i) - '0';
			}
			
			int numToInvite = 0;
			int alreadyStoed = 0;
			
			for (int i = 0; i <=Smax; i++) 
			{
				if (shyness[i]==0) {
					continue;
				}
				if (alreadyStoed >=i) {
					alreadyStoed += shyness[i];
				} else {
					int diff = i - alreadyStoed;
					numToInvite += diff;
					alreadyStoed += diff + shyness[i];
				}
			}
			System.out.printf("Case #%d: %d\n",qq,numToInvite);
		}
		scan.close();
	}
}
