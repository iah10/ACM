package general;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class LinelandMail 
{
	public static void main(String[] args) 
	{
		int n = nextInt();
		int[] cities = new int[n];
		for (int i = 0; i < n; i++) {
			cities[i] = nextInt();
		}
		
		int maxCity = cities[n-1];
		int minCity = cities[0];
		
		for (int i = 0; i < n; i++)
		{
			int currentCity = cities[i];
			
			int furthest = Math.max(maxCity - currentCity, currentCity - minCity);
			
			
			int preClosest = 0;
			int nextClosest = 0;
			if (i>0) {
				preClosest = currentCity - cities[i-1];
			} 
			if (i<n-1){
				nextClosest = cities[i+1] - currentCity;
			}
			
			int closest = 0;
			if (preClosest==0) {
				closest = nextClosest;
			} else if (nextClosest==0){
				closest = preClosest;
			} else {
				closest = Math.min(preClosest, nextClosest);
			}
			
			System.out.printf("%d %d\n", closest, furthest);
		}
	}
	
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	static int nextInt(){
		try {
			scan.nextToken();
			return (int) scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}
}
