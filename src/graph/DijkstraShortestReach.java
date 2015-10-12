package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/dijkstrashortreach
public class DijkstraShortestReach
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int t = scan.nextInt();
		while (t-->0)
		{
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
				int wieght = scan.nextInt();
				
				graph[source].adjacencies.add(new Edge(dest, wieght));
				graph[dest].adjacencies.add(new Edge(source, wieght));
			}
			
			int s = scan.nextInt();
			int[] dis = solve(graph, s, n);
			for (int i = 1; i < dis.length; i++) 
			{
				if (i==s) continue;
				
				System.out.print(dis[i] == Integer.MAX_VALUE ? -1 : dis[i]);
				if (i != dis.length-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static int[] solve(Vertex[] graph, int src, int n) 
	{
		Vertex source = graph[src];

		PriorityQueue<VertexDistance> queue = new PriorityQueue<VertexDistance>();
		VertexDistance sourceD = new VertexDistance(source, 0);
		queue.add(sourceD);

		int[] minimumDist = new int[graph.length];
		for(int i = 0; i < minimumDist.length; i++){
			minimumDist[i] = Integer.MAX_VALUE;
		}
		minimumDist[src] = 0;

		while (!queue.isEmpty()) 
		{
			VertexDistance u = queue.poll();
			for (Edge e : u.vertex.adjacencies)
			{
				Vertex nextV = graph[e.target];
				int distanceThroughU = u.mindist + e.weight;

				if(minimumDist[nextV.id] > distanceThroughU) {
					queue.add(new VertexDistance(nextV, distanceThroughU));
					minimumDist[nextV.id] = distanceThroughU;
				}
			}
		}
		return minimumDist;
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
		public int mindist;
		public VertexDistance(Vertex v, int distance) {this.vertex = v; mindist = distance;}

		public int compareTo(VertexDistance other) {
			long x = mindist;
			long y = other.mindist;
			return (x < y) ? -1 : ((x == y) ? 0 : 1);
		}
	}

	static class Edge
	{
		public int target;
		public int weight;
		public Edge(int argTarget, int faree) {
			target = argTarget; weight = faree;
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
