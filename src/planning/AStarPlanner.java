package planning;

import representation.Variable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Class implementing an A* algorythm.
 * 
 * @author Antoine COLLENOT
 */

public class AStarPlanner implements Planner {

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
     * An heuristic meant to prioritize the nodes our method will check first.
     */
    private Heuristic heuristic;

    /**
     * Counter to increment for each node we visited during the algorithm execution.
     */
    private int nbNodes;

    /** 
     * Implementation of an A* based path finding algorytmh.
     * 
     * @param initialState A map representing the initial state of our class, containing a variable and its value, respectively as its key and value.
     * @param actions A set of all possible actions executable for each nodes.
     * @param goal Set nodes we want to end with.
     * @param heuristic An heuristic like class.
     */
    public AStarPlanner(Map<Variable, Object> initialState, Set<Action> actions, Goal goal, Heuristic heuristic) {
        this.initialState = initialState;
        this.actions = actions;
        this.goal = goal;
        this.heuristic = heuristic;
        this.nbNodes = 0;
    }

    
    /** 
     * Find the lowest distance between a node and every non visited nodes admiting a Map of all the linkable nodes.
     * 
     * @param map Map of Nodes and their distance.
     * @param okKey Set of linkable nodes.
     * @return The lowest distance of a Node considering every linkable nodes.
     */
    public Map<Variable, Object> argmin(Map<Map<Variable, Object>, Float> map, Set<Map<Variable, Object>> okKey) {
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
     * Implementation of the A* algorithm to find the shortest path between nodes in a graph like structure 
     * using an heuristic intuitive logic.
     * The heuristic is what differs from a simple Dijkstra algorithm. It allows us to see the remaining
     * distance from the node we are aiming for as well as the distance from each node to another (originaly on Dijkstra), 
     * therefore allowing us to decide which node we will check in priority.
     */
    @Override
    public List<Action> plan() {
        this.nbNodes = 0;
        Map<Map<Variable, Object>, Action> plan = new HashMap<>();
        Map<Map<Variable, Object>, Float> distance = new HashMap<>();
        Map<Map<Variable, Object>, Map<Variable,Object>> father = new HashMap<>();
        Map<Map<Variable, Object>, Float> value = new HashMap<>();
        Set<Map<Variable, Object>> open = new HashSet<>();
        BFSPlanner bfs = new BFSPlanner(this.initialState,this.actions,this.goal);
        open.add(this.initialState);
        father.put(this.initialState, null);
        distance.put(this.initialState, Float.valueOf(0));
        value.put(this.initialState,this.heuristic.estimate(this.initialState));

        while (!(open.isEmpty())) {
            this.nbNodes++;
            Map<Variable, Object> instantiation = argmin(distance, open);
            if (this.goal.isSatisfiedBy(instantiation)) {
                return bfs.getBfsPlan(father,plan,instantiation);
            } else {
                open.remove(instantiation);
                for (Action action : this.actions) {
                    if (action.isApplicable(instantiation)) {
                        Map<Variable, Object> next = action.successor(instantiation);
                        if (!distance.containsKey(next))
                            distance.put(next, Float.POSITIVE_INFINITY);
                        if (distance.get(next) > distance.get(instantiation) + action.getCost()) {
                            distance.put(next, distance.get(instantiation) + action.getCost());
                            value.put(next, distance.get(next) + this.heuristic.estimate(next));
                            father.put(next, instantiation);
                            plan.put(next, action);
                            open.add(next);                       
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Map<Variable, Object> getInitialState() {return this.initialState;}

    @Override
    public Set<Action> getActions() {return this.actions;}

    @Override
    public Goal getGoal() {return this.goal;}

    public Heuristic getHeuristic() {return this.heuristic;}

    @Override
    public int getNbNodes() { return this.nbNodes; }
}
