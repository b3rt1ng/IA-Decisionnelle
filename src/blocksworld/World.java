package blocksworld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import representation.Variable;
import representation.BooleanVariable;


/**
 * Class representing a state of the blocks world.
 * 
 * @author Antoine Collenot
 */
public class World {
    /**
     * the onB variables mean that a block B is either on another block if the variable is a block 
     * or on a stack if the variable is a stack
     */
    protected Map<Integer, Variable> onB;

    /**
     * The fixedB variables mean that a block B is unmovable by taking a boolean value.
     */
    protected Map<Integer, Variable> fixedB;

    /**
     * The clearB variables mean that a stack S is clear / empty by taking a boolean value.
     */
    protected Map<Integer, Variable> freeP;

    /**
     * both the number of blocks and the number of stacks in our blocks world.
     */
    protected int nbBlocks, nbStacks;

    /**
     * Initialise a new World given the number of blocks and the number of stacks.
     * 
     * @param nbBlocks the number of blocks in the world.
     * @param nbStacks the number of stacks in the world.
     */
    public World(int nbBlocs, int nbStacks) {

        this.onB = new HashMap<>();
        this.fixedB = new HashMap<>();
        this.freeP = new HashMap<>();
        
        this.nbBlocks = nbBlocs;
        this.nbStacks = nbStacks;

        // Initialisation of the domain of the variables from -nbStacks to the number of blocks {-nbStacks, ..., nbBlocks-1}
        Set<Integer> ensDom = new HashSet<>();
        for (int i = -nbStacks; i < nbBlocs; i++)
            ensDom.add(i);

        for (int i = 0; i < nbBlocs; i++) {
            Set<Object> actualDom = new HashSet<>(ensDom);
            actualDom.remove(i);
            this.onB.put(i, new Variable("on_"+i, actualDom));
            this.fixedB.put(i, new BooleanVariable("fixed_"+i));
        }

        for (int i = 1; i <= nbStacks; i++)
            this.freeP.put(i, new BooleanVariable("free_"+i));
    }
    
    public Set<Variable> getVariables() {
        Set<Variable> variables = new HashSet<>(this.onB.values());
        variables.addAll(this.fixedB.values());
        variables.addAll(this.freeP.values());
        return variables;
    }

    public Map<Integer, Variable> getOnB() {
        return this.onB;
    }

    public Map<Integer, Variable> getFixedB() {
        return this.fixedB;
    }

    public Map<Integer, Variable> getFreeP() {
        return this.freeP;
    }

    public static void main(String[] args) {
        System.out.println("generating a world with 3 blocks and 3 stacks...");
        World s = new World(3, 3);
        System.out.println(s.getVariables());
    }
}
