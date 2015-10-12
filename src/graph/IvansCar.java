package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

//http://acm.timus.ru/problem.aspx?num=1930
public class IvansCar 
{
	static StreamTokenizer scan;

	static int nextInt() {
		try {
			scan.nextToken();
			return (int) scan.nval;
		} catch (IOException e) {
			return -1;
		}
	}

	public static void main(String[] args) 
	{
		scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		int n = nextInt();
		int m = nextInt();

		HashMap<Integer, HashSet<Edge>> adjacency = new HashMap<Integer, HashSet<Edge>>(m);

		for (int i = 0; i < m; i++) {
			int from = nextInt();
			int to = nextInt();
			addEdge(2 * i, adjacency, from, to, true);
			addEdge(2 * i + 1, adjacency, to, from, false);
		}

		int source = nextInt();
		int dest = nextInt();
		
		System.out.println(solve(adjacency, source, dest, n, m));
	}
	
	public static void addEdge(int id, HashMap<Integer, HashSet<Edge>> adjacency,
			int from, int to, boolean direction) 
	{
		if (adjacency.containsKey(from)) {
			adjacency.get(from).add(new Edge(id, from, to, direction));
		} else {
			HashSet<Edge> edges = new HashSet<Edge>();
			edges.add(new Edge(id, from, to, direction));
			adjacency.put(from, edges);
		}
	}

	private static int solve(HashMap<Integer, HashSet<Edge>> adjacency,
			int source, int dest, int n, int m) 
	{
		if (source == dest) {
			return 0;
		}

		PriorityQueue<EdgeC> queue = new PriorityQueue<EdgeC>();
		
		
		int[] visited = new int[2*m];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = Integer.MAX_VALUE;
		}		
		
		for (Edge e : adjacency.get(source)) {
			EdgeC sourceEdge = new EdgeC(e, 0);
			queue.add(sourceEdge);	
			visited[e.id] = 0; 
		}

		
		while (!queue.isEmpty()) 
		{
			EdgeC edgeC = queue.poll();
			
			if (edgeC.edge.to == dest) {
				return edgeC.nbOfGears;
			}

			for (Edge neighbor : adjacency.get(edgeC.edge.to)) 
			{
				EdgeC nextEdge;
				if (neighbor.isUp == edgeC.edge.isUp) {
					nextEdge = new EdgeC(neighbor, edgeC.nbOfGears);
				} else {
					nextEdge = new EdgeC(neighbor, edgeC.nbOfGears + 1);
				}
				if (nextEdge.nbOfGears < visited[neighbor.id]) {
					visited[neighbor.id] = nextEdge.nbOfGears;
					queue.add(nextEdge);
				}
			}
		}
		return 0;
	}

	static class Edge 
	{
		int id; 
		int from;
		int to;
		boolean isUp;

		public Edge(int id, int from, int to, boolean up) {
			this.from = from;
			this.to = to;
			this.isUp = up;
			this.id = id; 
		}
	}

	static class EdgeC implements Comparable<EdgeC> 
	{
		Edge edge;
		int nbOfGears;

		public EdgeC(Edge edge, int nbOfGears) {
			this.edge = edge;
			this.nbOfGears = nbOfGears;
		}

		@Override
		public int compareTo(EdgeC o) {
			return nbOfGears - o.nbOfGears;
		}
	}
}