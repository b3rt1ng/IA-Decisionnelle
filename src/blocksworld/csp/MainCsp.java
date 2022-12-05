package blocksworld.csp;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import blocksworld.planning.MainPlanning;
import blocksworld.representation.World;
import blocksworld.representation.WorldWithRegularConstraints;
import bwmodel.BWState;
import bwmodel.BWStateBuilder;
import bwui.BWComponent;
import bwui.BWIntegerGUI;
import representation.Variable;

import csp.*;

public class MainCsp 
{
    public static void main(String[] args) 
    {
        int nbBlocks = 10;
        int nbStacks = 10;

        World world = new World(nbBlocks, nbStacks);
        WorldWithRegularConstraints worldWithRegularConstraints = new WorldWithRegularConstraints(nbBlocks, nbStacks);

        /* -------------------------------------------------------------------------------------------------------------- */
    
        AbstractSolver solver;
        long startTime;
        long endTime;
        Map<Variable, Object> solution;
    
        //Backtracking

        solver = new BacktrackSolver(world.getVariables(), worldWithRegularConstraints.getRegularConstraints());
        startTime = System.currentTimeMillis();
        solution = solver.solve();
        endTime = System.currentTimeMillis();
        
        System.out.println("Backtrack :");
        System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
        System.out.println("solution :");
        System.out.println(solution);

        System.out.println("");
        System.out.println("");

        showSolutionGUI("Backtrack", nbBlocks, nbStacks, solution);

    
        //MACSolver

        solver = new MACSolver(world.getVariables(), worldWithRegularConstraints.getRegularConstraints());
        startTime = System.currentTimeMillis();
        solution = solver.solve();
        endTime = System.currentTimeMillis();

        System.out.println("MACSolver :");
        System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
        System.out.println("solution :");
        System.out.println(solution);

        System.out.println("");
        System.out.println("");

        showSolutionGUI("MACSolver", nbBlocks, nbStacks, solution);
    
    
        //HeuristicMACSolver
    
        VariableHeuristic[] tabVariableHeuristic = new VariableHeuristic[4];
        tabVariableHeuristic[0] = new DomainSizeVariableHeuristic(true);
        tabVariableHeuristic[1] = new DomainSizeVariableHeuristic(false);
        tabVariableHeuristic[2] = new NbConstraintsVariableHeuristic(worldWithRegularConstraints.getRegularConstraints(), true);
        tabVariableHeuristic[3] = new NbConstraintsVariableHeuristic(worldWithRegularConstraints.getRegularConstraints(), false);

        ValueHeuristic[] tabValueHeuristic = new ValueHeuristic[1];
        tabValueHeuristic[0] = new RandomValueHeuristic(new Random());

        for(int i = 0; i < tabVariableHeuristic.length; i++)
        {
            for(int j = 0; j < tabValueHeuristic.length; j++)
            {
                solver = new HeuristicMACSolver(world.getVariables(), worldWithRegularConstraints.getRegularConstraints(), tabVariableHeuristic[i], tabValueHeuristic[j]);
                startTime = System.currentTimeMillis();
                solution = solver.solve();
                endTime = System.currentTimeMillis();

                System.out.println("HeuristicMACSolver (" + tabVariableHeuristic[i].getClass().getSimpleName() + ", " + tabValueHeuristic[j].getClass().getSimpleName() + ") :");
                System.out.println("temps d'execution : " + (endTime - startTime) + "ms");
                System.out.println("solution :");
                System.out.println(solution);

                System.out.println("");
                System.out.println("");

                showSolutionGUI("HeuristicMACSolver (" + tabVariableHeuristic[i].getClass().getSimpleName() + ", " + tabValueHeuristic[j].getClass().getSimpleName() + ") :", nbBlocks, nbStacks, solution);
            }
        }

        /* -------------------------------------------------------------------------------------------------------------- */
        
        System.out.println("Appuyez sur entrée pour quitter");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    
    
    }

    public static void showSolutionGUI(String title, int nbBlocks, int nbStacks, Map<Variable, Object> instanciation)
    {
        BWIntegerGUI gui = new BWIntegerGUI(nbBlocks);
        JFrame frame = new JFrame(title);
        frame.setMinimumSize(new Dimension(500, 500));
        BWState<Integer> bwState = MainPlanning.makeBWState(instanciation, nbBlocks, nbStacks);
        BWComponent<Integer> component = gui.getComponent(bwState);
        frame.add(component);
        frame.pack();
        frame.setVisible(true);
    }
}
