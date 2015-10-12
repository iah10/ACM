package amman2015;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class RuntimeError
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	public static void main(String[] args) 
	{
		long t = nextLong();
		while (t-->0) 
		{
			int n  = (int) nextLong();
			long k = nextLong();
			long[] values = new long[n];
			for (int i = 0; i <n; i++) {
				values[i] = nextLong();
			}
			Arrays.sort(values);
			boolean stop = false;
			for (int i = 0; i < n; i++) 
			{
				if (stop) {
					break;
				}
				long x = values[i];
				if(x==0 || k%x !=0) continue;
				int yIndex = Arrays.binarySearch(values, i+1, n,k/x);
				if (yIndex >=0) {
					System.out.println(x+" "+values[yIndex]);
					stop=true;
				}
			}
			if (!stop) {
				System.out.println(-1);
			}
		}
	}
	
	public static long nextLong(){
		try {
			scan.nextToken();
			return (long)scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}
}
