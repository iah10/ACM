package lcpc2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Question B- http://www.spoj.com/problems/LCPC12B/
public class JohnnyPlaysWithConnect4 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int T = scan.nextInt();
		for (int qq = 1; qq <= T; qq++) 
		{
			int R = scan.nextInt();
			int C = scan.nextInt();
			int[][] grid = new int[R][C];
			int N = scan.nextInt();
			for (int i = 0; i < N; i++) 
			{
				int P = scan.nextInt();
				int Q = scan.nextInt();
				int r = R-1;
				while(grid[r][P] != 0){
					r--;
				}
				grid[r][P] = Q;
			}
			int L = scan.nextInt();
			for (int i = 0; i < L; i++) {
				int angle = scan.nextInt();
				solve(R, C, angle,grid, qq);
			}
			if (L==0) {
				System.out.println(qq+".");
				print(grid, R, C);
			}
		}
	}

	public static void print(int[][] grid, int R, int C) 
	{
		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++) {
				if (grid[i][j]==0) {
					System.out.print(".");
				} else {
					System.out.print(grid[i][j]);
				}
			}
			System.out.println();
		}
	}

	public static void solve(int R, int C, int angle, int[][] grid, int qq) 
	{
		switch (angle) {
		case 90:
			int[][] newGrid90 = rotate90(R, C, grid);
			System.out.println(qq+".");
			print(newGrid90, C, R);
			break;
		case 180:
			int[][] newGrid180 = rotate90(R, C, grid);
			newGrid180 = rotate90(C, R, newGrid180);
			System.out.println(qq+".");
			print(newGrid180, R ,C);
			break;
		case 270:
			int[][] newGrid270 = rotate90(R, C, grid);
			newGrid270 = rotate90(C, R, newGrid270);
			newGrid270 = rotate90(R, C, newGrid270);
			System.out.println(qq+".");
			print(newGrid270, C , R);
			break;
		default:
			break;
		}
	}
	
	private static int[][] rotate90(int R, int C, int[][] grid) 
	{
		for (int i = 0; i < R; i++) 
		{
			for (int j = 0; j < C; j++) 
			{
				int cell = grid[i][j];
				if (cell != 0) 
				{
					int col = j;
					while (col>0 && grid[i][col-1] ==0) {
						grid[i][col-1] = grid[i][col];
						grid[i][col] = 0;
						col--;
					}
				}
			}
		}
		
		int[][] newGrid = new int[C][R];
		for (int cols = 0; cols < C; cols++) {
			for (int rows = 0; rows < R; rows++) {
				newGrid[cols][rows] = grid[rows][cols];
			}
		}
		return newGrid;
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
