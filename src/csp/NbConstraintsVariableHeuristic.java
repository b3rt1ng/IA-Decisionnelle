package csp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

public class NbConstraintsVariableHeuristic implements VariableHeuristic 
{
    private Set<Constraint> constraints;
    private boolean moreConstraintsFrequency;

    public NbConstraintsVariableHeuristic(Set<Constraint> constraints, boolean moreConstraintsFrequency)
    {
        this.constraints = constraints;
        this.moreConstraintsFrequency = moreConstraintsFrequency;
    }

    @Override
    public Variable best(Set<Variable> vars, Map<Variable, Set<Object>> domains) 
    {
        Variable best = null;
        int bestNbConstraints = 0;
        
        for(Variable v : vars)
        {
            int nbVariable = 0;

            for(Constraint c : constraints)
            {
                if(c.getScope().contains(v))
                {
                    nbVariable++;
                }
            }

            if(best == null || (moreConstraintsFrequency && nbVariable > bestNbConstraints) || (!moreConstraintsFrequency && nbVariable < bestNbConstraints))
            {
                best = v;
                bestNbConstraints = nbVariable;
            }
        }
        
        return best;
    }

    @Override
    public String toString()
    {
        String res = "moreConstraintsFrequency : " + this.moreConstraintsFrequency + "\n";

        for(Constraint c : this.constraints)
        {
            res += c.toString() + "\n";
        }

        return res;
    }
    
}
