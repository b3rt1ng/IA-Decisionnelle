package planning;

import representation.Variable;
import java.util.Map;

public interface Heuristic {
    public abstract float estimate(Map<Variable, Object> state); //estimation du coup d'un plan optimal jusqu'au but
}
