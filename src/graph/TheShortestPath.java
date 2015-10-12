package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//http://www.spoj.com/problems/SHPATH/
public class TheShortestPath 
{
	static StreamTokenizer scan; 
	
	static int nextInt()  {
		try {
			scan.nextToken();
			return (int) scan.nval;
		}
		catch(IOException e) {
			return -1;
		}
	}
	
	static String next()  {
		try {
			scan.nextToken();
			return scan.sval;
		}
		catch(IOException e) {
			return null;
		}
	}
	
	public static void main(String[] args) 
	{
		scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int s = nextInt();
		while (s-->0) 
		{
			int n = nextInt();	//# of cities
			Map<String, Integer> cities = new HashMap<String, Integer>(n+1);
			Vertex[] graph = new Vertex[n+1];
			for (int i = 1; i < n+1; i++) 
			{
				String city = next();
				cities.put(city, i);
				int p = nextInt();	//number of neighbors
				Vertex v = new Vertex(city,i,p);

				for (int j = 0; j < p; j++) {
					Edge e = new Edge(nextInt(), nextInt());
					v.adjacencies[j] = e;
				}
				graph[i]=v;
			}
			int nbOfPath = nextInt();
			while (nbOfPath-->0) {
				System.out.println(solve(graph,graph[cities.get(next())],graph[cities.get(next())]));
			}
		}
	}

	private static int solve(Vertex[] graph, Vertex source, Vertex dest) 
	{
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
			if (u.v.name.equals(dest.name)) {
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
		public String name;
		public int id; 
		public Edge[] adjacencies;
		public Vertex(String argName, int argId, int nbEdges) {
			id = argId; 
			name = argName; 
			adjacencies = new Edge[nbEdges];
		}
	}
	
	
	static class VertexDistance implements Comparable<VertexDistance>
	{
		Vertex v; 
		public int minDistance;
		public VertexDistance(Vertex v, int distance) {this.v = v; minDistance = distance;}
		public int compareTo(VertexDistance other) {
			return Integer.compare(minDistance, other.minDistance);
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
}
