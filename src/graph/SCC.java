package graph;

import java.util.ArrayList;
import java.util.Stack;

public class SCC 
{
	public static void main(String[] args) 
	{
		int n = 5;
		Vertex[] graph = new Vertex[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new Vertex(i);
		}

		graph[1].adjacencies.add(0);
		graph[0].adjacencies.add(2);
		graph[2].adjacencies.add(1);
		graph[0].adjacencies.add(3);
		graph[3].adjacencies.add(4);
		
		printSCC(graph);
	}

	public static void printSCC(Vertex[] graph) 
	{
		int n = graph.length;
		Stack<Integer> stack = new Stack<Integer>();
		//1. dfs_1
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				fillOrder(i, graph, visited, stack);
			}
		}

		//2. Get Transpose
		Vertex[] graphT = getTranspose(graph);

		//3. dfs_2
		boolean[] visited2 = new boolean[n];

		// Now process all vertices in order defined by Stack
		while (!stack.isEmpty())
		{
			// Pop a vertex from stack
			int v = stack.pop();

			// Print Strongly connected component of the popped vertex
			if (!visited2[v])
			{
				DFSUtil(v, graphT,visited2);
				System.out.println();
			}
		}

	}

	//dfs_1 visit
	public static void fillOrder(int v, Vertex[] graph, boolean[] visited, Stack<Integer> stack)
	{
		visited[v] = true;

		ArrayList<Integer> adjacencies = graph[v].adjacencies;
		for (Integer adj : adjacencies) {
			if (!visited[adj]) {
				fillOrder(adj, graph, visited, stack);
			}
		}

		// All vertices reachable from v are processed by now, push v to Stack
		stack.push(v);
	}

	//get the transpose of the graph
	public static Vertex[] getTranspose(Vertex[] graph) 
	{
		int n = graph.length;
		Vertex[] graphT = new Vertex[n];
		for (int i = 0; i < n; i++) {
			graphT[i] = new Vertex(i);
		}
		
		for (int i = 0; i < n; i++) {
			Vertex v = graph[i];
			ArrayList<Integer> neighbors = v.adjacencies;
			for (Integer neighbor : neighbors) {
				graphT[neighbor].adjacencies.add(v.value);
			}
		}
		return graphT;
	}

	// A recursive function to do DFS starting from v
	public static void DFSUtil(int v, Vertex[] graph, boolean[] visited)
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		ArrayList<Integer> adjacencies = graph[v].adjacencies;
		for (Integer adj : adjacencies) {
			if (!visited[adj]) {
				DFSUtil(adj, graph ,visited);
			}
		}
	}

	public static class Vertex
	{
		int value;
		ArrayList<Integer> adjacencies;

		public Vertex(int v){
			value = v;
			adjacencies = new ArrayList<Integer>();
		}
	}
}
