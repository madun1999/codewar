package solutions;

import java.util.ArrayList;

public class Decompose {
	  public String decompose(long n) {
		  
		  for (long i=n-1;i>=1;i--)
		  {
			  ArrayList<Long> longs = decompose((n-i)*(n+i),i);
			  if (longs != null)
			  {
				  String out = "";
				  for (int t = 0; t < longs.size()-1; t++)
				  {
					  out = out + longs.get(t)+" ";
				  }
				  out = out + longs.get(longs.size()-1) ;
				  return out;
			  }
		  }
		  return "";
	  }
	  
	  public ArrayList<Long> decompose(long n, long a)
	  {
		  
		  if (n == 0) {ArrayList<Long> temp = new ArrayList<Long>();temp.add(a);return temp;}
		  long i = (long)Math.floor(Math.sqrt(n));
		  if (i>=a) i=a-1;
		  for( ;i>=1;i--)
		  {
			  ArrayList<Long> longs = decompose(n-i*i,i);
			  if(longs != null)
			  {
				  longs.add(a);
				  return longs;
			  }
		  }

		  return null;
	  }
}
