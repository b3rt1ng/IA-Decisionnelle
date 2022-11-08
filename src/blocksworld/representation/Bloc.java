package blocksworld.representation;

import representation.Variable;

import java.util.HashSet;

public class Bloc extends Variable
{
    public Bloc(int name, int nbBlocs, int nbPiles)
    {
        super(Integer.toString(name), new HashSet<>());

        for(int i = -nbPiles ; i < nbBlocs; i++)
        {
            this.domain.add(i);
        }
    }
}