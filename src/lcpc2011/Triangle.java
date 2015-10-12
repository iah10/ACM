package lcpc2011;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Triangle 
{
	
	public static void main(String[] args) 
	{
		int t = nextInt();
		for (int qq = 1; qq <=t; qq++) 
		{
			int[] sides = new int[3];
			sides[0] = nextInt();
			sides[1] = nextInt();
			sides[2] = nextInt();

			Arrays.sort(sides);
			if (sides[0] + sides[1]>=sides[2]) 
			{
				int c = 0;
				for (int i = 1; i < sides.length; i++) {
					if (sides[i]==sides[i-1]) {
						c++;
					}
				}
				if (c==0) {
					System.out.println("Case #"+qq+": scalene");
				}
				if (c==1) {
					System.out.println("Case #"+qq+": isosceles");
				}
				if(c==2){
					System.out.println("Case #"+qq+": equilateral");
				}
			}
			else {
				System.out.println("Case #"+qq+": invalid!");
			}
		}
	}
	
	
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	static int nextInt() 
	{
		try {
			scan.nextToken();
			return (int) scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}
}
