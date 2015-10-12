package arabella2015;

import java.util.Scanner;

public class RelationalOperator 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
			int op1 = scan.nextInt();
			String op = scan.next();
			int op2 = scan.nextInt();
			
			switch (op) {
			case "<":
				System.out.println(op1 < op2);
				break;
			case ">":
				System.out.println(op1 > op2);
				break;
			case "!=":
				System.out.println(op1 != op2);
				break;
			case "==":
				System.out.println(op1 == op2);
				break;
			case "<=":
				System.out.println(op1 <= op2);
				break;
			case ">=":
				System.out.println(op1 >= op2);
				break;
			default:
				break;
			}
		}
		scan.close();
	}
}
