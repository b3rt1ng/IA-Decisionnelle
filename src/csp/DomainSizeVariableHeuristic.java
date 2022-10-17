package csp;

import java.util.Map;
import java.util.Set;

import representation.Variable;

public class DomainSizeVariableHeuristic implements VariableHeuristic
{
    private boolean moreDomainSize;

    public DomainSizeVariableHeuristic(boolean moreDomainSize)
    {
        this.moreDomainSize = moreDomainSize;
    }

    @Override
    public Variable best(Set<Variable> vars, Map<Variable, Set<Object>> domains) 
    {
        Variable best = null;
        int bestDomainSize = 0;
        
        for(Variable v : vars)
        {
            if(best == null || (moreDomainSize && domains.get(v).size() > bestDomainSize) || (!moreDomainSize && domains.get(v).size() < bestDomainSize))
            {
                best = v;
                bestDomainSize = domains.get(v).size();
            }
        }
        
        return best;
    }
    
}
