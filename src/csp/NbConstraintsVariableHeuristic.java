package csp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

public class NbConstraintsVariableHeuristic implements VariableHeuristic 
{
    /**
     * A set of constraints
     */
    private Set<Constraint> constraints;

    /**
     * A boolean that tells us if we prefer the variables appearing on the most domains or the least.
     */
    private boolean moreConstraintsFrequency;

    /**
     * Constructor for the NbConstraintsVariableHeuristic class.
     * 
     * @param constraints A set of constraints.
     * @param moreConstraintsFrequency A boolean that tells us if we prefer the variables appearing on the most domains or the least.
     */
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
