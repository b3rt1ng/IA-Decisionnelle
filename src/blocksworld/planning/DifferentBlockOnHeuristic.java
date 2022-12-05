package blocksworld.planning;

import java.util.Map;

import planning.Heuristic;
import representation.Variable;

public class DifferentBlockOnHeuristic implements Heuristic 
{
    protected Map<Variable, Object> goal;

    public DifferentBlockOnHeuristic(Map<Variable, Object> goal)
    {
        this.goal = goal;
    }

    @Override
    public float estimate(Map<Variable, Object> state) 
    {
        int nbBlocks = 0;
        for(Variable v : state.keySet())
            if(v.getName().startsWith("on"))
                if(!state.get(v).equals(this.goal.get(v)))
                    nbBlocks++;

        return nbBlocks;    
    }
    
}
