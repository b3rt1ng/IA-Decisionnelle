package planning;

import representation.Variable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Collections;

public class AStarPlanner implements Planner {

    private Map<Variable, Object> initialState;
    private Set<Action> actions;
    private Goal goal;
    private Heuristic heuristique;
    private int nbNodes;

    public AStarPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal, Heuristic heurist) {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
        this.heuristique = heurist;
        this.nbNodes = 0;
    }

    public Map<Variable, Object> argmin(Map<Map<Variable, Object>, Float> map, Set<Map<Variable, Object>> okKey) {
        Map<Variable, Object> res = null;
        Float min = null;
        for(Map<Variable, Object> key: okKey) {
            if(res == null) {
                res = key;
                min = map.get(key);
            }
            else {
                if(min.compareTo(map.get(key)) > 0) {
                    res = key;
                    min = map.get(key);
                }
            }
        }
        return res;
    }


    /*
    ** Placer le(s) this.nbNodes++;
    */
    @Override
    public List<Action> plan() {
        this.nbNodes = 0;
        Map<Map<Variable, Object>, Action> plan = new HashMap<>();
        Map<Map<Variable, Object>, Float> distance = new HashMap<>();
        Map<Map<Variable, Object>, Map<Variable,Object>> father = new HashMap<>();
        Map<Map<Variable, Object>, Heuristic> value = new HashMap<>();
        Set<Map<Variable, Object>> open = new HashSet<>();
        open.add(this.initialState);
        father.put(this.initialState, null);
        distance.put(this.initialState, new Float(0));
        value.put(this.initialState,this.heuristique);
        while (!(open.isEmpty())) {
            Map<Variable, Object> instantiation = argmin(distance, open);
            if (this.goal.isSatisfiedBy(instantiation))
                //getBfsPlan(father, plan, instantition)

        }
        return null;
    }

    @Override
    public Map<Variable, Object> getInitialState() {return this.initialState;}

    @Override
    public Set<Action> getActions() {return this.actions;}

    @Override
    public Goal getGoal() {return this.goal;}

    public Heuristic getHeuristic() {return this.heuristique;}

    @Override
    public int getNbNodes() { return this.nbNodes; }
}
