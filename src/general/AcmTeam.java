package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/acm-icpc-team">Problem</a>
 */
public class AcmTeam 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		int[][] skills = new int[n][m];
		for (int i = 0; i < n; i++) 
		{
			String mem = scan.nextLine();
			for (int i1=0; i1< mem.length(); i1++) {
				skills[i][i1] = mem.charAt(i1)-'0';
			}
		}
		int maxSkills = 0;
		int maxteams = 0;
		for (int i = 0; i < n; i++) 
		{
			for (int j = i+1; j < n; j++) 
			{
				int sumSkills = sumSkills(skills[i] , skills[j]);
				sumSkills = Math.min(m, sumSkills);
				if (sumSkills > maxSkills )
				{
					maxSkills = sumSkills;
					maxteams = 1;
					continue;
				}
				if (sumSkills !=0 && sumSkills==maxSkills) {
					maxteams++;
				}
			}
		}
		System.out.printf("%d\n%d\n", maxSkills, maxteams);
		scan.close();
	}

	private static int sumSkills(int[] is, int[] is2)
	{
		int sumSkills = 0;
		for (int i = 0; i < is2.length; i++) {
			sumSkills += Math.max(is[i], is2[i]);
		}
		return sumSkills;
	}
}
