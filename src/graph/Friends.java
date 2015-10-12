package graph;

import java.util.ArrayList;
import java.util.Scanner;


public class Friends 
{
	static int  count=0;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int i = 0; i < testCases; i++) 
		{
			int n = scan.nextInt();
			int pairs = scan.nextInt();
			/*Fill the graph*/
			ArrayList[] graph = new ArrayList[n];
			for (int j = 0; j < pairs; j++) 
			{
				int node = scan.nextInt()-1;
				int friend = scan.nextInt()-1;
				
				if (graph[node] == null) {
					graph[node]= new ArrayList<Integer>();
				}
				graph[node].add(friend);
				
				if (graph[friend] == null) {
					graph[friend]= new ArrayList<Integer>();
				}
				graph[friend].add(node);
			}
			
			/*The hard part*/
			boolean[] visited = new boolean[n]; 	//the visited marker
			int max = 0;
			for (int j = 0; j < n; j++) 
			{
				count=0;
				if (!visited[j]) {
					dfsVisit(j, graph,visited);
					max = count > max ? count : max;
				}
			}
			System.out.println(max);
		}
		scan.close();
	}
	
	@SuppressWarnings("unchecked")
	public static int dfsVisit(int u, @SuppressWarnings("rawtypes") ArrayList[] graph, boolean[] visited)
	{
		visited[u] = true;
		count++;
		ArrayList<Integer> friendsOfNode = graph[u];
		if (friendsOfNode==null) {
			return 0;
		}
		for (Integer friend : friendsOfNode)
		{
			if (!visited[friend]) {
				dfsVisit(friend, graph, visited);
			}
		}
		return count;
	}
}
