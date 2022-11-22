package csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import representation.Variable;

/**
 * A class that implements the "ValueHeuristic" interface representing a Random Value Heuristic.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class RandomValueHeuristic implements ValueHeuristic
{
    /**
     * A random generator.
     */
    private Random random;

    /**
     * Constructor for the RandomValueHeuristic class.
     * @param random A random generator.
     */
    public RandomValueHeuristic(Random random)
    {
        this.random = random;
    }

    @Override
    public List<Object> ordering(Variable var, Set<Object> domain) 
    {
        List<Object> domainCopy = new ArrayList<>(Arrays.asList(domain.toArray()));
        LinkedList<Object> list = new LinkedList<>();

        for(int i=domain.size() ; i>0 ; i--)
        {
            int index = random.nextInt(i);
            list.add(domainCopy.get(index));
            domainCopy.remove(index);
        }
        
        return list;
    }
}
