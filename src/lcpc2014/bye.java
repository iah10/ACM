package lcpc2014;

import java.util.Scanner;

public class bye
{
    public static void main (String[] args) throws java.lang.Exception
    {
		Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int i=0;
        while(i++<t)
        {
            int hc = scan.nextInt();
            int mc = scan.nextInt();
            int hw = scan.nextInt();
            int mw = scan.nextInt();
            
            System.out.printf("Case %d: %d\n", i,(hw-hc)*60-mc+mw);
        }
        scan.close();
    }
}
