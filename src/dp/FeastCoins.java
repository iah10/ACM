package dp;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;


public class FeastCoins
{
    static StreamTokenizer scan = new StreamTokenizer(new InputStreamReader(System.in));
    
    public static void main(String[] args) 
    {
        int t = nextInt();
        for (int qq = 1; qq <=t; qq++) 
        {
            int s = nextInt();
            int n = nextInt();
            int[] coins = new int[n];
            int[] count = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = nextInt();
                count[i] = nextInt();
            }
            System.out.println("Case " + qq + ": "+solve(s,n,coins,count));
        }
    }
    
    // S= n.Ci + n.Ci2 + ... + nCin
    // S / n = Ci + Ci2 + ... + Cin
    public static long solve(int s, int n, int[] coins, int[] count) 
    {
        List<Integer> factors = findFactors(s);
        long ways = 0;
        for (int i = 0; i < factors.size(); i++) 
        {
            int desiredSum = factors.get(i);    //n
            int requiredNumOfCoins = s/desiredSum;    //S/n
            ways +=  countCoins(desiredSum,filterCoins(coins, count, requiredNumOfCoins));
        }
        return ways;
    }

    public static long countCoins(int sum, int[] coins) 
    {
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        int currentSum =0;
        for (int i = 0; i < coins.length; i++)
        {
            currentSum += coins[i];
            for (int j = Math.min(sum, currentSum); j >= coins[i]; j--) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }
    
    public static int[] filterCoins(int[] coins, int[] count, int minCount)
    {
        List<Integer> filtered =  new ArrayList<Integer>(coins.length);
        for (int i = 0; i < coins.length; i++) {
            if (count[i] >=minCount) {
                filtered.add(coins[i]);
            }
        }
        return toIntArray(filtered);
    }
    
    public static int[] toIntArray(List<Integer> list) 
    {
          int[] ret = new int[list.size()];
          for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
          return ret;
        }

    public static List<Integer> findFactors(int num)
    {
        int incrementer = 1;
        if (num % 2 != 0) {
            incrementer = 2; //only test the odd ones
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= num / 2; i+=incrementer)
        {
            if (num % i == 0) {
                list.add(i);
            }
        }
        list.add(num);
        return list;
    }

    static int nextInt()
    {
        try {
            scan.nextToken();
            return (int)scan.nval;
        } catch (Exception e) {
            return -1;
        }
    }
}