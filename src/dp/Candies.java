package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/candies
public class Candies 
{
	public static void main(String[] args) 
	{
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		int[] ratings = new int[n];
		for (int i = 0; i < n; i++) {
			ratings[i] = scan.nextInt();
		}
		
		int[] cc = new int[n];
        cc[0] = 1;
        for(int i = 1; i < n; i++){
            cc[i] = 1;
            if (ratings[i] > ratings[i-1]){
                cc[i] += cc[i-1];
            } else {
                for(int j = i; j > 0 && ratings[j] < ratings[j-1] && cc[j] == cc[j-1]; cc[--j] += 1){}
            }
        }
        
        long sum = 0;
        for(int i = 0; i < n; sum += cc[i++]){}
        System.out.print(sum);
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
