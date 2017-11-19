import java.util.*;
import java.lang.*;

public class Operators {

	
	
	public boolean isOperator(char x)   {
		if(x=='/' || x=='-' || x=='+' || x=='*') return true;
		return false;
	}
	public int operateHere(int arg1, int arg2, char operator) {
		
		int answer = 0;
		if(operator == '+') {
			answer = arg1 + arg2;
		}
		else if(operator == '-') {
			
			answer =  arg1 - arg2;
		}
		
		else if(operator == '/') {
			answer = arg1 / arg2;
			
		}
		
		else if(operator == '*') {
			answer =  arg1*arg2;
		}
		
		return answer;
	}
}
