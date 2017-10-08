package solutions;
import helperMethods.MyMath;
public class ConwayLife {

	  public static int[][] getGeneration(int[][] cells, int generations) {
	        // your code goes here
	    if (generations == 0) return cells;
	    cells = expand(expand(cells));
	    int[][] nextCells = new int[cells.length-2][cells[0].length-2];
	    for(int i = 1;i<cells.length-1;i++)
	    {
	      for(int j = 1; j<cells[0].length-1;j++)
	      {
	        nextCells[i-1][j-1] = ifLive(cells,i,j,cells[i][j]);
	      }
	    }
	    nextCells = trim(nextCells);
	    return getGeneration(nextCells,generations-1);
	  }
	  
	  public static int[][] trim(int[][] cells){
	    int a1 = 0;
	    int b1 = 0;
	    int a2 = 0;
	    int b2 = 0;
	    while (MyMath.sum(cells[a1]) == 0)
	    {
	      a1++;
	    }
	    while (MyMath.sum(cells[cells.length-1-a2])==0)
	    {
	      a2++;
	    }
	    while(MyMath.sumOfColumn(cells, b1)==0)
	    {
	      b1++;
	    }
	    while(MyMath.sumOfColumn(cells, cells[0].length-1-b2)==0)
	    {
	      b2++;
	    }
	    int[][] nextCells = new int[cells.length-a1-a2][cells[0].length-b1-b2];
	    for(int i = a1;i<cells.length-a2;i++)
	    {
	      for(int j = b1; j<cells[0].length-b2;j++)
	      {
	        nextCells[i-a1][j-b1] = cells[i][j];
	      }
	    }
	    return nextCells;
	  }
	  
	  public static int[][] expand(int[][] cells){
	    int[][] nextCells = new int[cells.length+2][cells[0].length+2];
	    for(int i = 0;i<cells.length;i++)
	    {
	      for(int j = 0; j<cells[0].length;j++)
	      {
	        nextCells[i+1][j+1] = cells[i][j];
	      }
	    }
	    return nextCells;
	  }
	  public static int ifLive(int[][] cells, int x, int y, int prev){
	    
	    int count = cells[x-1][y-1] + cells[x-1][y] + cells[x-1][y+1] + cells[x][y-1] + cells[x][y+1] + cells[x+1][y-1] + cells[x+1][y] + cells[x+1][y+1];
	    if ((count == 3) || (count == 2 && prev == 1)) return 1;
	    else return 0;
	  }
}