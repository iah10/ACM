package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/bfsshortreach
public class BFSShortestReach 
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int t =  scan.nextInt();
		for (int qq = 1; qq <=t; qq++) 
		{
			int n = scan.nextInt();
			int m = scan.nextInt();
			ArrayList[] graph = new ArrayList[n+1];
			for (int j = 1; j <=n; j++) {
				graph[j] = new ArrayList<Integer>();
			}
			for (int j = 0; j < m; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				graph[x].add(y);
				graph[y].add(x);
			}
			
			int s = scan.nextInt();
			
			boolean[] visited = new boolean[n+1];
			int[] distance =  new int[n+1];
			Queue<Integer> queue = new LinkedList<Integer>();
			visited[s] = true;
			queue.add(s);
			while (!queue.isEmpty()) 
			{
				int v = queue.poll();
				ArrayList<Integer> neighbors = graph[v];
				for (Integer adj : neighbors) 
				{
					if (!visited[adj]) {
						visited[adj] = true;
						distance[adj] = distance[v] +6;
						queue.add(adj);
					}
				}
			}
			
			for (int j = 1; j < distance.length; j++)
			{
				if (j==s) {
					continue;
				}
				System.out.print(distance[j]==0 ? -1 + " " : distance[j] + " ");
			}
			System.out.println();
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
