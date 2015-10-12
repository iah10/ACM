package lcpc2011;

import java.util.Scanner;

public class Calculator 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int T =scan.nextInt();
		for (int qq = 1; qq <= T; qq++) 
		{
			int val = scan.nextInt();
			String p = scan.next();
			System.out.println("Case #" + qq +": " + (int)solve(p,val));
		}
		scan.close();
	}

	public static double solve(String p, int val) {
		double ans=0;
		for (int i = 0; i < p.length(); i++)
		{
			int C = 1;
			int E = 1;
			int X = 1;
			
			char token = p.charAt(i);
			if (token=='-') 
			{
				//get C
				String tempC = "";
				while (i< p.length()-1 &&  Character.isDigit(p.charAt(i+1))) {
					tempC +=p.charAt(++i);
				}
				C  = tempC.isEmpty() ? 1 : Integer.parseInt(tempC);
				C *= -1;
				
				//get x
				if (i< p.length()-1 && p.charAt(i+1)=='X') 
				{
					X = val;
					i++;
					if (i< p.length()-1 && p.charAt(i+1)=='^') 
					{
						i++;
						//get E
						String tempE = "";
						while (i< p.length()-1 && Character.isDigit(p.charAt(i+1))) {
							tempE +=p.charAt(++i);
						}
						E  = Integer.parseInt(tempE);
					}
				}
			}
			else if(token=='+')
			{
				//get C
				String tempC = "";
				while (i< p.length()-1 && Character.isDigit(p.charAt(i+1))) {
					tempC +=p.charAt(++i);
				}
				C  = tempC.isEmpty() ? 1 : Integer.parseInt(tempC);
				//get x
				if (i< p.length()-1 && p.charAt(i+1)=='X') 
				{
					X = val;
					i++;
					if (i< p.length()-1 && p.charAt(i+1)=='^') 
					{
						i++;
						//get E
						String tempE = "";
						while (i< p.length()-1 && Character.isDigit(p.charAt(i+1))) {
							tempE +=p.charAt(++i);
						}
						E  = Integer.parseInt(tempE);
					}
				}
			} 
			else if(Character.isDigit(token)) 
			{
				//get C
				String tempC = ""+token;
				while (i< p.length()-1 &&  Character.isDigit(p.charAt(i+1))) {
					tempC +=p.charAt(++i);
				}
				C  = Integer.parseInt(tempC);
				//get x
				if (i< p.length()-1 && p.charAt(i+1)=='X')
				{
					X = val;
					i++;
					if (i < p.length()-1 && p.charAt(i+1)=='^') 
					{
						i++;
						//get E
						String tempE = "";
						while (i< p.length()-1 && Character.isDigit(p.charAt(i+1))) {
							tempE +=p.charAt(++i);
						}
						E  = Integer.parseInt(tempE);
					}
				}
			}
			else if(token=='X')
			{
				X = val;
				if (i< p.length() -1 && p.charAt(i+1)=='^') 
				{
					i++;
					//get E
					String tempE = "";
					while (i< p.length()-1 && Character.isDigit(p.charAt(i+1))) {
						tempE +=p.charAt(++i);
					}
					E  = Integer.parseInt(tempE);
				}
			}
			ans += C*Math.pow(X, E);
		}
		return ans;
	}
}