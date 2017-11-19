import java.util.*;
import java.lang.*;

public class VariableCollection {

	
	
	private Variable [] variable_name; // Stores variable object
	
	
	
	public VariableCollection() {
		
		// from A - z
		variable_name = new Variable['~'];
		for (char i = 64; i <'~'; i++) {
			variable_name[ i ] = new Variable();
		}
		
		
		
	}
	
	public void setVariable(char arg1 , int arg2) {
		variable_name[arg1].setValue(arg2);
	}
	
	public int getValue(char arg1)throws  UndefinedVariableException {
		
		return variable_name[arg1].getValue();
	}
	
	
	public void giveValue(char arg1) throws UndefinedVariableException {
		System.out.println(variable_name[arg1].getValue());
	}
	
	public boolean isVariable(char x) throws UndefinedVariableException {
		for(int i='A'; i<='|'; i++) {
			if(x == i) {
				return true;
			}
		}
	return false;
	
		
	}
	
	public boolean isVariableOrNumber(char x) {
		for(int i='A'; i<='|'; i++) {
			if(x == i) 
			return true; }
		   return false;	
	}
	
}
