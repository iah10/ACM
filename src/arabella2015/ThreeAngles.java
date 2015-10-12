package arabella2015;

import java.util.Scanner;

public class ThreeAngles 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
			int o1 = scan.nextInt();
			int o2 = scan.nextInt();
			int o3 = scan.nextInt();
			
			int sum = o1 + o2 + o3;
			if (sum == 180 && o1 != 0 && o2!=0 && o3!=0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
		scan.close();
	}
}
