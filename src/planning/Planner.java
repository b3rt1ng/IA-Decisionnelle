package planning;

import java.util.List;
import java.util.Map;
import java.util.Set;

import representation.Variable;

/**
 * Interface which contains all methods concerning Planning.
 * 
 * @author Kenzo LECOINDRE
 */
public interface Planner 
{
    /**
     * This method launch the plannification.
     * 
     * @return A list of actions to go the the final State sorted in order.
     */
    public abstract List<Action> plan();

    /**
     * This method return the initial state.
     * 
     * @return The initial state.
     */
    public abstract Map<Variable, Object> getInitialState();

    /**
     * This method return a the list of actions allowed to resolve the problem.
     * 
     * @return A list of actions.
     */
    public abstract Set<Action> getActions();

    /**
     * This method return the goal.
     * 
     * @return A Goal.
     */
    public abstract Goal getGoal(); 

    /**
     * This method return the number of nodes visited by the last plan.
     * 
     * @return The number of nodes visited.
     */
    public abstract int getNbNodes();
}
