package general;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-strings
public class JavaStrings 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int n = scan.nextInt();
		if (s.length()<=1 || s.length()<=n) {
			System.out.println(s);
			System.out.println(s);
			return;
		}
		String maxSub = s.substring(0, n);
		String minSub = s.substring(0, n);
		for (int i = 1; i < s.length()-n+1; i++) 
		{
			String sub = s.substring(i, i+n);
			if(sub.compareTo(maxSub) > 1){
				maxSub = sub;
			}
			if(sub.compareTo(minSub)<0){
				minSub = sub;
			}
		}
		System.out.println(minSub);
		System.out.println(maxSub);
		scan.close();
	}
}
