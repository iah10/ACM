package lcpc2014;

import java.util.Scanner;

public class fame 
{	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <=t; i++) 
		{
			pair[] letters = new pair[26];
			for (int j = 0; j <26; j++) {
				letters[j] = new pair((char)('A'+j), 0);
			}
			
			while(true)
			{
				String line = scan.nextLine();
				if (line.equals("*"))  break;
				for (int j = 0; j < line.length(); j++) 
				{
					char letter = line.charAt(j);
					if (letter == ' ') continue;
					int index = Character.toUpperCase(letter)-'A';
					letters[index].count++;
				}
			}
			
			//sort
			for (int j = 0; j < 5; j++) 
			{
				for (int k = 0; k < letters.length-j-1; k++) 
				{
					if(letters[k].count> letters[k+1].count)
					{
						pair temp = letters[k];
						letters[k] = letters[k+1];
						letters[k+1] = temp;
					} 
				}
			}
			
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				if (letters[25-j].count > 0) {
					sum += letters[25-j].letter-'A';
				}
			}
			
			if (sum >62) {
				System.out.printf("Case %d: Effective\n", i);
			} else {
				System.out.printf("Case %d: Ineffective\n", i);
			}
		}
		scan.close();
	}
	
	static class pair {
		char letter;
		int count;
		pair(char l, int c){
			letter = l;
			count = c;
		}
	}
}
