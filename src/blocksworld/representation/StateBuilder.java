package blocksworld.representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import representation.BooleanVariable;
import representation.Variable;

public class StateBuilder 
{
    protected ArrayList<Integer>[] stacks;
    protected ArrayList<Variable> variables;

    public StateBuilder(int nbBlocks, int nbStacks, ArrayList<Integer>[] stacks)
    {
        this.stacks = stacks;

        World world = new World(nbBlocks, nbStacks);
        this.variables = new ArrayList<>(world.getVariables());
    }

    public Map<Variable, Object> getState()
    {
        HashMap<Variable, Object> state = new HashMap<Variable, Object>();

        for(int i = 0; i < this.stacks.length; i++)
        {
            int stack = -1-i;

            state.put(this.variables.get(this.variables.indexOf(new BooleanVariable("free"+stack))), true);

            //On traite le premier élément de la pile et on traite la pile
            if(this.stacks[i].size() > 0)
            {
                int block = this.stacks[i].get(0);
                
                state.put(this.variables.get(this.variables.indexOf(new Variable("on"+block, null))), stack);
                state.put(this.variables.get(this.variables.indexOf(new Variable("free"+stack, null))), false);
            }
            else
            {
                state.put(this.variables.get(this.variables.indexOf(new Variable("free"+stack, null))), true);
            }

            //On traite tout les blocs sur la pile i de l'ind 1 à l'ind n-1
            for(int j = 1; j < this.stacks[i].size(); j++)
            {
                int block = this.stacks[i].get(j);
                int blockAvant = this.stacks[i].get(j-1);
                state.put(this.variables.get(this.variables.indexOf(new Variable("on"+block, null))), blockAvant);
                state.put(this.variables.get(this.variables.indexOf(new Variable("fixed"+blockAvant, null))), true);
                state.put(this.variables.get(this.variables.indexOf(new Variable("fixed"+block, null))), false);
            }
        }

        return state;
    }    
}
