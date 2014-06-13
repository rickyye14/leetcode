import java.util.HashMap;
import java.util.HashSet;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map 
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put((UndirectedGraphNode) null, (UndirectedGraphNode) null);
        buildMap(node, map);
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        set.add((UndirectedGraphNode) null);
        buildGraph(node, map, set);
        return map.get(node);
    }

    private void buildMap(UndirectedGraphNode node, 
            HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return;
        }
        map.put(node, new UndirectedGraphNode(node.label));
        for (UndirectedGraphNode next : node.neighbors) {
            buildMap(next, map);
        }
    }

    private void buildGraph(UndirectedGraphNode node, 
            HashMap<UndirectedGraphNode, UndirectedGraphNode> map, 
            HashSet<UndirectedGraphNode> set) {
        if (set.contains(node)) {
            return;
        }
        set.add(node);
        for (UndirectedGraphNode next : node.neighbors) {
            map.get(node).neighbors.add(map.get(next));
        }
        for (UndirectedGraphNode next : node.neighbors) {
            buildGraph(next, map, set);
        }
    }
}
