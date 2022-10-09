package planning;

import java.util.HashMap;
import java.util.Map;

import representation.Variable;

/**
 * Class representing a basic action.
 * 
 * @author Kenzo LECOINDRE
 */
public class BasicAction implements Action
{
    /**
     * A state representing the preconditions of the action.
     */
    private Map<Variable, Object> precondition;
    
    /**
     * A state representing the effect of the action.
     */
    private Map<Variable, Object> effect;

    /**
     * the cost of the action.
     */
    private int cost;

    /**
     * Initialise a new BasicAction given a precondition, an effect and a cost.
     *
     * @param precondition A Map where each key is a Variable and each value is these value representing the precondtion.
     * @param effect A Map where each key is a Variable and each value is these value representing the effect.
     * @param cost An int representing the cost.
     * 
     */
    public BasicAction(Map<Variable, Object> precondition, Map<Variable, Object> effect, int cost)
    {
        this.precondition = precondition;
        this.effect = effect;
        this.cost = cost;
    }

    @Override
    public boolean isApplicable(Map<Variable, Object> state) 
    {
        for(Variable v : this.precondition.keySet())
            if(!(state.containsKey(v) && this.precondition.get(v).equals(state.get(v))))
                return false;

        return true;
    }

    @Override
    public Map<Variable, Object> successor(Map<Variable, Object> state) 
    {
        if(!isApplicable(state))
            return state;

        Map<Variable, Object> successor = new HashMap<>(state);
        for(Variable v : this.effect.keySet())
            successor.put(v, this.effect.get(v));

        return successor;
    }

    @Override
    public int getCost() 
    {
        return this.cost;
    }

    /**
     * The toString function returns a string representation of the object.
     * This is useful for debugging purposes, and can be used to print out an
     * object or part of an object.  This function returns a String that contains
     * the string representation of all the attribute of a basic action.
     * 
    * @return A String representation of the BasicAction.
    * 
    */
    @Override
    public String toString()
    {
        String res = "Action :" + "\n";
        res += "\t" + "precondition : " + this.precondition + "\n";
        res+= "\t" + "effect : " + this.effect + "\n";
        res+= "\t" + "cost : " + this.cost + "\n";

        return res;
    }
}
