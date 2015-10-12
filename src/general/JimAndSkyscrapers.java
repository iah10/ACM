package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//https://www.hackerrank.com/challenges/jim-and-the-skyscrapers
public class JimAndSkyscrapers 
{
	static StreamTokenizer scan;
	
	static int nextInt()  {
		try {
			scan.nextToken();
			return (int) scan.nval;
		}
		catch(IOException e) {
			return -1;
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n = nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++){
			nums[i] = nextInt();
		}
		int sol = 0;
		for(int i=0; i<n; i++)
		{
			int num = nums[i];
			int j=i+1;
			while(j<n && nums[j] <=num)
			{
				if(nums[j]==num)
					sol++;
				j++;
			}
		}
		System.out.println(sol*2);
	}
}
