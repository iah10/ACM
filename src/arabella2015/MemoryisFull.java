package arabella2015;

import java.util.Arrays;
import java.util.Scanner;

public class MemoryisFull
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
			int k = scan.nextInt();	//size of mem
			int m = scan.nextInt();	//size of app
			int n = scan.nextInt();
			
			int currenMem = 0;
			int[] apps = new int[n];
			for (int i = 0; i < n; i++) 
			{
				int temp = scan.nextInt();
				currenMem += temp;
				apps[i] = temp;
			}
			Arrays.sort(apps);
			
			int num = 0;
			while(m+currenMem > k){
				currenMem -= apps[n-num-1];
				num++;
			}
			System.out.println(num);
		}
		scan.close();
	}
}
