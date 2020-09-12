import java.util.List;
import java.util.Set;

public class GraphUtils {

  /**
   * Given a Graph, this method returns the shortest distance (in terms of number of edges) from the
   * node labeled src to the node labeled dest. The method returns -1 for any invalid inputs,
   * including: null values for the Graph, src, or dest; there is no node labeled src or dest in the
   * graph; there is no path from src to dest.
   */
  public static int minDistance(Graph graph, String src, String dest) {
    if (isInValid(graph, src, dest)) {
      return -1;
    }

    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

    return breadthFirstSearch.getMinDistance(graph.getNode(src), dest);
  }

  /**
   * Given a Graph, this method returns a Set of the values of all nodes within the specified
   * distance (in terms of number of edges) of the node labeled src, i.e. for which the minimum
   * number of edges from src to that node is less than or equal to the specified distance. The
   * value of the node itself is not in the Set, even if there is an edge from the node to itself.
   * The method returns null for any invalid inputs, including: null values for the Graph or src;
   * there is no node labeled src in the graph; distance less than 1. However, if distance is
   * greater than or equal to 1 and there are no nodes within that distance (meaning: src is the
   * only node in the graph), the method returns an empty Set.
   */
  public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
    if (isInValid(graph, src, distance)) {
      return null;
    }

    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

    return breadthFirstSearch.getNodesWithinDistance(graph, src, distance);
  }


  /**
   * Given a Graph, this method indicates whether the List of node values represents a Hamiltonian
   * Path. A Hamiltonian Path is a valid path through the graph in which every node in the graph is
   * visited exactly once, except for the start and end nodes, which are the same, so that it is a
   * cycle. If the values in the input List represent a Hamiltonian Path, the method returns true,
   * otherwise the method returns false , e.g. if the path is not a cycle, if some nodes are not
   * visited, if some nodes are visited more than once, if some values do not have corresponding
   * nodes in the graph, if the input is not a valid path (i.e., there is a sequence of nodes in the
   * List that are not connected by an edge), etc. The method also returns false if the input Graph
   * or List is null.
   */
  public static boolean isHamiltonianPath(Graph graph, List<String> values) {
    if (isInValid(graph, values)) {
      return false;
    }

    if (isCyclic(graph, values)) {
      Set<Node> nodes = graph.getAllNodes();
      for (Node node : nodes) {
        if (!values.contains(node.getElement())) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  private static boolean isInValid(Graph graph, String src, String dest) {
    return graph == null || src == null || dest == null ||
        !graph.containsNode(graph.getNode(src)) ||
        !graph.containsNode(graph.getNode(dest));
  }

  private static boolean isInValid(Graph graph, String src, int distance) {
    return graph == null || src == null || distance < 1 ||
        !graph.containsNode(graph.getNode(src));
  }

  private static boolean isInValid(Graph graph, List<String> values) {
    if (graph == null || values == null || values.isEmpty()) {
      return true;
    }
    for (String value : values) {
      if (!graph.containsNode(graph.getNode(value))) {
        return true;
      }
    }
    return false;
  }

  private static boolean isCyclic(Graph graph, List<String> values) {
    for (int i = 0; i < values.size() - 1; i++) {
      Node node = graph.getNode(values.get(i));
      Node nextNode = graph.getNode(values.get(i + 1));

      if (!graph.getNodeNeighbors(node).contains(nextNode)) {
        return false;
      }
    }
    return values.get(0).equals(values.get(values.size() - 1));
  }

}