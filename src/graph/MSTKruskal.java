package graph;

import java.util.Arrays;


/**
 * For a connected and undirected graph
 * 
 * 1. Sort all the edges in non-decreasing order of their weight.
 * 
 * 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree
 * formed so far. If cycle is not formed, include this edge. Else, discard it.
 * 
 * 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 * 
 * Complexity : O(ElogV)
 */
public class MSTKruskal 
{
	public static void main(String[] args) 
	{
		int V = 4;
		int E = 5;
		
		Edge[] graph = new Edge[E];
		
		 // add edge 0-1
		graph[0] = new Edge(0, 1, 10);
	 
	    // add edge 0-2
		graph[1] = new Edge(0, 2, 6);
	 
	    // add edge 0-3
		graph[2] = new Edge(0, 3, 5);
	 
	    // add edge 1-3
		graph[3] = new Edge(1, 3, 15);
	 
	    // add edge 2-3
		graph[4] = new Edge(2, 3, 4);
		
		Edge[] result = kruskalMST(graph, V, E);
		
		// print the contents of result[] to display the built MST
	    System.out.println("Following are the edges in the constructed MST");
	    for (int i = 0; i < V-1; i++) {
	    	System.out.printf("%d -- %d == %d\n", result[i].src, result[i].dest, result[i].weight);
	    }
	}
	
	// The main function to construct MST using Kruskal's algorithm
	public static Edge[] kruskalMST(Edge[] graph, int V, int E)
	{
		Edge[] result = new Edge[V];
	 
	    // Step 1:  Sort all the edges in non-decreasing order of their weight
	    // If we are not allowed to change the given graph, we can create a copy of
	    // array of edges
	    Arrays.sort(graph);
	 
	    // Create  V sets
	    DST[] subsets = new DST[V];
	    for (int v = 0; v < V; ++v) {
	    	subsets[v] = new DST(v);
	    }
	 
	    // Number of edges to be taken is equal to V-1
	    int i = 0;  // An index variable, used for sorted edges
	    int e = 0;  // An index variable, used for result[]
	    while (e < V - 1)
	    {
	        // Step 2: Pick the smallest edge. And increment the index
	        // for next iteration
	        Edge nextEdge = graph[i++];
	 
	        int x = DST.find(subsets, nextEdge.src);
	        int y = DST.find(subsets, nextEdge.dest);
	 
	        // If including this edge does't cause cycle, include it
	        // in result and increment the index of result for next edge
	        if (x != y)
	        {
	            result[e++] = nextEdge;
	            DST.Union(subsets, x, y);
	        }
	        // Else discard the next_edge
	    }
	 
	    return result;
	}
	
	/**
	 * Disjoint Set Data Structure
	 */
	public static class DST 
	{
		int parent;
		int rank;

		//make set
		public DST(int x) {
			parent = x;
			rank = 0;
		}

		// A utility function to find set of an element i
		// (uses path compression technique)
		public static int find(DST[] subsets, int i)
		{
			// find root and make root as parent of i (path compression)
			if (subsets[i].parent != i) {
				subsets[i].parent = find(subsets, subsets[i].parent);
			}
			return subsets[i].parent;
		}

		// A function that does union of two sets of x and y
		// (uses union by rank)
		public static void Union(DST[] subsets, int x, int y)
		{
			int xroot = find(subsets, x);
			int yroot = find(subsets, y);

			// Attach smaller rank tree under root of high rank tree
			// (Union by Rank)
			if (subsets[xroot].rank < subsets[yroot].rank) {
				subsets[xroot].parent = yroot;
			} else if (subsets[xroot].rank > subsets[yroot].rank) {
				subsets[yroot].parent = xroot;
			}
			// If ranks are same, then make one as root and increment
			// its rank by one
			else {
				subsets[yroot].parent = xroot;
				subsets[xroot].rank++;
			}
		}
	}
	
	public static class Edge implements Comparable<Edge>
	{
		int src;
		int dest;
		int weight;
		
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
}
