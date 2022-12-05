package blocksworld.planning;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import blocksworld.representation.StateBuilder;
import blocksworld.representation.World;
import bwmodel.BWState;
import bwmodel.BWStateBuilder;
import bwui.BWComponent;
import bwui.BWIntegerGUI;

import representation.Variable;

import planning.*;

public class MainPlanning 
{
    /**
     * Lance le calcul et la visualisation graphique des différentes méthodes de plannification implémentées.
     * @param args arguments passed by the command line
     */
    public static void main(String[] args) 
    {
        int nbBlocks = 3;
        int nbStacks = 3;

        BlocksworldActionFactory actionFactory = new BlocksworldActionFactory(nbBlocks, nbStacks);
        Set<Action> actions = actionFactory.getActions();

        /* ----------------------------------------------------------------------------------- */

        /* Etat initial */
        ArrayList<Integer>[] stacks = new ArrayList[nbStacks];
        for(int i = 0; i < nbStacks; i++)
        {
            stacks[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < nbBlocks; i++)
        {
            stacks[0].add(i);
        }

        StateBuilder stateBuilder = new StateBuilder(nbBlocks, nbStacks, stacks);
        Map<Variable, Object> instanciation = stateBuilder.getState();

        /* ----------------------------------------------------------------------------------- */

        //Etat final
        stateBuilder.stateShuffler(20);
        Map<Variable, Object> instanciationFinal = stateBuilder.getState();

        /* ----------------------------------------------------------------------------------- */


        Planner planner;
        long startTime;
        long endTime;
        List<Action> plan;

        //Planning : BFS

        planner = new BFSPlanner(instanciation, actions, new BasicGoal(instanciationFinal));

        startTime = System.currentTimeMillis();
        plan = planner.plan();
        endTime = System.currentTimeMillis();

        System.out.println("BFS :");
        System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
        System.out.println("Noeuds explorés : " + planner.getNbNodes());
        System.out.println("Plan :");
        System.out.println(plan);

        System.out.println("");
        System.out.println("");

        showPlanGUI("BFS", nbBlocks, nbStacks, instanciation, plan);



        //Planning : DFS

        planner = new DFSPlanner(instanciation, actions, new BasicGoal(instanciationFinal));

        startTime = System.currentTimeMillis();
        plan = planner.plan();
        endTime = System.currentTimeMillis();

        System.out.println("DFS :");
        System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
        System.out.println("Noeuds explorés : " + planner.getNbNodes());
        System.out.println("Plan :");
        System.out.println(plan);

        System.out.println("");
        System.out.println("");

        showPlanGUI("DFS", nbBlocks, nbStacks, instanciation, plan);



        //Planning : Dijkstra

        planner = new DijkstraPlanner(instanciation, actions, new BasicGoal(instanciationFinal));

        startTime = System.currentTimeMillis();
        plan = planner.plan();
        endTime = System.currentTimeMillis();

        System.out.println("Dijkstra :");
        System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
        System.out.println("Noeuds explorés : " + planner.getNbNodes());
        System.out.println("Plan :");
        System.out.println(plan);

        System.out.println("");
        System.out.println("");

        showPlanGUI("Dijkstra", nbBlocks, nbStacks, instanciation, plan);



        //Planning : A* (heuristique : nombre de blocs mal placés)

        planner = new AStarPlanner(instanciation, actions, new BasicGoal(instanciationFinal), new DifferentBlockOnHeuristic(instanciationFinal));

        startTime = System.currentTimeMillis();
        plan = planner.plan();
        endTime = System.currentTimeMillis();

        System.out.println("A* (heuristique : nombre de blocs mal placés) :");
        System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
        System.out.println("Noeuds explorés : " + planner.getNbNodes());
        System.out.println("Plan :");
        System.out.println(plan);

        System.out.println("");
        System.out.println("");

        showPlanGUI("A* (heuristique : nombre de blocs mal placés)", nbBlocks, nbStacks, instanciation, plan);



        //Planning : A* (heuristique : nombre de blocs sur la mauvaise pile)

        planner = new AStarPlanner(instanciation, actions, new BasicGoal(instanciationFinal), new NbBlockOnBadStackHeuristic(instanciationFinal));

        startTime = System.currentTimeMillis();
        plan = planner.plan();
        endTime = System.currentTimeMillis();

        System.out.println("A* (heuristique : nombre de blocs sur la mauvaise pile) :");
        System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
        System.out.println("Noeuds explorés : " + planner.getNbNodes());
        System.out.println("Plan :");
        System.out.println(plan);

        System.out.println("");
        System.out.println("");

        showPlanGUI("A* (heuristique : nombre de blocs sur la mauvaise pile)", nbBlocks, nbStacks, instanciation, plan);

    }    

    public static BWState<Integer> makeBWState(Map<Variable, Object> instanciation, int nbBlocs, int nbPiles)
    {
        BWStateBuilder<Integer> builder = BWStateBuilder.makeBuilder(nbBlocs);

        World world = new World(nbBlocs, nbPiles);

        for(Integer i: world.getOnB().keySet()) {
            if((Integer) instanciation.get(world.getOnB().get(i)) >= 0) {
                builder.setOn(i, (Integer) instanciation.get(world.getOnB().get(i)));
            }
        }
        return builder.getState();
    }

    public static void showPlanGUI(String title, int nbBlocks, int nbStacks, Map<Variable, Object> instanciation, List<Action> plan)
    {
        BWIntegerGUI gui = new BWIntegerGUI(nbBlocks);
        JFrame frame = new JFrame(title);
        frame.setMinimumSize(new Dimension(500, 500));
        BWState<Integer> bwState = MainPlanning.makeBWState(instanciation, nbBlocks, nbStacks);
        BWComponent<Integer> component = gui.getComponent(bwState);
        frame.add(component);
        frame.pack();
        frame.setVisible(true);

        Map<Variable, Object> state = new HashMap<>(instanciation);

        // Playing plan
        for(Action a : plan) 
        {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            state = a.successor(state);
            component.setState(MainPlanning.makeBWState(state, nbBlocks, nbStacks));
        }
    }
}
