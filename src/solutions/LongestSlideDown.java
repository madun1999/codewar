package solutions;

public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
    	for (int x = pyramid.length-2; x>=0;x--)
    	{
    		for (int y = 0; y<=x;y++)
    		{
    			System.out.println(x+" "+y);
    			System.out.println();
        		pyramid[x][y] += Math.max(pyramid[x+1][y], pyramid[x+1][y+1]); 
    		}
    	}
		return pyramid[0][0];
        // Code Goes Here..
    	
    }
}