import java.io.IOException;
import java.util.*;

public class ESPInterpreter {
	
	// Array holds all the possible variable that can be used
	//It initial creates and stored object with names a-z in it. With the call of constructor
	
	
	public ESPInterpreter() { 
		
		
	
		// Here I created an array that will store value according to ascii table from a - Z that includes all lowercase and uppercase characters
	
	
	}
	
	/*
	 * This is just a dummy method to show you how to use class 
	 * Variable, set a value for a variable, and handle the exception
	 * if tried to use an unknown variable
	 */
	


	
	public static void main( String [] args )throws IOException, UndefinedVariableException, NullPointerException, InValidOperator, Exception, InvalidKeywordException,  InputMismatchException {
		
		ESPInterpreter sample = new ESPInterpreter();
		
		String filename = args[0];
		
		 FileInput sam = new FileInput(filename);
			
		
		try {
	     sam.interpret();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
		
	}

}
