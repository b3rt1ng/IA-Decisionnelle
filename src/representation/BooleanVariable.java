import java.util.HashSet;

public class BooleanVariable extends Variable
{
    public BooleanVariable(String name)
    {
        super(name, new HashSet<Object>());
        
        super.domaine.add(true);
        super.domaine.add(false);
    }
}