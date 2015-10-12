package acpc2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class IncreasingShortestPath 
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
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int T = nextInt();
		for(int i=0;i<T;i++)
		{
			@SuppressWarnings("unused")
			int N = nextInt();
			int M= nextInt();
			int Q=nextInt();
			@SuppressWarnings("rawtypes")
			ArrayList[] graph = new ArrayList[M+1];
			Edge[] edges= new Edge[M];
			
			//reading edges
			for(int j=0; j<M; j++)
			{
				int from = nextInt();
				int to = nextInt();
				int weight = nextInt();
				Edge e = new Edge(j,from,to,weight);
				edges[j]=e;
				graph[j]=new ArrayList<Edge>();
			}

			//populating graph
			for(int j=0; j<M ;j++)
			{
				for(int k=0; k<M ;k++) 
				{
					if(j != k && edges[j].to==edges[k].from && edges[j].weight < edges[k].weight){
						graph[j].add(edges[k]);
					}
				}
			}

			for(int j=0; j<Q; j++)
			{
				int src=nextInt();
				int dest=nextInt();
				int steps=nextInt();
				System.out.println(solve(src,dest,steps,graph,edges));
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private static int solve(int src, int dest, int steps, ArrayList[] nextEdges,Edge[] edges) 
	{
		if(steps == 0) 
			return -1; 

		int M = edges.length;
		PriorityQueue<EdgeC> queue = new PriorityQueue<EdgeC>();
		
		//visited array list
		ArrayList<ArrayList<EdgeC>> visited = new ArrayList<ArrayList<EdgeC>>(edges.length);
		for(int i=0;i < M;i++) {
			visited.add(new ArrayList<EdgeC>());
		}
		
		//Get the first edges
		for(int i=0; i < M; i++)
		{
			if(edges[i].from == src) 
			{
				EdgeC startEdgeC = new EdgeC(edges[i], 1, edges[i].weight);
				queue.add(startEdgeC);
				visited.get(startEdgeC.e.id).add(startEdgeC);
			}
		}

		while(!queue.isEmpty())
		{
			EdgeC edgeC = queue.remove();

			if(edgeC.steps > steps) continue;

			
			if(edgeC.e.to == dest) {
				return edgeC.sumWeight;
			}
			

			ArrayList nextEdgesC = nextEdges[edgeC.e.id];

			for(int j=0; j < nextEdgesC.size(); j++) 
			{
				Edge tmpEdgeC = (Edge)nextEdgesC.get(j);
				EdgeC nextEdgeC = new EdgeC(tmpEdgeC, edgeC.steps + 1, edgeC.sumWeight + tmpEdgeC.weight);

				if(!visited(visited, nextEdgeC)) 
				{
					visited.get(nextEdgeC.e.id).add(nextEdgeC);
					queue.add(nextEdgeC);
				}
			}
		}
		return -1;
	}

	public static boolean visited(ArrayList<ArrayList<EdgeC>> visited, EdgeC nextEdgeC) 
	{
		for(EdgeC visitedEdgeC: visited.get(nextEdgeC.e.id)) {
			if(visitedEdgeC.sumWeight <= nextEdgeC.sumWeight && visitedEdgeC.steps <= nextEdgeC.steps)
				return true;
		}
		return false; 
	}


	public static class Edge
	{
		int id;
		int from;
		int to;
		int weight;
		public Edge(int id, int from, int to, int weight) 
		{
			this.id = id;
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static class EdgeC implements Comparable<EdgeC>
	{
		Edge e;
		int steps;
		int sumWeight;
		
		public EdgeC(Edge e, int steps, int sumWeight) {
			this.e = e;
			this.steps = steps;
			this.sumWeight = sumWeight;
		}
		
		@Override
		public int compareTo(EdgeC o) {
			if(sumWeight < o.sumWeight) return -1;
			if(sumWeight == o.sumWeight) return steps - o.steps; 
			return 1; 
		}
	}
}