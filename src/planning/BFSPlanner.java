package planning;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

import representation.Variable;

public class BFSPlanner implements Planner
{
    private Map<Variable, Object> initialState;
    private Set<Action> actions;
    private Goal goal;

    public BFSPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal)
    {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
    }

    /*
        BFS_plan ← QUEUE({})
        2: while goal 6 = ∅ do
        3: enqueue(BFS_plan, plan[goal])
        4: goal ← father [goal]
        5: end while
        6: return reverse(BFS_plan)
    */

    private List<Action> getBfsPlan(Map<Map<Variable, Object>, Map<Variable, Object>> father, Map<Map<Variable, Object>, Action> plan, Goal goal)
    {
        ArrayList<Action> res = new ArrayList<>();
        while(goal != null)
        {
            //res.add(plan.get(goal.))
        }
        Collections.reverse(res);
        return res;
    }

    private List<Action> bfs(Map<Map<Variable, Object>, Map<Variable, Object>> father, Map<Map<Variable, Object>, Action> plan)
    {
        HashSet<Map<Variable, Object>> closed = new HashSet<>();
        closed.add(this.initialState);

        Stack<Map<Variable, Object>> open = new Stack<>();
        open.push(this.initialState);

        father.put(this.initialState, null);

        if(this.goal.isSatisfiedBy(this.initialState))
            return new LinkedList<>();

        while(open.size() != 0)
        {
            Map<Variable, Object> instantiation = open.pop();
            closed.add(instantiation);

            for(Action action : this.actions)
            {
                
            }
        }

        return null;
    }

    @Override
    public List<Action> plan()
    {
        return bfs(null, null);
    }

    @Override
    public Map<Variable, Object> getInitialState() { return this.initialState; }

    @Override
    public Set<Action> getActions() { return this.actions; }

    @Override
    public Goal getGoal() { return this.goal; }

}