package planning;

import java.util.Map;

import representation.Variable;

/**
 * Interface which contains all methods concerning an Action.
 * 
 * @author Kenzo LECOINDRE
 */
public interface Action
{
    /**
     * This method notice if the action is applicable to the given state or not.
     * 
     * @param state A state corresponding to a Map where each key is a Variable and each value is these value.
     * @return true if the action is applicable to the given state, false otherwise.
     */
    public abstract boolean isApplicable(Map<Variable, Object> state);
    
    /**
     * if the action is applicable to the given state, this method return the successor of the application of the action to the given state.
     * 
     * @param state
     * @return A map representing the state successor after applying the action.
     */
    public abstract Map<Variable, Object> successor(Map<Variable, Object> state);
    
    /**
     * This method return the cost of this action.
     * 
     * @return the cost of this action.
     */
    public abstract int getCost();
}