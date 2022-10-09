package planning;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import representation.Variable;

/**
 * Class representing a planner using Breadth-first search.
 * 
 * @author Kenzo LECOINDRE
 */
public class BFSPlanner implements Planner
{
    /**
     * State representing the initial state.
     */
    private Map<Variable, Object> initialState;

    /**
     * Set of actions representing all the differents actions allowed to be used.
     */
    private Set<Action> actions;

    /**
     * Goal representing the goal to reach.
     */
    private Goal goal;

    /**
     * A counter to count the number of nodes visited by the last planning.
     */
    private int nbNodes;

    /**
     * Initialise a new BFSPlanner given an initial state, a set of actions allowed and a goal.
     *
     * @param initialState a Map where each key is a Variable and each value is these value representing an initial state.
     * @param actions A Set of actions representing the list of actions allowed to be used.
     * @param goal A goal representing the goal to to reach.
     * 
     */
    public BFSPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal)
    {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
        this.nbNodes = 0;
    }

    /**
     * List all the actions from a state to the initial state and reverse the order of the list.
     * 
     * @param father Map representing a tree structure of state where the key is a state and the value is his father.
     * @param plan Map where each key is a state and each value is the action that generate these state.
     * @param goal A state.
     * 
     * @return A list of actions to go to the "goal" state from the initial state.
     */
    public List<Action> getBfsPlan(Map<Map<Variable, Object>, Map<Variable, Object>> father, Map<Map<Variable, Object>, Action> plan, Map<Variable, Object> goal)
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

    /**
     * Launch a bfs search.
     * 
     * @param father Map representing a tree structure of state where the key is a state and the value is his father.
     * @param plan Map where each key is a state and each value is the action that generate these state.
     * 
     * @return A list of actions to go to the goal from the initial state.
     */
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

    /**
     * The toString function returns a string representation of the object.
     * This is useful for debugging purposes, and can be used to print out an
     * object or part of an object.  This function returns a String that contains
     * the string representation of all the attribute of a bfs planner.
     * 
    * @return A String representation of the BFSPlanner.
    * 
    */
    @Override
    public String toString()
    {
        String res = "initialState : " + this.initialState + "\n";
        res += "Actions : " + this.actions + "\n";
        res += "Goal : " + this.goal + "\n";
        return res;
    }
}