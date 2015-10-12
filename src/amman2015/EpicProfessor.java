package amman2015;

import java.util.Scanner;

public class EpicProfessor 
{
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		int tt = scan.nextInt();
		for (int qq = 1; qq <=tt; qq++) 
		{
			int n = scan.nextInt();
			int[] telly = new int[101];
			for (int i = 0; i < n; i++) {
				telly[scan.nextInt()]++;
			}
			int maxBonus = 0;
			int i =100;
			while (telly[i--]==0) {
				maxBonus++;
			}
			int studCount = 0;
			for (int j = 0; j < telly.length; j++) {
				if (telly[j]!=0 && j+maxBonus>=50) {
					studCount +=telly[j];
				}
			}
			System.out.println(studCount);
		}
		scan.close();
	}
}
