package acpc2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NassasRobot 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int t = scan.nextInt();
		while (t-->0) 
		{
			String moves = scan.nextLine();
			boolean hasMissed  = moves.contains("?");
			if (!hasMissed) {
				int[]  xy = getXY(moves);
				System.out.printf("%d %d %d %d\n", xy[0], xy[1], xy[0], xy[1]);
			} else {
				int maxX = maximizeX(moves);
				int maxY = maximizeY(moves);
				
				int minX = minimizeX(moves);
				int minY = minimizeY(moves);
				
				System.out.printf("%d %d %d %d\n", minX, minY, maxX, maxY);
			}
		}
	}
	
	private static int minimizeX(String moves) {
		int[] xy = new int[2];
		for (int i = 0; i < moves.length(); i++) 
		{
			char move = moves.charAt(i);
			switch (move) 
			{
			case 'U':
				xy[1]++;
				break;
			case 'R':
				xy[0]++;
				break;
			case 'D':
				xy[1]--;
				break;
			case 'L':
				xy[0]--;
				break;
			case '?':
				xy[0]--;
				break;
			}
		}
		return xy[0];
	}
	
	private static int minimizeY(String moves) {
		int[] xy = new int[2];
		for (int i = 0; i < moves.length(); i++) 
		{
			char move = moves.charAt(i);
			switch (move) 
			{
			case 'U':
				xy[1]++;
				break;
			case 'R':
				xy[0]++;
				break;
			case 'D':
				xy[1]--;
				break;
			case 'L':
				xy[0]--;
				break;
			case '?':
				xy[1]--;
				break;
			}
		}
		return xy[1];
	}
	
	
	private static int maximizeY(String moves) {
		int[] xy = new int[2];
		for (int i = 0; i < moves.length(); i++) 
		{
			char move = moves.charAt(i);
			switch (move) 
			{
			case 'U':
				xy[1]++;
				break;
			case 'R':
				xy[0]++;
				break;
			case 'D':
				xy[1]--;
				break;
			case 'L':
				xy[0]--;
				break;
			case '?':
				xy[1]++;
				break;
			}
		}
		return xy[1];
	}
	
	private static int maximizeX(String moves) {
		int[] xy = new int[2];
		for (int i = 0; i < moves.length(); i++) 
		{
			char move = moves.charAt(i);
			switch (move) 
			{
			case 'U':
				xy[1]++;
				break;
			case 'R':
				xy[0]++;
				break;
			case 'D':
				xy[1]--;
				break;
			case 'L':
				xy[0]--;
				break;
			case '?':
				xy[0]++;
				break;
			}
		}
		return xy[0];
	}

	private static int[] getXY(String moves) {
		
		int[] xy = new int[2];
		for (int i = 0; i < moves.length(); i++) 
		{
			char move = moves.charAt(i);
			switch (move) 
			{
			case 'U':
				xy[1]++;
				break;
			case 'R':
				xy[0]++;
				break;
			case 'D':
				xy[1]--;
				break;
			case 'L':
				xy[0]--;
				break;
			default:
				break;
			}
		}
		return xy;
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
