package planning;

import java.util.HashMap;
import java.util.Map;

import representation.Variable;

public class BasicAction implements Action
{
    private Map<Variable, Object> precondition;
    private Map<Variable, Object> effect;
    private int cost;

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
            return null;

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
}
