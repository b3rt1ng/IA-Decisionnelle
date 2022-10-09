package planning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import representation.Variable;

/**
 * Class representing a planner using Depth-first search.
 * 
 * @author Kenzo LECOINDRE
 */
public class DFSPlanner implements Planner
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
     * Initialise a new DFSPlanner given an initial state, a set of actions allowed and a goal.
     *
     * @param initialState A Map where each key is a Variable and each value is these value representing an initial state.
     * @param actions A Set of actions representing the list of actions allowed to be used.
     * @param goal A goal representing the goal to to reach.
     * 
     */
    public DFSPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal)
    {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
        this.nbNodes = 0;
    }

    /**
     * Launch a dfs search
     * 
     * @param state A Map where each key is a Variable and each value is the value, representing a state.
     * @param result A list of actions representing the actions to do to go to the given state.
     * @param alreadyExplored A set of states already explored by the function.
     * 
     * @return A list of actions representing the actions to do to go to the goal from the initial state given.
     */
    private List<Action> dfs(Map<Variable, Object> state, List<Action> result, Set<Map<Variable, Object>> alreadyExplored)
    {
        if(this.goal.isSatisfiedBy(state))
            return result;

        for(Action action : this.actions)
        {
            if(action.isApplicable(state) && !alreadyExplored.contains(state))
            {
                this.nbNodes++;
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
        this.nbNodes = 0;
        return dfs(this.initialState, new ArrayList<>(), new HashSet<Map<Variable, Object>>());
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
     * the string representation of all the attribute of a dfs planner.
     * 
    * @return A String representation of the DFSPlanner.
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