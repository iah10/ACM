package geometry;

import java.awt.Point;
import java.util.Scanner;


public class RabbitHunt 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n =scan.nextInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			points[i] = new Point(scan.nextInt(), scan.nextInt());
		}
		int maxCount = 0;
		for (int i = 0; i < n; i++) 
		{
			for (int j = i+1; j < n; j++) 
			{
				Line line = new Line(points[i], points[j]);
				int tempCount = 2;
				for (int k = j+1; k < n; k++) 
				{
					if (line.belongsToLine(points[k])) {
						tempCount++;
					}
				}
				maxCount = Math.max(maxCount, tempCount);
			}
		}
		System.out.println(maxCount);
		scan.close();
	}
	
	static class Line {
		Point p1;
		Point p2;
		public Line(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
		public boolean belongsToLine(Point p3){
			return (p3.x - p1.x)*(p2.y-p1.y) - (p2.x - p1.x)*(p3.y - p1.y)==0;
		}
	}
}
