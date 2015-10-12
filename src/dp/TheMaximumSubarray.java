package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//https://www.hackerrank.com/challenges/maxsubarray
public class TheMaximumSubarray 
{
	static StreamTokenizer scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) 
	{
		int t = nextInt();
		while (t-->0) 
		{
			int n = nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			int sol1 = maxSubArraySum(a, n);
			int sol2 = maxSubarrayNonContiguous(a, n);
			System.out.printf("%d %d\n", sol1, sol2);
		}
	}

	private static int maxSubArraySum(int a[], int n)
	{
		int max = a[0], i;
		int curr = a[0];

		for (i = 1; i < n; i++)
		{
			curr = Math.max(a[i], curr+a[i]);
			max = Math.max(max, curr);
		}
		return max;
	}

	static int maxSubarrayNonContiguous(int[] arr, int indexMax) 
	{
		int sumMax = 0;
		int max = arr[0];
		boolean negArray = true;
		int res = 0;
		for (int i = 0; i < indexMax; i++) {
			//add all positive numbers
			if (arr[i] >= 0) {
				sumMax += arr[i];
				negArray = false;
			}
			//find the smallest negative number
			if (arr[i] >= max) { max = arr[i];}
		}

		if (negArray == false)
			res = sumMax;
		//if the array consists of all negative numbers
		//return the smallest number
		if (negArray)
			res = max;

		return res;

	}

	public static int nextInt(){
		try {
			scan.nextToken();
			return (int)scan.nval;
		} catch (IOException e) {
			return -1;
		}
	}
}
