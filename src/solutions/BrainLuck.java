 package solutions;

import java.util.*;

public class BrainLuck {
	ArrayList<Integer> memory;
	String code;
	int memPointer;
	int codePointer;
    public BrainLuck(String code) {      
    	this.code = code;
    	memory = new ArrayList<Integer>();
    	memory.add(0);
    	memPointer = 0;
    	codePointer = 0;
    }

    public String process(String input) {
    	boolean flag = true;
    	String output = "";
    	int[] byInput = new int[input.length()];
		for(int i = 0; i<input.length();i++) byInput[i] = input.charAt(i);
    	int inputNum = 0;
    	while(flag)
    	{
    		switch(code.substring(codePointer,codePointer+1))
    		{
    		case ">":pointForward();break;
    		case "<":pointBackward();break;
    		case "+":memInc();break;
    		case "-":memDec();break;
    		case ".":output = output+outp();break;
    		case ",":if (inputNum == byInput.length)flag = false; else inp(byInput[inputNum++]); break;
    		case "[":if(memory.get(memPointer).intValue() ==  0) toNextRightBracket();break;
    		case "]":if(memory.get(memPointer).intValue() !=  0) toPrevLeftBracket();break;
    		}
    		codePointer++;
    		if (codePointer == code.length()){flag = false;}
    	}
    	
    	return output;
    }
//    private void trimMemory(){
//    	while(memPointer != 0 && memory.get(0) ==  0) {memPointer--;memory.remove(0);}
//    	while(memPointer != memory.size()-1 && memory.get(memory.size()-1) ==  0) memory.remove(memory.size()-1);
//    }
    private void addEnd(int num){
    	for(int i = 1;i<=num ;i++) memory.add(0);
    }
    private void addBegin(int num){
    	for(int i = 1; i<=num ;i++){memory.add(0, 0);memPointer++;}
    }
    private void pointForward(){
    	memPointer++;
    	if (memPointer == memory.size()) addEnd(1);
//    	else trimMemory();
    }
    private void pointBackward(){
    	memPointer--;
    	if (memPointer == -1){memPointer = 0;addBegin(1);}
//    	else trimMemory();
    }
    private void memInc(){
    	if (memory.get(memPointer) !=  255) memory.set(memPointer,  (memory.get(memPointer)+1)); else memory.set(memPointer,  0);
    }
    private void memDec(){
    	if (memory.get(memPointer) !=  0) memory.set(memPointer,  (memory.get(memPointer)-1)); else memory.set(memPointer,  255);
    }
    private char outp(){
    	return (char) memory.get(memPointer).intValue();
    }
    private void inp(int instr){
    	memory.set(memPointer,instr);
    }
    private void toNextRightBracket(){
    	int s = 1;
		while (s != 0)
		{
			codePointer++;
			if (code.substring(codePointer,codePointer+1).equals("[")) s++;
			else if (code.substring(codePointer,codePointer+1).equals("]")) s--;
		}
    }
    private void toPrevLeftBracket(){
    	int s = 1;
		while (s != 0)
		{
			codePointer--;
			if (code.substring(codePointer,codePointer+1).equals("[")) s--;
			else if (code.substring(codePointer,codePointer+1).equals("]")) s++;
		}
    }
}