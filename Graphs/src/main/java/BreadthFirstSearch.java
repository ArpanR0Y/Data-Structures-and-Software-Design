import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	

	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
				return false;
		}
		if (start.getElement().equals(elementToFind)) {
			return true;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return false;
	}

  /**
   * This method uses BFS to get the minimum distance from one node to the other. Since BFS goes
   * level by level while exploring nodes, we use that property to get the min distance. Each level
   * represents a unit distance, eg root node is at level 0, therefore, the min distance is also 0.
   *
   * A transition to the next level occurs when all the nodes of that level have been explored i.e 0
   * For every transition to the next level, the min distance is incremented by 1.
   * The number of nodes to be explored in a new level is denoted by the number of new elements added
   * to the Queue (toExplore) in the previous level.
   *
   * Since, the destination node will be present in the next level with respect to the current level
   * we are traversing, therefore, when the destination node is found the min distance + 1 is returned.
   */
  public int getMinDistance(Node start, String elementToFind) {
    if (!graph.containsNode(start)) {
      return -1;
    }
    if (start.getElement().equals(elementToFind)) {
      return 0;
    }
    Queue<Node> toExplore = new LinkedList<>();
    marked.add(start);
    toExplore.add(start);
    int minDistance = 0;
    int nodesToExploreInThisLevel = 1;
    while (!toExplore.isEmpty()) {
      Node current = toExplore.remove();
      nodesToExploreInThisLevel--;

      int nodesToExploreInNextLevel = 0;
      for (Node neighbor : graph.getNodeNeighbors(current)) {
        if (!marked.contains(neighbor)) {
          if (neighbor.getElement().equals(elementToFind)) {
            return ++minDistance;
          }
          marked.add(neighbor);
          toExplore.add(neighbor);
          nodesToExploreInNextLevel++;
        }
      }
      if(nodesToExploreInThisLevel == 0) {
        minDistance++;
      }
      nodesToExploreInThisLevel = nodesToExploreInNextLevel;
    }
    return -1;
  }

}
