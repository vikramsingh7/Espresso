import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class ExpressionCalculator {

	
	//Objects Used
	Operators operateController = new Operators();
	VariableCollection variableController;
	
	//Used for calculating postfix expression
	 Stack<Integer> postfixStack = new Stack<Integer>();

	 
	 //Arraylist
	 ArrayList<Character> arrayPostfix = new ArrayList<Character>();

	 
public ExpressionCalculator(VariableCollection arg1) {
	
	this.variableController = arg1;
}
	  
	
	public  Deque<Character> infixToPostfix(ArrayList<Character> infix , int lineNumber) throws InValidOperator, UndefinedVariableException, Exception
	{

		 Stack<Character> op = new Stack<Character>();
		   Deque<Character> postfix = new ArrayDeque<Character>();
		   
		   for(int i=0; i<infix.size(); i++) {
			   char c=infix.get(i);
			   
			   
			
			
			  
			   
			   
			   
			    if(c == '(') {
			    	if(infix.get(i+1) == '(') {
			    		throw new Exception("Unbalanced Brackets " + "Line: "+ lineNumber + "\n" + "Syntax Error");
			    	}
			    	else {
			   op.push(c);
			    	}
		   }
		   
		   else if(c == ')') {
			   
			   if ( infix.get(i-1) == ')') {
		    		throw new Exception("Unbalanced Brackets " + "Line: "+ lineNumber + "\n" + "Syntax Error");
		    	}
			   else {
			   char justPopped = op.pop();
			   postfix.addLast(justPopped);
			   while(!op.isEmpty() && op.peek() != '(') {
				   postfix.addLast(op.pop());
			   }
			   op.pop();
			   }
		   }
		   
		   else if(c == '*' || c =='/' || c=='+' || c=='-') {
			  
			   // if the stack is empty just push it
			  
			   if(op.isEmpty() || op.peek()=='(') {
				
				   op.push(c);
				  
				   
				   }
			   else {
				
				   char justPeeked = op.peek();
			
				   if(pre(justPeeked)>= pre(c)) {
					   
					   char justPopped = op.pop();
					   
					   postfix.addLast(justPopped);
					  
					   
					   //peek into stack and check if the top still has higher
					   if(!op.isEmpty()) {
					   while( !op.isEmpty() && pre(op.peek()) >= pre(c) ) {
					      postfix.addLast(op.pop());
					   }   
					   
					   op.add(c);
				   } 
					   else {
						   op.add(c);
						 
					   }
				   }
				   else {
					 op.add(c);
					
				   }
			   }
			   
		   }
		   
		
		   
		   else {
			   
			   postfix.addLast(c);
		   }
		   
		   }
		   
		   while(!op.isEmpty()) {
			   postfix.addLast(op.pop());
		   }
		 return postfix;
		   
	}
	
	public  int postfixEvaluation(Deque<Character> postfix) throws UndefinedVariableException  {
	    
		  //queue is converted into arraylist 
		   convertQueueToArray(postfix);
		   int finalAnswer = 0;
		


		  for(int i=0; i<arrayPostfix.size(); i++) {
			
			char c = arrayPostfix.get(i);
		
			if(!isOperatorButVariable(c)) {
		
				if(variableController.isVariableOrNumber(c)) {
				int value = variableController.getValue(c);
				postfixStack.push(value);
				}
				else {
				
					int convertedInt = Character.getNumericValue(c);
					postfixStack.push(convertedInt);
				}
				
			}
			
		
			else {
			      
		              int temp1 = postfixStack.pop();
		              int temp2 = postfixStack.pop();
		             
		          
		              
		              int ans = operateController.operateHere(temp2, temp1, c);
		            
		              postfixStack.push(ans);
		             
			}
			 
		  }
  if(postfixStack.size() ==1) {
	   finalAnswer = postfixStack.pop();
  }
  arrayPostfix.clear(); //so that next time it can be used by other body
	  return finalAnswer;

	}
	
	 public  int pre(char x) {
		   
		   int pre =0;
		   if((x=='*') || x=='/') {
			   pre =2;
		   }
		   else if((x=='+') || x=='-') {
			   pre =1;
		   }
		   return pre;
		   
	   }
	
	
	public void convertQueueToArray(Deque<Character> postfix) {
		
		while(!postfix.isEmpty()) {
		arrayPostfix.add(postfix.getFirst());
		postfix.removeFirst();
		
	}
		
	
	}
	
	
	public boolean isOperatorButVariable(char x) {
		if(x=='*' || x=='/' || x =='+' || x == '-' || x=='(' || x==')') 
		{return true;}
		else return false;
	}
	
	
	public boolean isOperator(char x)throws InValidOperator {
		if(x=='*' || x=='/' || x =='+' || x == '-' || x=='(' || x==')') 
			{return true;}
		else { 
			throw new InValidOperator("This is not a valid operator" );
		}
		
	}

	
}
