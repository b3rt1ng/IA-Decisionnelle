package planning;

import java.util.Map;

import representation.Variable;

public interface Action
{
    public abstract boolean isApplicable(Map<Variable, Object> state);
    public abstract Map<Variable, Object> successor(Map<Variable, Object> state);
    public abstract int getCost();
}