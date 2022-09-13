package planning;

import java.util.ArrayList;
import java.util.HashSet;
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

    private List<Action> dfs(Map<Variable, Object> state, List<Action> result, Set<Map<Variable, Object>> alreadyExplored)
    {
        if(this.goal.isSatisfiedBy(state))
            return result;

        for(Action action : this.actions)
        {
            if(action.isApplicable(state) && !alreadyExplored.contains(state))
            {
                Map<Variable, Object> newState = action.successor(state);
                alreadyExplored.add(state);
                result.add(action);
                return dfs(newState, result, alreadyExplored);
            }
        }

        return null;
    }

    @Override
    public List<Action> plan()
    {
        return dfs(this.initialState, new ArrayList<>(), new HashSet<Map<Variable, Object>>());
    }

    @Override
    public Map<Variable, Object> getInitialState() { return this.initialState; }

    @Override
    public Set<Action> getActions() { return this.actions; }

    @Override
    public Goal getGoal() { return this.goal; }

}