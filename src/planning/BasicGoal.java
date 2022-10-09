package planning;

import java.util.Map;

import representation.Variable;

/**
 * Class representing a basic goal.
 * 
 * @author Kenzo LECOINDRE
 */
public class BasicGoal implements Goal
{
    /**
     * State representing the goal state.
     */
    private Map<Variable, Object> goalState;

    /**
     * Initialise a new BasicGoal given a state.
     *
     * @param precondition A Map where each key is a Variable and each value is these value representing the goal state.
     */
    public BasicGoal(Map<Variable, Object> goalState)
    {
        this.goalState = goalState;
    }

    @Override
    public boolean isSatisfiedBy(Map<Variable, Object> state) 
    {
        for(Variable v : this.goalState.keySet())
            if(!(state.containsKey(v) && this.goalState.get(v).equals(state.get(v))))
                return false;
        
        return true;
    }

    /**
     * The toString function returns a string representation of the object.
     * This is useful for debugging purposes, and can be used to print out an
     * object or part of an object.  This function returns a String that contains
     * the string representation of the goal state.
     * 
    * @return A String representation of the BasicAction.
    * 
    */
    @Override
    public String toString()
    {
        return this.goalState.toString();
    }
    
}
