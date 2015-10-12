package geometry;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PolarAngles 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			points[i] = new Point(scan.nextInt(), scan.nextInt());
		}
		
		Arrays.sort(points, new Comparator<Point>() {
			
			public int crossProduct(Point p1, Point p2){
				return p1.x*p2.y - p1.y*p2.x;
			}

			@Override
			public int compare(Point p1, Point p2) 
			{
				if (p1.y>0 && p2.y>0 && p1.x >0 && p2.x<0) {
					return 1;
				}
				
				
				if (p1.y==0 || p2.y==0) {
					return Integer.compare(p1.y, p2.y);
				}
				
				if (p1.y*p2.y < 0) 
				{
					if (p1.y > p2.y) {
						return -1;
					} else {
						return 1;
					}
				}
				int cross = crossProduct(p1, p2);
				if (cross < 0) {
					return 1;
				} else if(cross > 0){
					return -1;
				} else {
					if(p1.y>=0){
						return Integer.compare(p1.y, p2.y);
					}else{
						return Integer.compare(p2.y, p1.y);
					}
				}
			} 
		});
		
		for (int i = 0; i < points.length; i++) {
			System.out.printf("%d %d\n", points[i].x, points[i].y);
		}
		scan.close();
	}
}
