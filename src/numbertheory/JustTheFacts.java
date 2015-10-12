package numbertheory;
import java.util.Scanner;

public class JustTheFacts 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextInt()) 
		{
			int n = scan.nextInt();
			int result =1;
			for( int i=2; i<=n; ++i) {
				result=f(result*i);
			}
			result%=10;
			if( n<10) 
				System.out.printf("    %d -> %d\n", n, result);
			else if( n>=10 && n<100) 
				System.out.printf("   %d -> %d\n", n, result);
			else if( n>=100 && n<1000) 
				System.out.printf("  %d -> %d\n", n, result);
			else if( n>=1000 && n<10000) 
				System.out.printf(" %d -> %d\n", n, result);
			else 
				System.out.printf("%d -> %d\n", n, result);
		}
		scan.close();
	}
	
	public static int f(int n)
	{
		while( n%10 ==0) {
			n/=10;
		} 
		return n%100000;
	}
}