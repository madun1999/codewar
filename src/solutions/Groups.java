package solutions;

import helperMethods.MyMath; 

public class Groups {
	//check if the string has the correct brackets
	public static boolean groupCheck(String s){
	    if (s.equals("")) return true;
	    int round = s.indexOf(")") == -1 ? s.length()+1:s.indexOf(")");
	    int rect = s.indexOf("]") == -1 ? s.length()+1:s.indexOf("]");
	    int flow = s.indexOf("}") == -1 ? s.length()+1:s.indexOf("}");
	    int[] a = {round,rect,flow};
	    int b = MyMath.minimum(a);
	    if (a[b]==0 || a[b] == s.length()+1) return false;
	    if ((b==0 && s.substring(a[0]-1, a[0]).equals("("))||(b==1 && s.substring(a[1]-1, a[1]).equals("["))||(b==2 && s.substring(a[2]-1, a[2]).equals("{")))
	    	return groupCheck((a[b]>1 ? s.substring(0,a[b]-1):"")+s.substring(a[b]+1));
	    else
	    	return false;

	}
	  
}
