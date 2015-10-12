package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class MSTPrim 
{
	public static void main(String[] args) 
	{
		MyScanner scanner = new MyScanner();
		int vertex = scanner.nextInt();
		Vertex[] graph = new Vertex[vertex];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new Vertex();
		}
		
		int edges = scanner.nextInt();
		for (int i = 0; i < edges; i++) 
		{
			int from = scanner.nextInt() - 1;
			int to = scanner.nextInt() - 1;
			int weigth = scanner.nextInt();
			graph[from].addAdjacent(graph[to], weigth);
		}
		
		int start = scanner.nextInt() - 1;
		prim(graph, start);
		int sum = 0;
		for (Vertex node : graph) {
			sum += node.distanceToParent;
		}
		System.out.println(sum);
	}

	public static void prim(Vertex[] nodes, int start) 
	{
		Vertex source = nodes[start];

		source.distanceToParent = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(source);

		while (!pq.isEmpty()) 
		{
			Vertex from = pq.poll();
			from.visited = true;
			for (Edge edge : from.adjacents) 
			{
				Vertex to = edge.to;
				if (!to.visited) 
				{
					if (edge.weigth < to.distanceToParent) {
						if (pq.contains(to)) {
							pq.remove(to);
						}
						to.distanceToParent = edge.weigth;
						pq.add(to);
					}
				}
			}
		}
	}

	public static class Vertex implements Comparable<Vertex> 
	{
		boolean visited = false;
		int distanceToParent = Integer.MAX_VALUE;
		List<Edge> adjacents = new LinkedList<Edge>();

		public void addAdjacent(Vertex node, int weigth) {
			this.adjacents.add(new Edge(node, weigth));
			node.adjacents.add(new Edge(this, weigth));
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(distanceToParent, o.distanceToParent);
		}

	}

	public static class Edge {
		Vertex to;
		int weigth;

		public Edge(Vertex to, int weigth) {
			this.to = to;
			this.weigth = weigth;
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
