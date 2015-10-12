package gametheory;

public class PENim 
{
	public static void main(String[] args) 
	{
		long ans = 0;
		for (long i = 0; i < (1<<30); i++) {
			if ((i^(2*i)^(3*i))==0) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
