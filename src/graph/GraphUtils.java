package graph;

import java.util.ArrayList;
import java.util.Stack;

public class GraphUtils 
{
	public static void main(String[] args) 
	{
		int n = 6;
		Vertex[] graph = new Vertex[n];
		for (int i = 0; i <n; i++) {
			graph[i] = new Vertex(i);
		}

		graph[5].adjacencies.add(2);
		graph[5].adjacencies.add(0);
		graph[4].adjacencies.add(0);
		graph[4].adjacencies.add(1);
		graph[2].adjacencies.add(3);
		graph[3].adjacencies.add(1);

		topologicalSort(graph);
		System.out.println();
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
		
		if (isCyclic(cycleGraph)) {
			System.out.println("Graph n2 contains Cycle");
		} if (isCyclic(graph)) {
			System.out.println("Graph n1 contains cycle");
		} else {
			System.out.println("Graph n1 doesn't contians cycles");
		}

	}

	public static boolean isCyclicUtil(int v, Vertex[] graph, boolean[] visited, boolean[] recStack)
	{
		if(visited[v] == false)
		{
			// Mark the current node as visited and part of recursion stack
			visited[v] = true;
			recStack[v] = true;

			// Recur for all the vertices adjacent to this vertex
			ArrayList<Integer> adjacencies = graph[v].adjacencies;
			for (Integer adj : adjacencies) {
				if (!visited[adj] && isCyclicUtil(adj, graph, visited, recStack)) {
					return true;
				} else if (recStack[adj]) {
					return true;
				}
			}
		}
		recStack[v] = false;  // remove the vertex from recursion stack
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	public static boolean isCyclic(Vertex[] graph)
	{
		int n = graph.length;

		// Mark all the vertices as not visited and not part of recursion stack
		boolean[] visited = new boolean[n];
		boolean[] recStack = new boolean[n];

		// Call the recursive helper function to detect cycle in different
		// DFS trees
		for(int i = 0; i < n; i++) {
			if (isCyclicUtil(i, graph,visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	// A recursive function used by topologicalSort
	public static void topologicalSortUtil(int v, Vertex[] graph, boolean visited[], Stack<Integer> stack)
	{
		// Mark the current node as visited.
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		ArrayList<Integer> adjacencies = graph[v].adjacencies;
		for (Integer adj : adjacencies) {
			if (!visited[adj]) {
				topologicalSortUtil(adj, graph, visited, stack);
			}
		}

		// Push current vertex to stack which stores result
		stack.push(v);
	}

	// The function to do Topological Sort. It uses recursive topologicalSortUtil()
	public static void topologicalSort(Vertex[] graph)
	{
		int n = graph.length;
		Stack<Integer> stack = new Stack<Integer>();

		boolean[] visited = new boolean[n];

		// Call the recursive helper function to store Topological Sort
		// starting from all vertices one by one
		for (int i = 0; i < n; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, graph, visited, stack);

		// Print contents of stack
		while (!stack.isEmpty())
		{
			System.out.print(stack.pop() +" ");
		}
	}

	static class Vertex 
	{
		public int value; 
		public ArrayList<Integer> adjacencies;

		public Vertex(int id) {
			value = id; 
			adjacencies = new ArrayList<Integer>();
		}
	}
}
