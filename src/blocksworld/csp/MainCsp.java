package blocksworld.csp;

import java.util.Map;
import java.util.Random;

import blocksworld.representation.World;
import blocksworld.representation.WorldWithRegularConstraints;
import csp.AbstractSolver;
import csp.BacktrackSolver;
import csp.DomainSizeVariableHeuristic;
import csp.HeuristicMACSolver;
import csp.MACSolver;
import csp.NbConstraintsVariableHeuristic;
import csp.RandomValueHeuristic;
import csp.ValueHeuristic;
import csp.VariableHeuristic;
import representation.Variable;

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
            }
        }

    
    
    
    }
}
