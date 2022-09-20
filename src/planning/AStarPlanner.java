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

    public AStarPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal, Heuristic heurist) {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
        this.heuristique = heurist;
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

    @Override
    public List<Action> plan() {
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
}
