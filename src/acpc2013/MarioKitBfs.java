package acpc2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MarioKitBfs
{
    public static void main(String[] args) 
    {
        MyScanner scan = new MyScanner();
        int t = scan.nextInt();
        while (t-->0) 
        {
            int n = scan.nextInt();    //stations
            int m = scan.nextInt();    //number of coins
            int l = scan.nextInt();    //sum

            int[] stations = new int[n];
            for (int i = 0; i < n; i++) {
                stations[i] = scan.nextInt();
            }

            int[] cost = new int[m];
            int[] power = new int[m];

            for (int i = 0; i < m; i++) {
                cost[i] = scan.nextInt();
                power[i] = scan.nextInt();
            }

            solve(stations, cost, power, l);
        }
    }

    private static void solve(int[] stations, int[] cost, int[] power, int l) 
    {
        Arrays.sort(stations);
        int[] dp = dp(stations, cost, power, l);
        Vertex[] graph = buildGraph(stations,dp,l);
        int vertex = bfs(graph);
        System.out.println(vertex);
    }

    public static int[] dp(int[] stations, int[] cost, int[] power, int l) 
    {
        int m = cost.length;
        int n = stations.length;
        int P = stations[n - 1] - stations[0];
        
        int[] dp = new int[P+1];
        
        //initialization
        for(int i=0;i<=P;i++) {
            dp[i]= Integer.MAX_VALUE;
        }
        dp[0]=0;
        
        for (int i = 0; i < m; i++) 
        {
            for (int j = P; j >= power[i]; j--) 
            {
                if (Math.min(dp[j], dp[j - power[i]] + cost[i]) >=0) {
                    dp[j] = Math.min(dp[j], dp[j - power[i]] + cost[i]);
                }
            }
        }
        
        return dp;
    }

    public static Vertex[] buildGraph(int[] stations, int[] dp, int l) 
    {
        int n = stations.length;
        Vertex[] graph = new Vertex[n];

        for (int i = 0; i <n; i++) 
        {
            Vertex v = new Vertex(i);
            graph[i] = v;

            for (int j = i+1; j <n; j++) 
            {
                if (dp[stations[j]-stations[i]] <=l) {
                    v.adjacencies.add(j);
                }
            }
        }
        return graph;
    }

    public static int bfs(Vertex[] graph) 
    {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Queue<Vertex> queue = new LinkedList<Vertex>();
        visited[0] = true;
        queue.add(graph[0]);

        while (!queue.isEmpty()) 
        {
            Vertex v = queue.poll();
            int value = v.value;
            if (value ==  n-1) {
                return v.steps;
            }

            ArrayList<Integer> adj = v.adjacencies;
            for (Integer neig : adj) 
            {
                if (!visited[neig]) {
                    Vertex neighbor = graph[neig];
                    neighbor.steps = v.steps+1;
                    visited[neig] = true;
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }
    
    static class Vertex 
    {
        public int value; 
        public ArrayList<Integer> adjacencies;
        public int steps;

        public Vertex(int argId) {
            value = argId; 
            adjacencies = new ArrayList<Integer>();
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
