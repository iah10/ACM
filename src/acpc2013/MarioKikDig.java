package acpc2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MarioKikDig 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int t = scan.nextInt();
		while (t-->0) 
		{
			int n = scan.nextInt();	//stations
			int m = scan.nextInt();	//number of coins
			int l = scan.nextInt();	//sum

			int[] stations = new int[n];
			for (int i = 0; i < n; i++) {
				stations[i] = scan.nextInt();
			}

			int[] cost = new int[m];
			int[] power = new int[m];

			for (int i = 0; i < m; i++) {
				cost[i] = scan.nextInt();
				power[i] = scan.nextInt();
			}

			solve(stations, cost, power, l);
		}
	}

	private static void solve(int[] stations, int[] cost, int[] power, int l) 
	{
		Arrays.sort(stations);
		int[] dp = dp(stations, cost, power);
		Vertex[] graph = buildGraph(stations,dp,l);
		int result = dijkstra(graph);
		System.out.println(result);
	}

	//dp to calculate the minimum cost to reach a station with exactly P power
	public static int[] dp(int[] stations, int[] cost, int[] power) 
	{
		int m = cost.length;
		int n = stations.length;
		int P = stations[n - 1] - stations[0];

		int[] dp = new int[P+1];

		for(int i=0;i<=P;i++) {
			dp[i]= Integer.MAX_VALUE;
		}
		dp[0]=0;

		for (int i = 0; i < m; i++) 
		{
			for (int j = P; j >= power[i]; j--) 
			{
				if (Math.min(dp[j], dp[j - power[i]] + cost[i]) >=0) {
					dp[j] = Math.min(dp[j], dp[j - power[i]] + cost[i]);
				}
			}
		}

		return dp;
	}

	public static Vertex[] buildGraph(int[] stations, int[] dp, int l) 
	{
		int n = stations.length;
		Vertex[] graph = new Vertex[n];

		for (int i = 0; i <n; i++) 
		{
			Vertex v = new Vertex(i);
			graph[i] = v;

			for (int j = i+1; j <n; j++) 
			{
				if (dp[stations[j]-stations[i]] <=l) {
					v.adjacencies.add(new Edge(j, 1));
				}
			}
		}
		return graph;
	}

	public static int dijkstra(Vertex[] graph) 
	{
		Vertex source = graph[0];

		PriorityQueue<VertexDistance> queue = new PriorityQueue<VertexDistance>();
		VertexDistance sourceD = new VertexDistance(source, 0);
		queue.add(sourceD);

		int[] minimumVisited = new int[graph.length];
		for(int i = 0; i < minimumVisited.length; i++){
			minimumVisited[i] = Integer.MAX_VALUE;
		}
		minimumVisited[source.id] = 0;

		while (!queue.isEmpty()) 
		{
			VertexDistance u = queue.poll();
			if (u.v.id == graph.length-1) {
				return u.minDistance;
			}

			for (Edge e : u.v.adjacencies)
			{
				Vertex v = graph[e.target];

				int distanceThroughU = u.minDistance + e.weight;

				if(minimumVisited[v.id] > distanceThroughU) {
					queue.add(new VertexDistance(v, distanceThroughU));
					minimumVisited[v.id] = distanceThroughU;
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
