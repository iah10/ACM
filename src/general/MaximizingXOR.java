package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/maximizing-xor">Problem</a>
 */
public class MaximizingXOR 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int res;
		int _l;
		_l = Integer.parseInt(in.nextLine());
		
		int _r;
		_r = Integer.parseInt(in.nextLine());
		
		res = maxXor(_l, _r);
		System.out.println(res);
		in.close();
	}
	
	
	public static int maxXor(int l, int r) 
	{
		int maxXor = 0;
		
		for (int i = l; i <r; i++) 
		{
			for (int j = i; j <r; j++) 
			{
				int xor = i ^j;
				maxXor=  maxXor > (xor) ? maxXor : xor;
			}
		}
		return maxXor;
    }
}
