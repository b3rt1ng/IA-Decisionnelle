package blocksworld.representation;

import java.util.HashSet;
import java.util.Set;

import representation.Implication;
import representation.Variable;
import representation.Constraint;

public class WorldWithRegularConstraints extends WorldWithConstraint {

    protected Set<Constraint> regularConstraints;

    /**
     * Initialise a new World given the number of blocks and the number of stacks.
     * 
     * @param nbBlocks the number of blocks in the world.
     * @param nbStacks the number of stacks in the world.
     */
    public WorldWithRegularConstraints(int nbBlocks, int nbStacks) {
        super(nbBlocks, nbStacks);

        this.regularConstraints = new HashSet<>();

        Set<Integer> ensDom = new HashSet<>();
        for (Integer val : this.freeP.keySet()) {
            ensDom.add(val);
        }

        for(Integer i : this.onB.keySet()) {
            Variable v = this.onB.get(i);
            for (Object o: v.getDomain()){
                Integer ni = (Integer) o;

                Integer mustBe = ni + (ni - i);
                if (ni >= 0) {
                    Variable vj = this.onB.get(ni);
                    Set<Object> dom = new HashSet<>(ensDom);
                    if (mustBe >= 0 && mustBe < this.nbBlocks) {
                        dom.add(mustBe);
                    }
                    Set<Object> firstDom = Set.of(ni);
                    this.regularConstraints.add(new Implication(v, firstDom, vj, dom));
                }
            }
        }
    }

    public Set<Constraint> getRegularConstraints() {
        return this.regularConstraints;
    }
}
