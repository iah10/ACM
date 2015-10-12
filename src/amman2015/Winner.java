package amman2015;

import java.util.Arrays;
import java.util.Scanner;

public class Winner 
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tt = scan.nextInt();
		for (int qq = 1; qq <=tt; qq++) 
		{
			int n = scan.nextInt();
			Player[] players = new Player[n];
			for (int i = 0; i < n; i++) {
				players[i] = new Player(scan.next(), scan.nextInt(), scan.nextInt());
			}
			Arrays.sort(players);
			System.out.println(players[n-1].name);
		}
		scan.close();
	}

}

class Player implements Comparable<Player>{
	String name;
	int solved;
	int penalty;
	public Player(String name, int solved, int penalty) {
		this.name = name;
		this.solved = solved;
		this.penalty = penalty;
	}

	@Override
	public int compareTo(Player o) {
		int sDif = solved - o.solved;
		if (sDif ==0) {
			return o.penalty - penalty;
		}
		return sDif;
	}
}
