package planning;

import representation.Variable;
import java.util.Map;

/**
 * Class implementing an heuristic.
 * 
 * @author Antoine COLLENOT
 */

public interface Heuristic {

    /**
     * Estimate the cost for a given state to reach the goal.
     * 
     * @param state The state we're in.
     * @return An estimation of the cost.
     */
    public abstract float estimate(Map<Variable, Object> state); 
}
