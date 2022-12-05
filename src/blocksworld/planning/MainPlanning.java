package blocksworld.planning;

import java.util.Set;

import planning.Action;

public class MainPlanning 
{
    public static void main(String[] args) 
    {
        int nbBlocks = 3;
        int nbStacks = 3;

        BlocksworldActionFactory actionFactory = new BlocksworldActionFactory(nbBlocks, nbStacks);
        Set<Action> actions = actionFactory.getActions();

        for(Action action : actions)
        {
            System.out.println(action);
        }
    }    
}
