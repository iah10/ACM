package scpc2013;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Teams 
{
	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
	
	public static void main(String[] args) 
	{
		int t  = nextInt();
		while(t-- >0){
			int a = nextInt();
			int b = nextInt();
			
			int nbOfKidsInTeam  = gcd(a,b);
			int x = (a/nbOfKidsInTeam) *(b/nbOfKidsInTeam);
			System.out.println(nbOfKidsInTeam +" " + x);
		}
	}
	
	public static int gcd(int p, int q)
	{
		while(q !=0){
			int temp  = q;
			q  = p % q;
			p = temp;
		}
		return p;
	}
	
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
