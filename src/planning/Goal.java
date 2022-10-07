package planning;

import java.util.Map;

import representation.Variable;


/**
 * Interface which contains all methods concerning a Goal.
 * 
 * @author Kenzo LECOINDRE
 */
public interface Goal 
{
    /**
     * This method return true if the goal is satisfied by the given state, false otherwise.
     * 
     * @param state A state corresponding to a Map where each key is a Variable and each value is these value.
     * @return true if the goal is satisfied by the given state, false otherwise.
     */
    public abstract boolean isSatisfiedBy(Map<Variable, Object> state);
}
