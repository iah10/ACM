package lcpc2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class OnTheRoadToLcpcLca
{
	public static int[] lca_h;
	public static int[] lca_first;
	public static int[] lca_tree;
	public static boolean[] lca_dfs_used;

	public static ArrayList<Integer> lca_dfs_list;

	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int T = scan.nextInt();
		for (int qq = 1; qq <= T; qq++) 
		{
			int N = scan.nextInt();
			int Q = scan.nextInt();

			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(N+1);
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < N-1; i++) {
				int fr = scan.nextInt();
				int to = scan.nextInt();

				graph.get(fr).add(to);
				graph.get(to).add(fr);
			}

			lca_prepare(graph, 1);

			System.out.printf("Case %d:\n", qq);
			for (int i = 0; i < Q; i++) 
			{
				int fr = scan.nextInt();
				int to = scan.nextInt();

				int lca = lca(fr, to);

				//Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
				int dist = lca_h[fr] + lca_h[to] -2*lca_h[lca];
				System.out.println(dist);
			}
		}
	}

	public static void lca_prepare (ArrayList<ArrayList<Integer>> g, int root)
	{
		int n = g.size();

		lca_h = new int[n];
		lca_dfs_list = new ArrayList<Integer>(n*2);

		lca_dfs_used = new boolean[n];

		lca_dfs(g, root, 1);

		int m = lca_dfs_list.size();
		lca_tree = new int[lca_dfs_list.size() * 4 + 1];
		Arrays.fill(lca_tree, -1);
		lca_build_tree (1, 0, m-1);

		lca_first = new int[n];
		Arrays.fill(lca_first, -1);
		for (int i = 0; i < m; ++i)
		{
			int v = lca_dfs_list.get(i);
			if (lca_first[v] == -1)
				lca_first[v] = i;
		}
	}

	public static void lca_build_tree (int i, int l, int r)
	{
		if (l == r) {
			lca_tree[i] = lca_dfs_list.get(l);
		} 
		else 
		{
			int m = (l + r) >> 1;
		lca_build_tree (i+i, l, m);
		lca_build_tree (i+i+1, m+1, r);

		if (lca_h[lca_tree[i+i]] < lca_h[lca_tree[i+i+1]]) {
			lca_tree[i] = lca_tree[i+i];
		}
		else {
			lca_tree[i] = lca_tree[i+i+1]; 
		}
		}
	}

	static class Pair {
		int val;
		int h;
		public Pair(int val, int h) {
			this.val = val;
			this.h = h;
		}
	}
	
	public static void lca_dfs (ArrayList<ArrayList<Integer>> graph , int v, int h)
	{
//				    	lca_h[v] = h;
//				        lca_dfs_used[v]= true;
//				        lca_dfs_list.add(v);
//				        for (Integer i : graph.get(v)) {
//					            if (!lca_dfs_used[i])
//				            {
//				                lca_dfs (graph, i, h+1);
//				                lca_dfs_list.add(v);
//				            }
//				        }
				
		Stack<Pair> stack = new Stack<Pair>();
		stack.add(new Pair(v, h));
		while (!stack.isEmpty()) 
		{
			Pair node = stack.pop();
			int u = node.val;
			
			if (!lca_dfs_used[u]) 
			{
				lca_h[u] = node.h;
				lca_dfs_used[u]= true;
				lca_dfs_list.add(u);
				
				for (Integer adj :  graph.get(u))
				{
					if (!lca_dfs_used[adj]) 
					{
						stack.push(new Pair(adj, node.h+1));
						lca_dfs_list.add(u);
					}
				}
			}
		}

	}

	public static int lca_tree_min (int i, int sl, int sr, int l, int r)
	{
		if (sl == l && sr == r) {
			return lca_tree[i];
		}

		int mid = (sl + sr) >> 1;
		if (r <= mid) {
			return lca_tree_min (i+i, sl, mid, l, r);
		} if (l > mid) {
			return lca_tree_min (i+i+1, mid+1, sr, l, r);
		}
		int ans1 = lca_tree_min (i+i, sl, mid, l, mid);
		int ans2 = lca_tree_min (i+i+1, mid+1, sr, mid+1, r);

		return lca_h[ans1] < lca_h[ans2] ? ans1 : ans2;
	}

	public static int lca (int a, int b)
	{
		int left = lca_first[a];
		int right = lca_first[b];
		if (left > right) {
			int temp = right;
			right = left;
			left = temp;
		}
		return lca_tree_min (1, 0, lca_dfs_list.size()-1, left, right);
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