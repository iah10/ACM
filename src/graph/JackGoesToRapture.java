package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/jack-goes-to-rapture
public class JackGoesToRapture 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int m = scan.nextInt();
		Vertex[] graph = new Vertex[n+1];
		for (int i = 1; i <=n; i++) {
			graph[i] = new Vertex(i);
		}
		
		for (int i = 1; i <=m; i++) 
		{
			int source = scan.nextInt();
			int dest = scan.nextInt();
			long fare = scan.nextLong();
			
			graph[source].adjacencies.add(new Edge(dest, fare));
			graph[dest].adjacencies.add(new Edge(source, fare));
		}
		
		long val = solve(graph, 1, n, n);
		if (val==-1) {
			System.out.println("NO PATH EXISTS");
		} else {
			System.out.println(val);
		}
	}
	
	public static long solve(Vertex[] graph, int src, int dest, int n) 
	{
		Vertex source = graph[src];

		PriorityQueue<VertexDistance> queue = new PriorityQueue<VertexDistance>();
		VertexDistance sourceD = new VertexDistance(source, 0);
		queue.add(sourceD);

		long[] minimumFare = new long[graph.length];
		for(int i = 1; i <= n; i++){
			minimumFare[i] = Long.MAX_VALUE;
		}
		minimumFare[source.id] = 0;

		while (!queue.isEmpty()) 
		{
			VertexDistance u = queue.poll();
			if (u.vertex.id == dest) {
				return u.minFare;
			}
			
			for (Edge e : u.vertex.adjacencies)
			{
				Vertex nextV = graph[e.target];
				long toPay = e.fare - u.minFare;
				if (toPay<0) toPay=0;
				
				long distanceThroughU = u.minFare + toPay;

				if(minimumFare[nextV.id] > distanceThroughU) {
					queue.add(new VertexDistance(nextV, distanceThroughU));
					minimumFare[nextV.id] = distanceThroughU;
				}
			}
		}
		return -1;
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
		Vertex vertex; 
		public long minFare;
		public VertexDistance(Vertex v, long distance) {this.vertex = v; minFare = distance;}
		
		public int compareTo(VertexDistance other) {
			long x = minFare;
			long y = other.minFare;
			return (x < y) ? -1 : ((x == y) ? 0 : 1);
		}
	}

	static class Edge
	{
		public int target;
		public long fare;
		public Edge(int argTarget, long faree) {
			target = argTarget; fare = faree;
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
