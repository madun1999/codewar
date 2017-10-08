package solutions;
public class DuplicateEncoder {
	//replace characters that occurred more than once by ")" 
	//and character that occurred only once by "("
	//case insensitive
	public static String encode(String word){
		word = word.toLowerCase();
		boolean left = word.indexOf("(")!= -1 && word.substring(word.indexOf("(")+1).indexOf("(") != -1;
		boolean right = word.indexOf(")")!= -1 && word.substring(word.indexOf(")")+1).indexOf(")") == -1;
		if (left)
		{
			if (right)
			{
				String newWord = "";
				while(!word.equals(""))
				{
					if (word.substring(0,1).equals("(")) { newWord = newWord + ")";}
					else if (word.substring(0,1).equals(")")) { newWord = newWord + "(";}
					else{newWord = newWord + word.substring(0,1);
					}
					word = word.substring(1);
										
				}
				word = newWord;
			}
			else
			{
				word = word.replace('(', ')');
			}
		}
		else if (right)
		{
			word = word.replace(')', '(');
		}
		
		for(int t = 0; t<word.length(); t++)
		{
			char letter = word.charAt(t);
			if (letter != ')' && letter != '(')
			{
				if(word.substring(t+1).indexOf(letter) != -1)
				{ word = word.replace(letter, ')'); }
				else { word = word.replace(letter,'('); }
			}
		}
    return word;
  }
}
