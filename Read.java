import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.InputMismatchException;

public class Read {

 private char variable;
 private int value;
 
 
 Scanner input = new Scanner(System.in);
 boolean con = true;
 
	public Read(String x)  throws InputMismatchException {
		this.variable = x.charAt(0);
		this.printLine();
		
	}
	
	public void printLine( ) throws InputMismatchException {
	  System.out.print("Enter an Integer number for variable " + this.variable + " : ");
	  System.out.println();
	try {
	 this.value = input.nextInt();
	 
	}
	catch(InputMismatchException e) {
		this.con = false;
 	  System.out.println("Espresso Only accepts Integers : " + e);
	}
	}
	
	public int getValue() throws InputMismatchException {
		return this.value;
	}
	
   public boolean getController() {
	   return con;
   }
	
}
