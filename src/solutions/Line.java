package solutions;

public class Line {
	//rubbish
	   public static String WhoIsNext(String[] names, int n)
	     {
		   int bigPos =  (int) Math.floor(Math.log((double)n/5+1)/Math.log(2));
		   System.out.println(bigPos);
		   n -= 5 * ((int) Math.pow(2, bigPos)-1)+1;
		   System.out.println(n);
		   n /= (int) Math.pow(2, bigPos);
		   System.out.println(n);
		   return names[n];
	     }
	}
