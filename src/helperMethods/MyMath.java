package helperMethods;

public class MyMath {
	
	
	//isPrime function for both  long and int
	public static boolean isPrime(long num)
	{
		if (num <= 1){return false;}
		else if(num <= 3){return true;}
		else if((num & 1) == 0){return false;}
		else if(num % 3 == 0){return false;}
		else if(num <= 19){return true;}
		else
		{
			int t = 5;
			int max = (int) Math.sqrt(num);
			while (t<=max)
			{
				if (num % t == 0 || num % (t+2) == 0){return false;} 
				t+=6;
			}
		}
		return true;
	}
	public static boolean isPrime(int num)
	{
		if (num <= 1){return false;}
		else if(num <= 3){return true;}
		else if((num & 1) == 0){return false;}
		else if(num % 3 == 0){return false;}
		else if(num <= 19){return true;}
		else
		{
			int t = 5;
			int max = (int) Math.floor(Math.sqrt(num));
			while (t<=max)
			{
				if (num % t == 0 || num % (t+2) == 0){return false;} 
				t+=6;
			}
		}
		return true;
	}
	
	//find index of maximum or minimum of an array of ints or doubles
	public static int maximum(int[] num)
	{
		int max = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]>num[max]) {max = i;}
		}
		return max;
	}
	public static double maximum(double[] num)
	{
		int max = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]>num[max]) {max = i;}
		}
		return max;
	}
	public static int minimum(int[] num)
	{
		int min = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]<num[min]) {min = i;}
		}
		return min;
	}
	public static double minimum(double[] num)
	{
		int min = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]<num[min]) {min = i;}
		}
		return min;
	}
	
	//find sum of an array of ints or doubles
	public static int sum(int[] num){
		int sum = 0;
		for(int a :num)
		{
			sum+=a;
		}
		return sum;
	}
	public static double sum(double[] num){
		double sum = 0;
		for(double a :num)
		{
			sum+=a;
		}
		return sum;
	}

	//find sum of an column of a 2D array
	public static int sumOfColumn(int[][] num, int index){
		int sum = 0;
		for (int a = 0; a<num.length;a++)
		{
			sum+=num[a][index];
		}
		return sum;
	}
	public static double sumOfColumn(double[][] num, int index){
		double sum = 0;
		for (int a = 0; a<num.length;a++)
		{
			sum+=num[a][index];
		}
		return sum;
	}
}
