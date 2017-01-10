
public class Recursion {
	
	
	public static void main(String[] arg)
	{
		System.out.println(posWays(3));
	}
	
	public static int posWays(int steps)
	{
		if (steps == 0)
		{
			return 1; 
		}
		if (steps < 0)
		{
			return 0;
		}
		return posWays(steps-1) + posWays(steps-2) + posWays(steps-3);
	}

}
