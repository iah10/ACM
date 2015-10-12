package general;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/game-of-thrones">Problem</a>
 */
public class GameOfThrones 
{
	public static void main(String[] args) 
	{
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();

		String ans = solve(inputString);
		System.out.println(ans);
		myScan.close();
	}

	private static String solve(String inputString) 
	{
		int[] chars = new int[26];
		for (int i = 0; i < inputString.length(); i++) 
		{
			int index = inputString.charAt(i) - 'a';
			chars[index]++;
		}
		int odds = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 0 && chars[i]%2 !=0) {
				odds++;
			}
		}
		if (inputString.length() %2 == 0 && odds ==0) {
			return "YES";
		}
		if(inputString.length() %2 != 0 && odds ==1){
			return "YES";
		}
		return "NO";
	}
}
