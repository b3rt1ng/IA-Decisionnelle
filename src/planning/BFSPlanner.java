package planning;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import representation.Variable;

public class BFSPlanner implements Planner
{
    private Map<Variable, Object> initialState;
    private Set<Action> actions;
    private Goal goal;
    private int nbNodes;

    public BFSPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal)
    {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
        this.nbNodes = 0;
    }

    private List<Action> getBfsPlan(Map<Map<Variable, Object>, Map<Variable, Object>> father, Map<Map<Variable, Object>, Action> plan, Map<Variable, Object> goal)
    {
        LinkedList<Action> res = new LinkedList<>();
        while(goal != this.initialState)
        {
            res.add(plan.get(goal));
            goal = father.get(goal);
        }
        Collections.reverse(res);
        return res;
    }

    private List<Action> bfs(Map<Map<Variable, Object>, Map<Variable, Object>> father, Map<Map<Variable, Object>, Action> plan)
    {
        HashSet<Map<Variable, Object>> closed = new HashSet<>();
        closed.add(this.initialState);

        LinkedList<Map<Variable, Object>> open = new LinkedList<>();
        open.add(this.initialState);

        father.put(this.initialState, null);

        if(this.goal.isSatisfiedBy(this.initialState))
            return new LinkedList<Action>();

        while(open.size() != 0)
        {
            Map<Variable, Object> instantiation = open.removeFirst();
            closed.add(instantiation);

            for(Action action : this.actions)
            {
                if(action.isApplicable(instantiation))
                {
                    Map<Variable, Object> next = action.successor(instantiation);
                    if(!closed.contains(next) && !open.contains(next))
                    {
                        this.nbNodes++;
                        father.put(next, instantiation);
                        plan.put(next, action);
                        if(this.goal.isSatisfiedBy(next))
                            return getBfsPlan(father, plan, next);
                        else
                            open.add(next);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Action> plan()
    {
        this.nbNodes = 0;
        return bfs(new HashMap<>(), new HashMap<>());
    }

    @Override
    public Map<Variable, Object> getInitialState() { return this.initialState; }

    @Override
    public Set<Action> getActions() { return this.actions; }

    @Override
    public Goal getGoal() { return this.goal; }

    @Override
    public int getNbNodes() { return this.nbNodes; }

    @Override
    public String toString()
    {
        String res = "initialState : " + this.initialState + "\n";
        res += "Actions : " + this.actions + "\n";
        res += "Goal : " + this.goal + "\n";
        return res;
    }
}