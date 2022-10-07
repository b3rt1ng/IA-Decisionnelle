package representation;

import java.util.HashSet;

/**
 * Class representing a variable.
 * 
 * @author Kenzo LECOINDRE
 */
public class BooleanVariable extends Variable
{
    /**
     * Initialise a new BooleanVariable given a name.
     *
     * @param name A String object representing a name.
     * 
     */
    public BooleanVariable(String name)
    {
        super(name, new HashSet<Object>());
        
        this.domain.add(true);
        this.domain.add(false);
    }
}