package solutions;
import java.math.BigInteger;

public class Fibonacci {
//fib(n) n is a BigInteger
  public static BigInteger fib(BigInteger n) {
    // ...
	  if (n.equals(BigInteger.valueOf(2)) || n.equals(BigInteger.ONE)) return BigInteger.ONE;
	  if (n.equals(BigInteger.ZERO)) return n;
	  
	  BigInteger[] prod = {BigInteger.ONE,BigInteger.ZERO,BigInteger.ZERO,BigInteger.ONE}, a = (n.signum() == 1) ? (new BigInteger[] {BigInteger.ONE,BigInteger.ONE,BigInteger.ONE,BigInteger.ZERO}) : (new BigInteger[] {BigInteger.ZERO,BigInteger.ONE,BigInteger.ONE,BigInteger.valueOf(-1)});
	  
	  while(!n.equals(BigInteger.ZERO)){
		  if (n.and(BigInteger.ONE).equals(BigInteger.ONE))
		  {
			  prod = times(a,prod);
		  }
	  		a = times(a,a);
	  		n = n.divide(BigInteger.valueOf(2));
	  }
	  return prod[2] ;
  }
  public static BigInteger[] times(BigInteger[] a,BigInteger[] b){
	  return new BigInteger[] {a[0].multiply(b[0]).add(a[1].multiply(b[2])),a[0].multiply(b[1]).add(a[1].multiply(b[3])),a[2].multiply(b[0]).add(a[3].multiply(b[2])),a[2].multiply(b[1]).add(a[3].multiply(b[3]))};
  }
  
}