package blocksworld.planning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import blocksworld.representation.StateBuilder;
import bwmodel.BWState;
import bwmodel.BWStateBuilder;
import bwui.BWIntegerGUI;
import planning.AStarPlanner;
import planning.Action;
import planning.BFSPlanner;
import planning.BasicGoal;
import planning.DFSPlanner;
import planning.DijkstraPlanner;
import planning.Planner;
import representation.Variable;

public class MainPlanning 
{
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

    }    
}
