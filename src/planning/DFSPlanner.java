package planning;

import java.util.List;
import java.util.Map;
import java.util.Set;

import representation.Variable;

public class DFSPlanner implements Planner
{
    private Map<Variable, Object> initialState;
    private Set<Action> actions;
    private Goal goal;

    public DFSPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal)
    {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
    }

    /*
    public static dfs()
    {

    }
    */

    @Override
    public List<Action> plan() 
    {
        return null;
    }

    @Override
    public Map<Variable, Object> getInitialState() { return this.initialState; }

    @Override
    public Set<Action> getActions() { return this.actions; }

    @Override
    public Goal getGoal() { return this.goal; }

}