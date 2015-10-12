package graph;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//http://codeforces.com/problemset/problem/500/A
public class NewYearTransportation
{	
	public static void main (String[] args) throws java.lang.Exception
	{
		int n = nextInt();
		int t = nextInt();
		Vertex[] graph = new Vertex[n+1];
		for(int i =1; i<=n-1; i++){
			graph[i] = new Vertex(i, i+nextInt());
		}
		graph[n]= new Vertex(n,0);

		dfs(graph, 1, t);
	}

	public static void dfs(Vertex[] graph, int s,int t)
	{
		Vertex c = graph[s];
		//c.visited = true;
		if(s==t){
			System.out.println("YES");
		}
		else if(c.n==0){
			System.out.println("NO");
		} else {
			dfs(graph, c.n , t);
		}
	}

	static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in)); 

	static int nextInt(){
		try{
			scan.nextToken();
			return (int) scan.nval;
		} catch(Exception e){
			return -1;
		}
	}

	public static class Vertex {
		int v;
		int n;
		boolean visited;

		public Vertex(int v1, int n1) {
			v = v1;
			n = n1;
		}
	}
}