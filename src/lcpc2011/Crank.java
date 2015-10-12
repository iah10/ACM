package lcpc2011;

import java.util.Scanner;

public class Crank 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i<= T; i++)
		{
			int R = scan.nextInt();
			int C = scan.nextInt();

			int A = scan.nextInt();	// row
			int B = scan.nextInt();	// column

			int[][] grid = new int[R][C];
			for (int j = 0; j < R; j++)
			{
				for (int j2 = 0; j2 < C; j2++) 
				{
					grid[j][j2] = scan.nextInt();
				}
			}
			int ans = 0;
			for (int j = 0; j < R; j++)
			{
				for (int j2 = 0; j2 < C; j2++) 
				{
					if (j==0 || (j== R-1) ||j2==0 || (j2==C-1)) {
						ans = solveMaze(j, j2, A, B, R, C, grid, new boolean[R][C]) ? ans+1: ans;
					}
				}
			}
			System.out.println("Case #" + i +": "+ ans);
		}
		scan.close();
	}

	public static boolean solveMaze(int r, int c, int A, int B, int R, int C,int[][] grid, boolean[][] visited) 
	{
		boolean solved = false;
		visited[r][c] = true;
		// Check if we have reached our goal
		if (r+1 == A && c+1 == B) {
			return true;
		}

		//move right
		if (c<C-1 && !visited[r][c+1] && grid[r][c+1] <= grid[r][c]) {
			solved  =  solveMaze(r, c+1, A, B, R, C, grid, visited);
		}
		//move left
		if (!solved && c > 0 && !visited[r][c-1] && grid[r][c-1] <= grid[r][c]) {
			solved = solveMaze(r, c-1, A, B, R, C, grid, visited);
		}
		//move up
		if (!solved && r> 0 && !visited[r-1][c] && grid[r-1][c] <= grid[r][c]) {
			solved = solveMaze(r-1, c, A, B, R, C, grid, visited);
		}
		//move down
		if (!solved &&  r< R-1 && !visited[r+1][c] && grid[r+1][c] <= grid[r][c]) {
			solved =  solveMaze(r+1, c, A, B, R, C, grid, visited);
		}
		return solved;
	}
}