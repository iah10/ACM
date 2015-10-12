package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class RobotsTask 
{
	public static class Pair implements Comparable<Pair>{
		int index;
		int need;
		public Pair(int index, int need) {
			this.index = index;
			this.need = need;
		}
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(need, o.need);
		}
		
	}
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n  = scan.nextInt();
		Pair[] computers = new Pair[n];
		for (int i = 0; i < n; i++)  {
			computers[i] = new Pair(i, scan.nextInt());
		}
		
		Arrays.sort(computers);
		
		int left = 1;
		int right = 0;
		
		int change = 0;
		
		int direction = left;
		int lastIndex = computers[0].index;
		for (int i = 1; i < n; i++)
		{
			if (lastIndex  > computers[i].index && direction != right) {
				change++;
				direction = right;
			} else if(lastIndex  < computers[i].index && direction != left){
				change++;
				direction = left;
			}
			lastIndex = computers[i].index;
		}
		System.out.println(change);
	}
}
