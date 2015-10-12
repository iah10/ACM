package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/the-quickest-way-up
public class SnakesAndLadders
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t= scan.nextInt();
		while(t-->0)
		{
			Vertex[] board = new Vertex[101];
			int n = scan.nextInt();	//# of leaders
			for (int i = 0; i < n; i++) 
			{
				int pos = scan.nextInt();
				board[pos]=new Vertex(pos);
				board[pos].adjacencies.add(new Edge(scan.nextInt(), 0));	//going up a ladder costs zero !! TRICK
			}
			
			int m = scan.nextInt();	//# of sneaks
			for (int i = 0; i < m; i++) 
			{
				int pos = scan.nextInt();
				board[pos]=new Vertex(pos);
				board[pos].adjacencies.add(new Edge(scan.nextInt(), 0));	//going down a snake costs zero !! TRICK
			}
			
			//connect to all six adjacent neighbors THIS IS THE TRICK !!!
			for (int i = 1; i <=100; i++) 
			{
				if (board[i]!=null) {	//if the board has a snake or a ladder don't connect !! TRICK
					continue;
				}
				board[i]=new Vertex(i);
				for (int j = 1; j <=6 && i+j<=100; j++) 
				{
					board[i].adjacencies.add(new Edge(i+j, 1));
				}
			}
			
			int solution = dijkstra(board);
			System.out.println(solution);
		
		}
		scan.close();
	}
	
	public static int dijkstra(Vertex[] board)
	{
		Vertex source = board[1];
		source.minDistance=0;
		PriorityQueue<Vertex> queue= new PriorityQueue<Vertex>();
		queue.add(source);
		
		while (!queue.isEmpty()) 
		{
			Vertex u = queue.poll();
			if (u.value==100) {
				return u.minDistance;
			}
			for(Edge e : u.adjacencies)
			{
				Vertex v = board[e.target];
				int weight = e.weight;
				int distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) 
				{
					queue.remove(v);
					v.minDistance = distanceThroughU;
					queue.add(v);
				}
			}
		}
		return -1;
	}
	
	static class Vertex implements Comparable<Vertex>
	{
		public int value;
		public ArrayList<Edge> adjacencies;
		public int minDistance = Integer.MAX_VALUE;
		public Vertex(int argName) { value = argName; adjacencies = new ArrayList<Edge>(8);}
		public int compareTo(Vertex other)
		{
			return Integer.compare(minDistance, other.minDistance);
		}
	}
	
	static class Edge
	{
		public int target;
		public int weight;
		public Edge(int argTarget, int argWeight)
		{ target = argTarget; weight = argWeight; }
	}
}
