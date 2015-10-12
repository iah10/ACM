package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CityofBlindingLights 
{
	public static void main(String[] args) 
	{
		int INF = 9999999;
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int m = scan.nextInt();

		int[][] graph = new int[n+1][n+1];
		for (int i = 0; i <=n; i++) {
			for (int j = 0; j <=n; j++) {
				graph[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			graph[scan.nextInt()][scan.nextInt()] = scan.nextInt();
		}

		int[][] result = floydWarshell(graph, n+1);

		int q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if (x==y) {
				System.out.println(0);
			} else {
				System.out.println(result[x][y] == INF ? -1 : result[x][y]);
			}
		}
	}

	// Solves the all-pairs shortest path problem using Floyd Warshall algorithm
	public static int[][] floydWarshell (int graph[][], int V)
	{
		/* dist[][] will be the output matrix that will finally have the shortest 
		      distances between every pair of vertices */
		int dist[][] = new int[V][V];
		int i, j, k;

		/* Initialize the solution matrix same as input graph matrix. Or 
		       we can say the initial values of shortest distances are based
		       on shortest paths considering no intermediate vertex. */
		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		/* Add all vertices one by one to the set of intermediate vertices.
		      ---> Before start of a iteration, we have shortest distances between all
		      pairs of vertices such that the shortest distances consider only the
		      vertices in set {0, 1, 2, .. k-1} as intermediate vertices.
		      ----> After the end of a iteration, vertex no. k is added to the set of
		      intermediate vertices and the set becomes {0, 1, 2, .. k} */
		for (k = 0; k < V; k++)
		{
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++)
			{
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < V; j++)
				{
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		return dist;
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
