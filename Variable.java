import java.util.*;
public class Variable {
    private int value;
    private boolean initialized;
    
    public Variable(){
          initialized = false;     
    }
    
    
    
 
    
    
    public void setValue(int v){
          this.value = v;
          this.initialized = true;
    }
    
    
    public int getValue() throws UndefinedVariableException{
          if (!initialized)
                throw new UndefinedVariableException();
          else
                return this.value;
    }
}
