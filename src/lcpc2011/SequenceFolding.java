package lcpc2011;

import java.util.Scanner;


public class SequenceFolding 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int qq = 1; qq <=t; qq++) 
		{
			int n = scan.nextInt();
			int[] seq = new int[n];
			for (int i = 0; i < n; i++) {
				seq[i] = scan.nextInt();
			}
			
			while (n >2) 
			{
				for (int i = 0; i < n/2; i++) {
					seq[i] +=seq[n-i-1];
				}
				if (n%2 !=0) {
					seq[n/2] *=2;
				}
				n = (int) Math.ceil(n*1f/2);
			}
			System.out.println("Case #" + qq + ": " + (seq[0] > seq[1] ? "Alice" : "Bob"));
		}
		scan.close();
	}
}
