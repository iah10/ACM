package lcpc2014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class giveaways 	
{
	static StreamTokenizer scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) 
	{
		int t = nextInt();
		for (int qq = 1; qq <=t; qq++)  {
			System.out.printf("Case %d: %d\n", qq, solve());
		}
	}

	public static long solve() 
	{
		int m = nextInt();	//nb of items
		int n = nextInt();	//nb of types
		int c = nextInt();
		Item[] items = new Item[n+1];
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item(i);
		}
		for (int i = 0; i < m; i++) {
			items[nextInt()].quantity++;
		}
		
		Arrays.sort(items);
		long maxAmuse = 0;
		long bagAmuse = 0;
		for (int i = n; i >=1; i--) 
		{
			Item item = items[i];
			bagAmuse += (item.type*item.type) % c;
			maxAmuse = Math.max(maxAmuse, item.quantity*bagAmuse);
		}

		return maxAmuse;
	}

	static int nextInt(){
		try {
			scan.nextToken();
			return (int) scan.nval;
		} catch (Exception e) {
			return -1;
		}
	}

	static class Item implements Comparable<Item> {
		long type;
		int quantity;
		public Item(int type) {
			this.type = type;
		}

		@Override
		public int compareTo(Item o) {
			return quantity - o.quantity;
		}
	}
}