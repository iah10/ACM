package dp;
import java.util.Scanner;

//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1346
public class LCS 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine())
		{
			String word1 = scan.nextLine();
			String word2 = scan.nextLine();
			solveDP(word1,word2);
		}
		scan.close();
	}

	public static int solveR(String word1, String word2, int c1, int c2) 
	{
		if (c1 >= word1.length() || c2 >=word2.length()) {
			return 0;
		}
		else if(word1.charAt(c1)==word2.charAt(c2)){
			return 1 + solveR(word1, word2, ++c1, ++c2);
		}
		else {
			return Math.max(solveR(word1, word2, c1, ++c2), solveR(word1, word2, ++c1, c2));
		}
	}

	private static void solveDP(String word1, String word2) 
	{
		int word1Length = word1.length();
		int word2Length = word2.length();
		int[][] lcs = new int[word1Length+1][word2Length+1];
		for (int i = 1; i <=word1Length; i++) 
		{
			for (int j = 1; j <=word2Length; j++) 
			{
				if (word1.charAt(i-1)==word2.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
				else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		System.out.println(lcs[word1Length][word2Length]);
	}
}