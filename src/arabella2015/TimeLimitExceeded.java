package arabella2015;

import java.util.Scanner;

public class TimeLimitExceeded
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
			int n = scan.nextInt();

			long count = 0;
			int[] arr = new int[10001];
			for(int j = 0; j < n; j++) 
			{
				int element = scan.nextInt();
				for(int k = 1; k < 32; k++) 
				{
					if(element + k < 10001) {
						count += arr[element + k];
					}
					
					if(element - k >= 0) {
						count += arr[element - k]; 
					}
				}
				count += arr[element];
				arr[element]++;
			}
			System.out.println(count);
		}
		scan.close();
	}
}
