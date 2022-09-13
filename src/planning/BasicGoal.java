package planning;

import java.util.Map;

import representation.Variable;

public class BasicGoal implements Goal
{
    private Map<Variable, Object> goalState;

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

    @Override
    public String toString()
    {
        return this.goalState.toString();
    }
    
}
