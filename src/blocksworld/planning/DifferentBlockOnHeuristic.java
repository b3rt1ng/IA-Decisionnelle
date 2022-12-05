package blocksworld.planning;

import java.util.Map;

import planning.Heuristic;
import representation.Variable;

/**
 * Heuristique qui compte le nombre de blocs mal placés.
 */
public class DifferentBlockOnHeuristic implements Heuristic 
{
    /**
     * Etat but.
     */
    protected Map<Variable, Object> goal;

    /**
     * Constructeur.
     * 
     * @param goal etat but.
     */
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
