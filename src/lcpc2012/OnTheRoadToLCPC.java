package lcpc2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OnTheRoadToLCPC 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int T = scan.nextInt();
		for (int qq = 1; qq <= T; qq++) 
		{
			int N = scan.nextInt();
			int Q = scan.nextInt();

			int[] parent = new int[N+1];

			for (int i = 0; i < N-1; i++) {
				int fr = scan.nextInt();
				int to = scan.nextInt();

				parent[to] = fr;
			}

			System.out.printf("Case %d:\n", qq);
			for (int i = 0; i < Q; i++) 
			{
				int fr = scan.nextInt();
				int to = scan.nextInt();

				long cTo = 1;
				long cFrom = 1;

				int parentTo = parent[to];
				int parentFrom = parent[fr];

				long ans = 0;
				while(parentTo != parentFrom) 
				{
					if ( (parentTo == parentFrom)) {
						ans = cTo  + cFrom;
						break;
					} 
					else if((parentFrom == to)){
						ans = cFrom;
						break;
					}
					else 
					{
						parentTo = parent[parentTo];
						parentFrom = parent[parentFrom];
						if (parentTo != 0) {
							cTo++; 
						}
						if (parentFrom != 0) { 
							cFrom++;
						}
					}
				}
				ans = cTo  + cFrom;
				System.out.println(ans);
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
