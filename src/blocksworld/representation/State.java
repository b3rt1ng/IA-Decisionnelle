package blocksworld.representation;

import java.util.HashSet;

import representation.Variable;
import representation.BooleanVariable;

public class State 
{
    private HashSet<Variable> onB;
    private HashSet<Variable> fixedB;
    private HashSet<BooleanVariable> freeP;

    public State(int n, int m)
    {
        this.onB = new HashSet<>();
        this.fixedB = new HashSet<>();
        this.freeP = new HashSet<>();

        
    }    
}
