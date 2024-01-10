import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new
 * ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return cloneGraphDFSRe(node, map);
    }

    private UndirectedGraphNode cloneGraphDFSRe(UndirectedGraphNode node,
            HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraphDFSRe(neighbor, map));
        }

        return newNode;
    }

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        if (node == null) {
            return null;
        }

        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();

            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    queue.offer(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public static void main(String[] args) {
        // Example usage:
        UndirectedGraphNode node = new UndirectedGraphNode(1);
        node.neighbors.add(new UndirectedGraphNode(2));
        node.neighbors.add(new UndirectedGraphNode(3));

        CloneGraph solution = new CloneGraph();
        UndirectedGraphNode clonedGraph = solution.cloneGraphDFS(node);

        // Perform any necessary operations on the clonedGraph.
    }
}
