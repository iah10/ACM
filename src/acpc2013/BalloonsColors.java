package acpc2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BalloonsColors 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int t = scan.nextInt();
		while (t-->0) 
		{
			int n = scan.nextInt();	//# of problems
			int x = scan.nextInt();	//# the color the easiest SHOULDN'T get
			int y = scan.nextInt();	//# the color the hardest SHOULDN'T get
			
			int[] colors = new int[n];
			for (int i = 0; i < n; i++) {
				colors[i] = scan.nextInt();
			}
			
			if (colors[0]==x && colors[n-1]==y) {
				System.out.println("BOTH");
			} else if(colors[0]==x && colors[n-1] != y){
				System.out.println("EASY");
			} else if(colors[n-1] ==y && colors[0] != x){
				System.out.println("HARD");
			} else {
				System.out.println("OKAY");
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
