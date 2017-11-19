import java.io.*;
import java.util.*;
public class FileInput {
	
	
 // Variables Only
 // use it with commandline arguments
 private String inputFileName; 
 // This is the controller variable for the execution of program. When it turns false that means there is an exception and the program won't proceed further
 private boolean controller = true;
 private boolean readCheck = true;
 private int lineNumber =0;
 private char temp3;
 
 
 
 //Collections
 private ArrayList<String> line = new ArrayList<String>(); // Will store the separated tokens of file
 static ArrayList<Character> infix = new ArrayList<Character>(); // Will be used to calculate infix expression
	
	
 //objects only
 private File fileRecieved;
 private Scanner File;
 private VariableCollection variableController;
 private ExpressionCalculator expressionController;
 private Read readMe;
 
 

	
	
	public FileInput(String filename) throws IOException {
		
		//Constructor creates the array of variable object
		 variableController = new VariableCollection();
		 expressionController = new ExpressionCalculator( variableController);
	
		
		try {
		 fileRecieved = new File(filename);
	            File = new Scanner(fileRecieved);
		}
		catch(IOException e) {
			System.out.println("File Not Found");
		}
	}
	
	
	
	
   
	
	
	
	
	public void interpret() throws UndefinedVariableException, InValidOperator, InputMismatchException, Exception, InvalidKeywordException  {
	   while(File.hasNextLine()) {
		   lineNumber++;
		   // This method reads one line from the file and split it into string tokens and stores it into an arraylist
		   splitLine(File.nextLine());
		
		   
		  
		   for(int i=0; i<line.size(); i++) {
			 
			   if(line.get(i).equals("read")) {
				   
				  // Whenever it sees a read statement it creates new readMe each Time 
				 //  read object will serve the purpose of assigning the value to variable 
				   readMe = new Read(line.get(i+1));
				   
				   char tempVariable = line.get(i+1).charAt(0);
				   
				   
				  
				
			       int x =   readMe.getValue();
			      if(! readMe.getController()) {
			    	  readCheck = false;
			    	  break;
			      }
			       variableController.setVariable(tempVariable , x);
				   
				
			      // set the value and name of variable
			      
			     
			   
			    
			   }
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   else if(line.get(i).equals("print")) {
				   
				   
				   //first empty the infix
				   infix.clear();
				   //Expression
				   if(line.size()>2) {
					   
					   for(int op=1; op<line.size(); op++){
						   
						   String e = line.get(op);
                            this.temp3 = line.get(op).charAt(0);
                        
                      	 if (e.length() >1 ||temp3 == '&' || temp3=='^' || temp3 == '!'|| temp3 == '&' || temp3=='^' || temp3 == '@'|| temp3=='%' ||
								 temp3 =='#' || temp3 == '!'|| temp3 =='$' || temp3 == '_' || temp3== '~') {
							   throw  new Exception("Line : "+ lineNumber + ". " + line +"\nSyntax error" );
							   
						   }
						   infix.add(temp3);					   
					   }
					   
				try {
				int dd=  expressionController.postfixEvaluation(expressionController.infixToPostfix(infix,lineNumber));
				 System.out.println(dd);
					infix.clear();
				}
				catch(UndefinedVariableException e) {
					System.out.println("Line: " + lineNumber + " " + line + "Variable" + temp3 );
				}
			 
				   }
				   else {
					   char printVariable = line.get(1).charAt(0);
					   int value = variableController.getValue(printVariable);
					   System.out.println(value);
				   }
				   
			   }
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   // Assignments
			   else if(isOneWord(line.get(0)))  {
				 
				   try {
					   
					   // Only for Assignment
				   if((variableController.isVariable(line.get(0).charAt(0))) && (line.size() ==3))   {
					   
					   char tempVar = line.get(0).charAt(0);
					   variableController.setVariable(tempVar, Integer.parseInt(line.get(2)));
					   
				   
			   }
				   
				   // Assignment For Expressions
				   else if((variableController.isVariable(line.get(0).charAt(0))) && (line.size() >3)) {
				
					   char temp1 = line.get(0).charAt(0);//variable name
					   char temp2;// variable value
					   
					 // loop starts from index 2 as we know that the expression will always be equals to.
					 for(int k=2; k<line.size(); k++) {
						 
						 
						 String ap = line.get(k);
						  temp3 = line.get(k).charAt(0);
						 
						 if(ap.length()>1 || temp3 == '&' || temp3=='^' || temp3 == '!'|| temp3 == '&' || temp3=='^' || temp3 == '@'|| temp3=='%' ||
								 temp3 =='#' || temp3 == '!'|| temp3 =='$' || temp3 == '_' || temp3== '~') {
							  throw  new Exception("Line : "+ lineNumber + ". " + line +"\nSyntax error" );
							   
						   }
						 infix.add(temp3);
					    
						 
					 }
					 
					
					
						
					try {
						
					
					
					int x = expressionController.postfixEvaluation(expressionController.infixToPostfix(infix, lineNumber));
					 variableController.setVariable(line.get(0).charAt(0), x);
					
				
					}
					
			
					catch(InValidOperator e ) {
						System.out.println(e );
						controller = false;
					}
				
					
				
					
				   }
				   
				   
				   
				   
				 
				   
				   
				   
				   
				   
				  
				   
				   }
				   catch(UndefinedVariableException e) {
					   System.out.println("Line: " + lineNumber + " "+line + "\n"  + "Variable is not defined");
				   }
				 
				   //This break is used to execute only the first statement of for loop in which infix is a variable and then get out of it
				  break;
			   }
			   
			  
			   else {
				   if(i==0) {
				  
				  throw new InvalidKeywordException("Line: " + lineNumber + " " + line + "  " + line.get(0) + " is not a valid Keyword" );
				   }
			   } 
			  
		   }
		   
		   if(!controller || !readCheck) {
			   break;
		   }
		   
		  
		  // After one line has been interpret just empty the arraylist
	
		  line.clear();
		  
	   }
	   
	   if(!controller || !readCheck) {
		   System.out.println("Exit");
	   }
	}
	
	public void splitLine(String lineArg) {
	
			String lineTemp = lineArg;
			for(String token: lineTemp.split(" ")) {
				line.add(token);
			
		}
	}
	
	
	
	
	public boolean isOneWord(String x) {
		if(x.length() == 1) return true;
		else return false;
	}
	
	

	
	
}
