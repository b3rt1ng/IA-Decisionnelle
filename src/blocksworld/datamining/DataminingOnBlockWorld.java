package blocksworld.datamining;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

import bwgeneratordemo.Demo;
import bwgenerator.BWGenerator;

import datamining.*;
import representation.BooleanVariable;
import blocksworld.representation.WorldOfBooleanVariables;

/**
 * Class performing the datamining on the blocks world.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class DataminingOnBlockWorld {

    /**
     * the number of transaction we wanna generate
     */
    protected int nbTransaction = 10000;

    /**
     * Perform the datamining on the blocks world.
     * 
     * @param nbBlocks the number of blocks in the world.
     * @param nbStacks the number of stacks in the world.
     */
    public DataminingOnBlockWorld(int nbBlocks, int nbStacks) {

        System.out.println("starting datamining on " + nbBlocks + " blocks and " + nbStacks + " stacks with " + nbTransaction + " transactions");

        Set<BooleanVariable> items = new HashSet<>();

        WorldOfBooleanVariables world = new WorldOfBooleanVariables(nbBlocks, nbStacks);
        world.getBooleanVariables().forEach(v -> items.add(v));

        BooleanDatabase db = new BooleanDatabase(items);

        for (int i = 0; i < this.nbTransaction; i++) {
            List<List<Integer>> state = Demo.getState(new Random());
            db.add(world.processState(state, nbBlocks, nbStacks));
        }

        AssociationRuleMiner miner = new BruteForceAssociationRuleMiner(db);
        float minFreq = (float) (2f/3f);
        float minConf = .95f;

        System.out.println("mining rules with minFreq = " + minFreq + " and minConf = " + minConf);

        Set<AssociationRule> rules = miner.extract(minFreq, minConf);

        System.out.println("found " + rules.size() + " rule(s): ");
        rules.forEach(r -> System.out.println("\t-> " + r + " with " + r.getConfidence()*100 + "% confidence and " + r.getFrequency() + " frequency"));

    }

    public static void main(String[] args) {
        DataminingOnBlockWorld dm = new DataminingOnBlockWorld(Demo.NB_BLOCKS, Demo.NB_STACKS);
    }
}