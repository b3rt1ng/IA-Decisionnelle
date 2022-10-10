package planning;

import representation.Variable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Collections;

/**
 * Class implementing a Dijstra algorythm.
 * 
 * @author Antoine COLLENOT
 */

public class DijkstraPlanner implements Planner {

    /**
     * A map representing the initial state of our class, containing a variable and its value, respectively as its key and value.
     */
    private Map<Variable, Object> initialState;

    /**
     * A set of all possible actions executable for each nodes.
     */
    private Set<Action> actions;

    /**
     * A goal representing the result we're aiming for.
     */
    private Goal goal;

    /**
     * Counter to increment for each node we visited during the algorithm execution.
     */
    private int nbNodes;

    /** 
     * Implementation of a Dijstra based path finding algorytmh.
     * 
     * @param initialState A map representing the initial state of our class, containing a variable and its value, respectively as its key and value.
     * @param actions A set of all possible actions executable for each nodes.
     * @param goal Set nodes we want to end with.
     */
    public DijkstraPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal) {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
        this.nbNodes = 0;
    }

    
    /** 
     * Considering a father Map, calculate the right path from the two goals.
     * 
     * @param father Map containing the fathers of one's node.
     * @param plan Map of actions to execute for each nodes.
     * @param goals Set nodes we want to end with.
     * @param distance Map containing the distance between one node to another.
     * @return A list of Action to execute from a Node to another.
     */
    private List<Action> get_djikstra_plan(Map<Map<Variable, Object>,Map<Variable, Object>> father, Map<Map<Variable, Object>, Action> plan, Set<Map<Variable, Object>> goals, Map<Map<Variable, Object>, Float> distance) {
        LinkedList<Action> dplan = new LinkedList<>();
        Map<Variable, Object> goal = argmin(distance, goals);
        while(goal != null && goal!=this.initialState) {
            dplan.add(plan.get(goal));
            goal = father.get(goal);
        }
        Collections.reverse(dplan);
        return dplan;
    }

    
    /** 
     * Find the lowest distance between a node and every non visited nodes admiting a Map of all the linkable nodes.
     * 
     * @param map Map of Nodes and their distance.
     * @param okKey Set of linkable nodes.
     * @return The lowest distance of a Node considering every linkable nodes.
     */
    private Map<Variable, Object> argmin(Map<Map<Variable, Object>, Float> map, Set<Map<Variable, Object>> okKey) {
        Map<Variable, Object> res = null;
        Float min = null;
        for(Map<Variable, Object> key: okKey) {
            if(res == null) {
                res = key;
                min = map.get(key);
            }
            else {
                if (min.compareTo(map.get(key)) > 0) {
                    res = key;
                    min = map.get(key);
                }
            }
        }
        return res;
    }

    
    /** 
     * Implementation of the Dijktsra's algorithm to find the shortest path between nodes in a graph like structure.
     * Dijkstra's algorithm will be looking for each node connected to one another and return the shortest path by
     * following a breadth-first traversal logic.
     */
    @Override
    public List<Action> plan() {
        this.nbNodes = 0;
        Map<Map<Variable, Object>, Action> plan = new HashMap<>();
        Map<Map<Variable, Object>, Float> distance = new HashMap<>();
        Map<Map<Variable, Object>, Map<Variable,Object>> father = new HashMap<>();
        Set<Map<Variable, Object>> goals = new HashSet<>();
        Set<Map<Variable, Object>> open = new HashSet<>();
        father.put(this.initialState, null);
        distance.put(this.initialState, Float.valueOf(0));
        open.add(this.initialState);
        while (!(open.isEmpty())) {
            this.nbNodes++;
            Map<Variable, Object> instantiation = argmin(distance, open);
            open.remove(instantiation);
            if (this.goal.isSatisfiedBy(instantiation))
                goals.add(instantiation);
            for (Action action : this.actions) {
                if (action.isApplicable(instantiation)) {
                    Map<Variable, Object> next = action.successor(instantiation);
                    if (!distance.containsKey(next))
                        distance.put(next, Float.POSITIVE_INFINITY);
                    if (distance.get(next) > distance.get(instantiation) + action.getCost()) {
                        distance.put(next, distance.get(instantiation) + action.getCost());
                        father.put(next, instantiation);
                        plan.put(next, action);
                        open.add(next);
                    }
                }
            }

        }
        if (goals.isEmpty()){
            return null;
        }
        return get_djikstra_plan(father, plan, goals, distance);
    }

    @Override
    public Map<Variable, Object> getInitialState() { return this.initialState; }

    @Override
    public Set<Action> getActions() { return this.actions; }

    @Override
    public Goal getGoal() { return this.goal; }

    @Override
    public int getNbNodes() { return this.nbNodes; }
}
