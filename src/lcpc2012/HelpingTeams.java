package lcpc2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HelpingTeams 
{
	public static void main(String[] args) 
	{
		MyScanner scan= new MyScanner();
		int T = scan.nextInt();
		for (int qq = 1; qq <= T; qq++) 
		{
			int N = scan.nextInt(); //nb of teams
			int M = scan.nextInt(); //money initially

			Team[] teams = new Team[N];
			for (int i = 0; i < N; i++) {
				teams[i] = new Team(scan.nextInt(), scan.nextInt(), scan.nextInt(),scan.nextInt(), scan.nextInt());
			}

			int sol = solve(N,M,teams);
			System.out.printf("Case %d: %d\n",qq,sol);
		}
	}

	private static int solve(int n, long m, Team[] teams)
	{
		int maxTeams = 0;
		Team[] subset = new Team[20];
		Queue<MoneyWithInterest> interests = new LinkedList<MoneyWithInterest>();
		for (int mask = 0; mask < (1 << n); mask++) 
		{
			int index = 0;
			for (int i = 0; i < n; i++) 
			{
				if ((mask & (1 << i)) != 0) {
					subset[index++] = teams[i];
				}
			}
			
			//hard part
			long myMoney = m;
			int teamHelped = 0;
			Arrays.sort(subset,0,index);
			interests.clear();
			//loop over teams in subset
			for (int i = 0; i < index; i++) 
			{
				//add to my money
				while (!interests.isEmpty() && interests.peek().time < subset[i].to) {
					MoneyWithInterest node = interests.poll();
					myMoney += node.moneyWithInterest;
				}

				Team t = subset[i];
				if (myMoney <= t.need) {
					myMoney -= t.need;
					teamHelped++;
					interests.add(new MoneyWithInterest(t.need +t.interest, t.retorn));
				}
			}

			maxTeams = Math.max(teamHelped, maxTeams);
		}
		return maxTeams;
	}

	public static class MoneyWithInterest 
	{
		int moneyWithInterest;
		int time;

		public MoneyWithInterest(int moneyWithInterest, int time) {
			this.moneyWithInterest = moneyWithInterest;
			this.time = time;
		}
	}

	public static class Team implements Comparable<Team> 
	{
		int from;
		int to;
		int need;
		int retorn;
		int interest;

		public Team(int from, int to, int need, int retorn, int interest) {
			this.from = from;
			this.to = to;
			this.need = need;
			this.retorn = retorn;
			this.interest = interest;
		}

		@Override
		public int compareTo(Team o) {
			return (retorn < o.retorn) ? -1 : ((retorn == o.retorn) ? 0 : 1);
		}
	}
	//--------------------------------------------------------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine(){
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	//--------------------------------------------------------
}
