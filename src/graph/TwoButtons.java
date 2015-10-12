package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//http://codeforces.com/problemset/problem/520/B
public class TwoButtons 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int m = scan.nextInt();

		if(m <= n) {
			System.out.println(n-m);
		} else {
			System.out.println(bfs(n, m));
		}
	}

	public static int bfs(int start, int end)
	{
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Move> queue = new LinkedList<Move>();
		queue.add(new Move(start, 0));

		while(!queue.isEmpty())
		{
			Move m = queue.poll();
			if(m.num == end) return m.len;
			visited.add(m.num);
			
			int sub = m.num-1;
			int mult = m.num*2;

			if(m.num > end){
				if(!visited.contains(sub)){
					queue.add(new Move(sub, m.len+1));
					visited.add(sub);
				}
			}
			else
			{
				if(!visited.contains(sub))
				{
					if(sub > 0){
						queue.add(new Move(sub, m.len+1));
						visited.add(sub);
					}
				}
				if(!visited.contains(mult))
				{
					queue.add(new Move(mult, m.len+1));
					visited.add(mult);
				}
			}
		}

		return -1;
	}
	
	static class Move
	{
		int num;
		int len;
		public Move(int m, int l){
			num = m;
			len = l;
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
