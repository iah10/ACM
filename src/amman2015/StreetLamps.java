package amman2015;

import java.util.Scanner;

public class StreetLamps 
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tt = scan.nextInt();
		for (int qq = 1; qq <=tt; qq++) 
		{
			int n = scan.nextInt();
			char[] blocks = scan.next().toCharArray();
			boolean[] lit = new boolean[n]; 
			for (int i = 0; i < n; i++) {
				lit[i] = blocks[i]=='*' || (i>0 && blocks[i-1]=='*') || (i<n-1 && blocks[i+1]=='*');
			}
			int needed = 0;
			for (int i = 0; i < lit.length; i++) 
			{
				if (!lit[i]) 
				{
					float count=0;
					while(i< lit.length && !lit[i++]){
						count++;
					}
					needed += Math.ceil(count/3);
				}
			}
			System.out.println(needed);
		}
		scan.close();
	}
}