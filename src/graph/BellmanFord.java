package graph;

import java.util.Arrays;

public class BellmanFord 
{
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) 
	{
		int V = 5;
		int E = 8;
		
		Edge[] graph = new Edge[E];
		
		// add edge 0-1
		graph[0] = new Edge(0, 1, -1);
	 
	    // add edge 0-2
		graph[1] = new Edge(0, 2, 4);
	 
	    // add edge 1-2
		graph[2] = new Edge(1, 2, 3);
	 
	    // add edge 1-3
		graph[3] = new Edge(1, 3, 2);

		// add edge 1-4
		graph[4] = new Edge(1, 4, 2);
	 
	    // add edge 3-2
	    graph[5] = new Edge(3, 2, 5);
	 
	    // add edge 3-1
	    graph[6] = new Edge(3, 1, 1);
	 
	    // add edge 4-3
	    graph[7] = new Edge(4, 3, -3);
	    
	    int[] dist = bellmanFord(graph, V, E, 0);
	    if (!hasNegativeCycle(graph, dist, E)) {
	    	System.out.printf("Vertex   Distance from Source\n");
	        for (int i = 0; i < V; ++i)
	        	System.out.printf("%d \t\t %d\n", i, dist[i]);
		}
	 
	}
	
	public static int[] bellmanFord(Edge[] graph, int V, int E, int src)
	{
		int dist[]  = new int[V];
		
		// Step 1: Initialize distances from src to all other vertices as INFINITE
		Arrays.fill(dist, INF);
	    dist[src] = 0;
	    
	    // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src
	    // to any other vertex can have at-most |V| - 1 edges
	    for (int i = 1; i <= V-1; i++)
	    {
	        for (int j = 0; j < E; j++)
	        {
	            int u = graph[j].src;
	            int v = graph[j].dest;
	            int weight = graph[j].weight;
	            if (dist[u] != INF && dist[u] + weight < dist[v])
	                dist[v] = dist[u] + weight;
	        }
	    }
	    return dist;
	}
	
	public static boolean hasNegativeCycle(Edge[] graph, int[] dist, int E)
	{
		// Step 3: check for negative-weight cycles.  The above step guarantees
	    // shortest distances if graph doesn't contain negative weight cycle.
	    // If we get a shorter path, then there is a cycle.
	    for (int i = 0; i < E; i++)
	    {
	        int u = graph[i].src;
	        int v = graph[i].dest;
	        int weight = graph[i].weight;
	        if (dist[u] != INF && dist[u] + weight < dist[v])
	           return true;
	    }
		return false;
	}
	
	public static class Edge {
		int src;
		int dest;
		int weight;
		
		public Edge(int src, int dest, int cost) {
			this.src = src;
			this.dest = dest;
			this.weight = cost;
		}
	}
}
