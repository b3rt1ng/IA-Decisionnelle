package blocksworld.planning;

import java.util.Map;

import planning.Heuristic;
import representation.Variable;

public class NbBlockOnBadStackHeuristic implements Heuristic
{
    protected Map<Variable, Object> goal;

    public NbBlockOnBadStackHeuristic(Map<Variable, Object> goal)
    {
        this.goal = goal;
    }

    @Override
    public float estimate(Map<Variable, Object> state) 
    {
        int nbBlocks = 0;
        for(Variable v : state.keySet())
            if(v.getName().startsWith("onB"))
                if(!state.get(v).equals(this.goal.get(v)))
                {
                    int nbOn = (int)state.get(v);
                    while(nbOn >= 0)
                    {
                        nbOn = (int)state.get(new Variable("on" + nbOn, null));
                    }

                    int nbOnGoal = (int)this.goal.get(v);
                    while(nbOnGoal >= 0)
                    {
                        nbOnGoal = (int)this.goal.get(new Variable("on" + nbOnGoal, null));
                    }

                    if(nbOn != nbOnGoal)
                        nbBlocks++;

                }
                    
                    

        return nbBlocks;    
    }
}
