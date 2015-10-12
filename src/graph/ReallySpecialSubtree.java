package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReallySpecialSubtree 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int N = scan.nextInt();
		int M = scan.nextInt();

		Edge[] graph = new Edge[M];
		//graph[0] = new Edge(0, 0, 0);
		for (int i = 0; i < M; i++) {
			int x = scan.nextInt()-1;
			int y = scan.nextInt()-1;
			int r = scan.nextInt();
			graph[i] = new Edge(x, y, r);
		}

		scan.nextInt();
		int sum = KruskalMST(graph, N, M);
		System.out.println(sum);
	}

	// The main function to construct MST using Kruskal's algorithm
	public static int KruskalMST(Edge[] graph, int V, int E)
	{
		//Edge[] result = new Edge[V];

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
		int sum = 0;
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
				sum +=nextEdge.weight;
				// result[e++] = nextEdge;
				e++;
				DST.Union(subsets, x, y);
			}
			// Else discard the next_edge
		}

		return sum;
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
