package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/*
 * Problem Statement
 * 
 * Input: A path graph G = (V; E) with nonnegative weights on vertices.
 * 
 * output: Subset of non-adjacent vertices an independent set of maximum total weight.
 */
public class WIS 
{
	static StreamTokenizer scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) 
	{
		int n = nextInt();
		int[] path = new int[n];
		for (int i = 0; i < n; i++) {
			path[i] = nextInt();
		}
		
		int[] memo = new int[n+1];
		
		//find optimal value
		memo[0]=0;
		memo[1] = path[0];
		for (int i = 2; i <=n; i++) {
			memo[i] = Math.max(memo[i-1], memo[i-2]+path[i-1]);
		}
		System.out.println("Optimal value: " + memo[n]);
		
		//construct optimal solution
		int i=n;
		Stack<Integer> stack = new Stack<Integer>();
		while(i >0) 
		{
			if(memo[i] > memo[i-1]){
				stack.push(i--);
			}
			i--;
		}
		//print optimal solution
		System.out.print("Optimal Solution: ");
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
	}
	
	static int nextInt(){
		try {
			scan.nextToken();
			return (int)scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}
}