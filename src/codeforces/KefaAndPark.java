package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KefaAndPark 
{
	static boolean visited[];
	static Vertex[] graph;
	static int maxCats;

	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();

		int N = scan.nextInt();
		maxCats = scan.nextInt();

		graph = new Vertex[N+1];
		graph[0] = new Vertex(0, false);
		for (int i = 1; i <= N; i++) {
			graph[i] = new Vertex(i, scan.nextInt()==1);

		}

		for (int i = 0; i < N-1; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();

			graph[x].adjacencies.add(y);
			graph[y].adjacencies.add(x);

		}
		visited = new boolean[N+1];

		dfs(1, 0);
		System.out.println(ways);
	}

	static int ways = 0;
	public static void dfs(int v, int catsSoFar) 
	{
		visited[v] = true;
		if (graph[v].hasCat)  {
			catsSoFar++;
		} else {
			catsSoFar = 0;
		}

		if (catsSoFar > maxCats) {
			return;
		}

		if (graph[v].adjacencies.size()==1 && v !=1) {
			ways++;
			return;
		} 
		for(Integer e: graph[v].adjacencies){
			if (!visited[e]) {
				dfs(e, catsSoFar);
			}
		}
	}


	static class Vertex 
	{
		public int id; 
		public boolean hasCat;
		public ArrayList<Integer> adjacencies;
		public Vertex(int argId, boolean hasCat) {
			id = argId; 
			adjacencies = new ArrayList<>();
			this.hasCat = hasCat;
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
