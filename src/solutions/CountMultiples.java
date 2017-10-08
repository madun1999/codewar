package solutions;
import helperMethods.MyMath;
public class CountMultiples {
	//how many integers are there in 1~mxval that divides 2*3*5*7*11...*nth prime
	public static long countSpecMult(long n, long mxval) {
        // your code
		long prod = 1;
		long t = 2;
		long a = 1;
		while(a<=n)
		{
			if (MyMath.isPrime(t))
			{
				prod*=t;
				a++;
			}
			t++;
		}
		return mxval/prod;
    }
}
