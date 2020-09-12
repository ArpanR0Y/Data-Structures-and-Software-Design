import java.util.List;
import java.util.Set;

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
	  if (isInValid(graph, src, dest)) {
	    return -1;
    }

	  BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

		return breadthFirstSearch.getMinDistance(graph.getNode(src), dest);
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
    if (isInValid(graph, src, distance)) {
      return null;
    }

    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

		return breadthFirstSearch.getNodesWithinDistance(graph, src, distance);
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
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
	
}
