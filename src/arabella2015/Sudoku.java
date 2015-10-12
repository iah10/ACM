package arabella2015;

import java.awt.Point;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sudoku
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		while(t-->0)
		{
			int[][] sudoko = new int[10][10];
			
			for (int i = 1; i < 10; i++) 
			{
				String line = scan.nextLine();
				for (int j = 1; j < 10; j++) {
					sudoko[i][j] = Integer.parseInt(line.charAt(j-1)+"");
				}
			}
			
			boolean rows = validateRows(sudoko);
			if (rows) 
			{
				boolean columns = validateCols(sudoko);
				if (columns) 
				{
					boolean grids = validateGrids(sudoko);
					if (grids) { 
						System.out.println("Valid");
					} else {
						System.out.println("Invalid ");
					}
				} else {
					System.out.println("Invalid ");
				}
			} else {
				System.out.println("Invalid ");
			}
			if (t !=0) {
				scan.nextLine();
			}
		}
		scan.close();
	}

	public static boolean validateGrids(int[][] sudoko) 
	{
		Point[] starts = {new Point(1,1), new Point(1,4), new Point(1,7),
						 new Point(4,1), new Point(4,4), new Point(4,7),
						 new Point(7,1), new Point(7,4), new Point(7,7)};
		for (int rows = 1; rows <10; rows++) 
		{
			for (int cols = 1; cols < 10; cols++) 
			{
				Point p = new Point(rows, cols);
				if (containsPoint(starts, p)) 
				{
					Set<Integer> set = new HashSet<Integer>();
					for (int i = rows; i < rows+3; i++) 
					{
						for (int j = cols; j < cols+3; j++) {
							set.add(sudoko[i][j]);
						}
					}
					if (set.size() != 9) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

	public static boolean containsPoint(Point[] starts, Point p)
	{
		for (int i = 0; i < starts.length; i++) {
			if (p.equals(starts[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateCols(int[][] sudoko) 
	{
		for (int cols = 1; cols < 10; cols++) 
		{
			Set<Integer> set = new HashSet<Integer>();
			for (int rows = 1; rows < 10; rows++) {
				set.add(sudoko[rows][cols]);
			}
			if (set.size() != 9) {
				return false;
			}
		}
		return true;
	}

	public static boolean validateRows(int[][] sudoko) 
	{
		for (int rows = 1; rows < 10; rows++) 
		{
			Set<Integer> set = new HashSet<Integer>();
			for (int cols = 1; cols < 10; cols++) {
				set.add(sudoko[rows][cols]);
			}
			if (set.size() != 9) {
				return false;
			}
		}
		return true;
	}
}
