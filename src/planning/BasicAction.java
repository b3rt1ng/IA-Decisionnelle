package planning;

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
    public boolean isApplicable(Map<Variable, Object> state) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Map<Variable, Object> successor(Map<Variable, Object> state) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCost() {
        // TODO Auto-generated method stub
        return 0;
    }
}
