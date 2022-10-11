package csp;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

/**
 * Class representing an arc consistency.
 * 
 * @author Kenzo LECOINDRE
 */
public class ArcConsistency 
{
    private Set<Constraint> ensConstraints;

    public ArcConsistency(Set<Constraint> ensConstraints)
    {
        for(Constraint constraint : ensConstraints)
        {
            Set<Variable> scope = constraint.getScope();
            if(scope.size() < 1 || scope.size() > 2)
            {
                throw new IllegalArgumentException(" L'une des contraintes n'est ni unaire ni binaire. ");
            }
        }
        this.ensConstraints = ensConstraints;
    }

    public boolean enforceNodeConsistency(Map<Variable, Set<Object>> ensDomaines)
    {
        boolean finalBool = true;
        Map<Variable, Set<Object>> ensDomainesFinal = new HashMap<>();

        for(Variable var : ensDomaines.keySet())
        {
            boolean bool = true;
            for(Object o : ensDomaines.get(var))
            {
                Map<Variable, Object> domaine = new HashMap<>();
                domaine.put(var, o);
                
                for(Constraint c : this.ensConstraints)
                {
                    if(!c.isSatisfiedBy(domaine))
                    {
                        bool = false;
                        break;
                    }
                }

                if(!bool)
                    break;
                
            }

            finalBool = finalBool && bool;
            if(bool)
                ensDomainesFinal.put(var, ensDomaines.get(var));
        }
        ensDomaines = ensDomainesFinal;

        return finalBool;
    }

    public boolean revise(Variable v1, Set<Object> d1, Variable v2, Set<Object> d2)
    {
        boolean del = false;

        

        return del;
    }

    public boolean ac1(Map<Variable, Set<Object>> ensDomaines)
    {
        return true;
    }

    @Override
    public String toString()
    {
        String res = "";

        for(Constraint c : this.ensConstraints)
            res += c.toString() + "\n";

        return res;
    }
}
