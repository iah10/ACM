package gametheory;

//http://www.spoj.com/problems/NGM/
import java.util.Scanner;

public class AGameWithNumbers 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt()%10;
		if (n != 0) {
			System.out.printf("%d\n%d", 1, n);
		} else {
			System.out.println(2);
		}
		scan.close();
	}
}