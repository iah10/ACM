package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//http://codeforces.com/contest/449/problem/B
public class JzzhuAndCities 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
		
		Vertex[] graph = new Vertex[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new Vertex(i);
		}
		
		for (int i = 0; i < m; i++) {
			int u = scan.nextInt(), v = scan.nextInt(), x =scan.nextInt();
			graph[u].adjacencies.add(new Edge(v, x)); 
			graph[v].adjacencies.add(new Edge(u, x)); 
		}
		
		long[] dist = dijkstra(n, graph);
		
		int toRemove = 0;
		for (int i = 0; i < k; i++) 
		{
			int s = scan.nextInt(), y = scan.nextInt();
			if (y>=dist[s]) {
				toRemove++;
			}
		}
		System.out.println(toRemove);
	}
	
	public static long[] dijkstra(int n, Vertex[] graph) 
	{
		Vertex source = graph[1];
		
		long[] dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		
		PriorityQueue<VertexDistance> queue = new PriorityQueue<>(n);
		VertexDistance sourceD = new VertexDistance(source, 0);
		queue.add(sourceD);
		
		while (!queue.isEmpty())
		{
			VertexDistance u = queue.poll();
			
			for(Edge e : u.v.adjacencies)
			{
				Vertex v = graph[e.target];

				int distanceThroughU = u.minDistance + e.weight;

				if(dist[v.id] > distanceThroughU) {
					queue.add(new VertexDistance(v, distanceThroughU));
					dist[v.id] = distanceThroughU;
				}
			}
			
		}
		return dist;
	}

	static class Vertex 
	{
		public int id; 
		public ArrayList<Edge> adjacencies;

		public Vertex(int argId) {
			id = argId; 
			adjacencies = new ArrayList<Edge>();
		}
	}

	static class VertexDistance implements Comparable<VertexDistance>
	{
		Vertex v; 
		public int minDistance;
		public VertexDistance(Vertex v, int distance) {this.v = v; minDistance = distance;}

		public int compareTo(VertexDistance other) {
			int x = minDistance;
			int y = other.minDistance;
			return (x < y) ? -1 : ((x == y) ? 0 : 1);
		}
	}

	static class Edge
	{
		public int target;
		public int weight;
		public Edge(int argTarget, int argWeight) {
			target = argTarget; weight = argWeight;
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
