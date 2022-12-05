package blocksworld.planning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import planning.Action;
import planning.BasicAction;
import representation.BooleanVariable;
import representation.Variable;

public class BlocksworldActionFactory 
{
    protected int nbBlocks;
    protected int nbStacks;

    public BlocksworldActionFactory(int nbBlocks, int nbStacks)
    {
        this.nbBlocks = nbBlocks;
        this.nbStacks = nbStacks;
    }

    public Set<Action> getActions()
    {
        HashSet<Action> setActions = new HashSet<Action>();

        for(int i = 0; i < this.nbBlocks; i++)
        {
            for(int j = 0; j < this.nbBlocks; j++)
            {
                //déplacer un bloc b du dessus d’un bloc b′ vers le dessus d’un bloc b′′
                for(int k=0 ; k < this.nbBlocks ; k++)
                {
                    if(i != j && i != k && j != k)
                    {
                        Map<Variable, Object> precondition = new HashMap<Variable, Object>();

                        precondition.put(new Variable("on"+i, null), j);
                        precondition.put(new BooleanVariable("fixed"+i), false);
                        precondition.put(new BooleanVariable("fixed"+k), false);

                        Map<Variable, Object> effect = new HashMap<Variable, Object>();
                        effect.put(new Variable("on"+i, null), k);
                        effect.put(new BooleanVariable("fixed"+j), false);
                        effect.put(new BooleanVariable("fixed"+k), true);

                        setActions.add(new BasicAction(precondition, effect, 1));
                    }
                }

                //déplacer un bloc b du dessus d’un bloc b′ vers le dessus d’une pile p
                for(int k=-1 ; k >= -this.nbStacks ; k--)
                {
                    if(i != j && i != k && j != k)
                    {
                        Map<Variable, Object> precondition = new HashMap<Variable, Object>();

                        precondition.put(new Variable("on"+i, null), j);
                        precondition.put(new BooleanVariable("fixed"+i), false);
                        precondition.put(new BooleanVariable("free"+k), true);

                        Map<Variable, Object> effect = new HashMap<Variable, Object>();
                        effect.put(new Variable("on"+i, null), k);
                        effect.put(new BooleanVariable("fixed"+j), false);
                        effect.put(new BooleanVariable("free"+k), false);

                        setActions.add(new BasicAction(precondition, effect, 1));
                    }
                }  
            }

            for(int j = -1; j >= -this.nbStacks; j--)
            {
                //déplacer un bloc b du dessus d’une pile p vers le dessus d’un bloc b′
                for(int k=0 ; k<this.nbBlocks ; k++)
                {
                    if(i != j && i != k && j != k)
                    {
                        Map<Variable, Object> precondition = new HashMap<Variable, Object>();

                        precondition.put(new Variable("on"+i, null), j);
                        precondition.put(new BooleanVariable("fixed"+i), false);
                        precondition.put(new BooleanVariable("fixed"+k), false);

                        Map<Variable, Object> effect = new HashMap<Variable, Object>();
                        effect.put(new Variable("on"+i, null), k);
                        effect.put(new BooleanVariable("free"+j), true);
                        effect.put(new BooleanVariable("fixed"+k), true);

                        setActions.add(new BasicAction(precondition, effect, 1));
                    }
                }

                //déplacer un bloc b du dessus d’une pile p vers le dessus d’une pile p′
                for(int k = -1; k >= -this.nbStacks; k--)
                {
                    if(i != j && i != k && j != k)
                    {
                        Map<Variable, Object> precondition = new HashMap<Variable, Object>();

                        precondition.put(new Variable("on"+i, null), j);
                        precondition.put(new BooleanVariable("fixed"+i), false);
                        precondition.put(new BooleanVariable("free"+k), true);

                        Map<Variable, Object> effect = new HashMap<Variable, Object>();
                        effect.put(new Variable("on"+i, null), k);
                        effect.put(new BooleanVariable("free"+j), true);
                        effect.put(new BooleanVariable("free"+k), false);

                        setActions.add(new BasicAction(precondition, effect, 1));
                    }
                }
            }
        }

        return setActions;

    }
}
