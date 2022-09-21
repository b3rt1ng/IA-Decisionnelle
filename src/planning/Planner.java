package planning;

import java.util.List;
import java.util.Map;
import java.util.Set;

import representation.Variable;

public interface Planner 
{
    public abstract List<Action> plan();
    public abstract Map<Variable, Object> getInitialState();
    public abstract Set<Action> getActions();
    public abstract Goal getGoal(); 
    public abstract int getNbNodes();
}
