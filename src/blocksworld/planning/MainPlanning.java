package blocksworld.planning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import blocksworld.representation.StateBuilder;
import bwmodel.BWState;
import bwmodel.BWStateBuilder;
import bwui.BWIntegerGUI;
import planning.Action;
import representation.Variable;

public class MainPlanning 
{
    public static void main(String[] args) 
    {
        int nbBlocks = 3;
        int nbStacks = 3;

        BlocksworldActionFactory actionFactory = new BlocksworldActionFactory(nbBlocks, nbStacks);
        Set<Action> actions = actionFactory.getActions();

        ArrayList<Integer>[] stacks = new ArrayList[nbStacks];
        for(int i = 0; i < nbStacks; i++)
        {
            stacks[i] = new ArrayList<Integer>();
        }

        stacks[0].add(0);
        stacks[0].add(1);
        stacks[0].add(2);

        StateBuilder stateBuilder = new StateBuilder(nbBlocks, nbStacks, stacks);
        Map<Variable, Object> instanciation = stateBuilder.getState();

        System.out.println(instanciation);



        /*

        Map<Variable, Object> instanciation = new HashMap<Variable, Object>();

        // Building state
        int n = 5;
        BWStateBuilder<Integer> builder = BWStateBuilder.makeBuilder(n);
        for (int b = 0 ; b<n ; b++) 
        {
            /*
            Variable onB = new Variable("on2", null); // get instance of Variable for " on_b "
            int under = (int)instanciation.get(onB);
            if (under >= 0) 
            { 
                
                // if the value is a block ( as opposed to a stack )
                builder.setOn (b+1 , b);
            //}
        }

        BWState <Integer> state = builder.getState();

        // Displaying
        BWIntegerGUI gui = new BWIntegerGUI(n);
        JFrame frame = new JFrame("title");
        frame.add(gui.getComponent(state));
        frame.pack();
        frame.setVisible(true);
    


        /*
        try{
            Thread.sleep(100000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        */

        
    }    
}
