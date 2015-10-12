package lcpc2014;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class poetry 
{
	//static HashMap<PlayingSets, Boolean> dp = new HashMap<PlayingSets, Boolean>();
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int tt = Integer.parseInt(scan.nextLine());
		for (int qq = 1; qq <= tt; qq++) 
		{
			int n = Integer.parseInt(scan.nextLine());
			List<String> p1List = new LinkedList<String>();
			for (int i = 0; i < n; i++) {
				p1List.add(scan.nextLine());
			}
			int m = Integer.parseInt(scan.nextLine());
			List<String> p2List = new LinkedList<String>();
			for (int i = 0; i < m; i++) {
				p2List.add(scan.nextLine());
			}
			
			System.out.println("Game " + qq + ": " + solve(n,m, null,new PlayingSets(p1List, p2List),Player.player1, Player.player2));
		}
		scan.close();
	}
	
	public static Player solve(int n, int m, String letter,PlayingSets playingSets, Player player1, Player player2) 
	{
//		if (dp.containsKey(playingSets)) {
//			return dp.get(playingSets) ? player1: player2;
//		}
		
		if (letter!= null) 
		{
			int index = contains(letter, playingSets.p1List);
			if (index != -1) {	//current player has a string that starts with the letter
				List<String> p1List = playingSets.p1List;
				String sentence = p1List.remove(index);
				List<String> newList = new LinkedList<String>(playingSets.p1List);
				PlayingSets newSet = new PlayingSets(playingSets.p2List, newList);
				String endingLetter = sentence.charAt(sentence.length()-1)+"";
				Player p = solve(m, n-1, endingLetter, newSet, player2, player1);
				p1List.add(index, sentence);
				if (p==player1) {
					return player1;
				}
			} else {	//current player doesn't have a string that starts with the letter
				//dp.put(playingSets, false);	//player1 lost
				return player2;
			}
		}
		
		//else all  combinations 
		for (int i = 0; i < n; i++) 
		{
			List<String> p1List = playingSets.p1List;
			String sentence = p1List.remove(i);
			List<String> newList = new LinkedList<String>(playingSets.p1List);
			PlayingSets newSet = new PlayingSets(playingSets.p2List, newList);
			String endingLetter = sentence.charAt(sentence.length()-1)+"";
			Player p = solve(m, n-1, endingLetter, newSet, player2, player1);
			p1List.add(i, sentence);
			if (p==player1) {
				return player1;
			}
		}
		
		//dp.put(playingSets, false);	//player1 lost
		return player2;
	}
	
	public static int contains(String letter, List<String> p2List) 
	{
		for (int i = 0; i < p2List.size(); i++) {
			if (p2List.get(i).startsWith(letter)) {
				return i;
			}
		}
		return -1;
	}

	private static class PlayingSets {
		List<String> p1List;
		List<String> p2List;
		
		public PlayingSets(List<String> p1List, List<String> p2List) {
			this.p1List = p1List;
			this.p2List = p2List;
		}
		
		
		@Override
		public boolean equals(Object o){
			PlayingSets other  = (PlayingSets) o;
			return p1List.equals(other.p1List) && p2List.equals(other.p2List);
		}
		
	}

	private enum Player {
		player1, player2
	}
}
