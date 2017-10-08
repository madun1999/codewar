package solutions;

import java.util.List;
import java.util.ArrayList;

public class MathEvaluator {
	
	
	private class MathElement{
		private int type;
		private double value;
		
		MathElement(int a, double b)
		{
			this.type = a;
			this.value = b;
		}
		public double getValue()
		{
			return value;
		}
		public int getType()
		{
			return type;
		}
		public boolean equals(Object a)
		{
			if (a == this) return true;
			if (a instanceof MathElement)
			{return ((MathElement) a).getType() == this.type ;}
			return false;
			
		}
	}
	
	
	public double calculate(String expression) {
		ArrayList<MathElement> mathExp = evaluateString(expression);


		return evaluateArray(mathExp);
	}
	public ArrayList<MathElement> evaluateString(String a){
		a = a.replaceAll("\\+", " + ");
		a = a.replaceAll("\\-", " - ");
		a = a.replaceAll("\\*", " * ");
		a = a.replaceAll("/", " / ");
		a = a.replaceAll("\\(", " ( ");
		a = a.replaceAll("\\)", " ) ");
		String[] t = a.split(" ");

		ArrayList<MathElement> returns = new ArrayList<MathElement>();
		for (String element : t)
		{
			switch (element){
			case "+":returns.add(new MathElement(1,0));break;
			case "-":returns.add(new MathElement(2,1));break;
			case "":break;
			case "/":returns.add(new MathElement(3,2));break;
			case "*":returns.add(new MathElement(4,3));break;
			case "(":returns.add(new MathElement(5,4));break;
			case ")":returns.add(new MathElement(6,5));break;
			default:returns.add(new MathElement(0,Double.valueOf(element).doubleValue()));
			}
		}
		return returns;
	}
	private int max(int x1, int x2){
		 int find;
		 if(x1 == -1) if(x2 == -1) find = -1;else find = x2;else if(x2 == -1) find = x1;else find = Math.min(x1,x2);
		 return find;
		 }
	private double evaluateArray(List<MathElement> a)
	{
		if (a.size() == 0) return 0;
		int find = a.indexOf(new MathElement(5,4));

		while (find != -1)
		{
			int s = 1;
			int end = find;
			while (s != 0)
			{
				end++;
				if (a.get(end).equals(new MathElement(5,4))) s++;
				else if (a.get(end).equals(new MathElement(6,5))) s--;
			}
			a.remove(end);a.remove(find);

			a.set(find, new MathElement(0,evaluateArray(a.subList(find, end-1))));
			find = a.indexOf(new MathElement(5,4));
		}
		
		 find = max(a.indexOf(new MathElement(4,4)),a.indexOf(new MathElement(3,3)));
		 
		 while(find != -1 )
		 {
			 if (a.get(find+1).equals(new MathElement(2,1)))
			 {
				 a.remove(find+1);
				 a.set(find+1, new MathElement(1, 0 - a.get(find+1).getValue()));
			 }
			 if(a.get(find).equals(new MathElement(3,1)))
			 {
				 a.set(find-1, new MathElement(0,a.get(find-1).getValue()/a.remove(find+1).getValue()));a.remove(find);
			 }
			 else
			 {
				 a.set(find-1, new MathElement(0,a.get(find-1).getValue()*a.remove(find+1).getValue()));a.remove(find);
			 }
			 find = max(a.indexOf(new MathElement(4,4)),a.indexOf(new MathElement(3,3)));

		 }
		 
		 find = max(a.indexOf(new MathElement(2,4)),a.indexOf(new MathElement(1,3)));
		 while(find != -1 )
		 {
			 if (a.get(find+1).equals(new MathElement(2,1)))
			 {
				 a.remove(find+1);
				 a.set(find+1, new MathElement(0, 0 - a.get(find+1).getValue()));
			 }
			 if (find == 0 || a.get(find-1).getType()>=1)
			 {
				 a.remove(find);
				 a.set(find, new MathElement(0,0-a.get(find).getValue()));
				 find = max(a.indexOf(new MathElement(1,4)),a.indexOf(new MathElement(2,3)));
				 continue;
			 }
			 if(a.get(find).equals(new MathElement(2,1)))
			 {
				 a.set(find-1, new MathElement(0,a.get(find-1).getValue()-a.remove(find+1).getValue()));a.remove(find);
			 }
			 else
			 {
				 a.set(find-1, new MathElement(0,a.get(find-1).getValue()+a.remove(find+1).getValue()));a.remove(find);
			 }
			 find = max(a.indexOf(new MathElement(1,4)),a.indexOf(new MathElement(2,3)));
		 }
		 return a.get(0).getValue();
	}

}

