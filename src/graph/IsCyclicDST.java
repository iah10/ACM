package graph;

import java.util.ArrayList;

public class IsCyclicDST 
{
	public static void main(String[] args) 
	{
		int V = 3;
		Vertex[] graphWithCycles = new Vertex[V];
		for (int i = 0; i <V; i++) {
			graphWithCycles[i] = new Vertex(i);
		}

		graphWithCycles[0].adjacencies.add(1);
		graphWithCycles[0].adjacencies.add(2);
		graphWithCycles[1].adjacencies.add(2);
		
		System.out.println(isCycle(graphWithCycles, V));	//true
		
		int n = 6;
		Vertex[] graphWithoutCycles = new Vertex[n];
		for (int i = 0; i <n; i++) {
			graphWithoutCycles[i] = new Vertex(i);
		}

		graphWithoutCycles[5].adjacencies.add(2);
		graphWithoutCycles[5].adjacencies.add(0);
		graphWithoutCycles[4].adjacencies.add(0);
		graphWithoutCycles[4].adjacencies.add(1);
		graphWithoutCycles[2].adjacencies.add(3);
		graphWithoutCycles[3].adjacencies.add(1);
		
		System.out.println(isCycle(graphWithoutCycles, n));	//false
		
		int n2 = 4;
		Vertex[] cycleGraph = new Vertex[n2];
		for (int i = 0; i <n2; i++) {
			cycleGraph[i] = new Vertex(i);
		}
		
		cycleGraph[0].adjacencies.add(1);
		cycleGraph[0].adjacencies.add(2);
		cycleGraph[1].adjacencies.add(2);
		cycleGraph[2].adjacencies.add(0);
		cycleGraph[2].adjacencies.add(3);
		cycleGraph[3].adjacencies.add(3);
		
		System.out.println(isCycle(cycleGraph, n2)); //true

	}
	
	// The main function to check whether a given graph contains cycle or not
	public static boolean isCycle(Vertex[] graph, int V)
	{
	    // Create  V sets
	    DST[] subsets = new DST[V];
	    for (int v = 0; v < V; ++v) {
	    	subsets[v] = new DST(v);
	    }
	 
	    // Iterate through all edges of graph, find sets of both
	    // vertices of every edge, if sets are same, then there is
	    // cycle in graph.
	    for(Vertex v : graph)
	    {
	    	int x = DST.find(subsets, v.value);
	    	for(Integer adj :v.adjacencies) 
	    	{
	    		int y = DST.find(subsets, adj);
	    		
	    		if (x == y)
	    			return true;
	    		DST.Union(subsets, x, y);
	    	}
	    }
	    return false;
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

	public static class Vertex 
	{
		int value; 
		ArrayList<Integer> adjacencies;

		public Vertex(int values) {
			value = values; 
			adjacencies = new ArrayList<Integer>();
		}
	}
}
