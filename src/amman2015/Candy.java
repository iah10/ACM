package amman2015;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Candy 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
			int n = scan.nextInt();
			int m = scan.nextInt();
			//students
			Map<Integer, SPair> sMap = new HashMap<Integer, SPair>();
			for (int i = 0; i < n; i++) 
			{
				int age = scan.nextInt();
				if (sMap.containsKey(age)) {
					sMap.get(age).count++;
				}else {
					sMap.put(age, new SPair(age, 1));
				}
			}
			
			//candies
			Map<Integer, SPair> cMap = new HashMap<Integer, SPair>();
			for (int i = 0; i < m; i++) 
			{
				int type = scan.nextInt();
				if (cMap.containsKey(type)) {
					cMap.get(type).count++;
				}else {
					cMap.put(type, new SPair(type, 1));
				}
			}
			
			PriorityQueue<SPair> sQ = new PriorityQueue<Candy.SPair>(sMap.size(),new Comparator<SPair>() {

				@Override
				public int compare(SPair o1, SPair o2) {
					return o2.type - o1.type;
				}
				
			});
			for (Integer sPair : sMap.keySet()) {
				sQ.add(sMap.get(sPair));
			}
			
			PriorityQueue<SPair> cQ = new PriorityQueue<Candy.SPair>(cMap.size(),new Comparator<SPair>() {

				@Override
				public int compare(SPair o1, SPair o2) {
					return o2.type - o1.type;
				}
				
			});
			for (Integer sPair : cMap.keySet()) {
				cQ.add(cMap.get(sPair));
			}
			
			boolean can = false;
			while(!cQ.isEmpty() && !sQ.isEmpty())
			{
				SPair c = cQ.poll();
				SPair s = sQ.peek();
				if (c.count >=s.count) {
					sQ.poll();
					can = true;
				}
			}
			if (!sQ.isEmpty()) {
				can = false;
			}
			if (can) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}
		scan.close();
	}
	
	static class SPair{
		int type;
		int count;
		public SPair(int age, int count) {
			this.type = age;
			this.count = count;
		}
		
	}
}

