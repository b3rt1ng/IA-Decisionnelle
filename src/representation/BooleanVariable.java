package representation;

import java.util.HashSet;

public class BooleanVariable extends Variable
{
    public BooleanVariable(String name)
    {
        super(name, new HashSet<Object>());
        
        this.domain.add(true);
        this.domain.add(false);
    }
}