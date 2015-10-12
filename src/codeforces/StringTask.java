package codeforces;

import java.util.Scanner;

public class StringTask 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < s.length(); i++) 
		{
			char letter  = s.charAt(i);
			if(!isVowel(letter)){
				build.append("."+Character.toLowerCase(letter));
			}
		}
		scan.close();
		System.out.println(build);
	}

	static char[] vowels = {'a','o','u','y','e','i'};
	public static boolean isVowel(char letter) {
		for (int i = 0; i < vowels.length; i++) {
			if (Character.toLowerCase(letter)==vowels[i]) {
				return true;
			}
		}
		return false;
	}
}
