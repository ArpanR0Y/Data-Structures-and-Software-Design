import java.nio.file.Paths;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodesWithinDistanceTest {
  static final String projectPath = Paths.get(".").normalize().toAbsolutePath().toString();
  protected static final String FILENAME = projectPath + "\\src\\test\\resources\\graph_builder_test.txt";

  public NodesWithinDistanceTest() {
  }

  @Before
  public void setUp() {
  }

  @Test
  public void testNullGraph() {
    try {
      Set var1 = GraphUtils.nodesWithinDistance(null, "0", 3);
      Assert.assertNull("nodesWithinDistance should return null when input Graph is null", var1);
    } catch (Exception var2) {
      Assert.fail("nodesWithinDistance throws " + var2 + " when input Graph is null");
    }

  }

  @Test
  public void testNullSrc() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, null, 3);
      Assert.assertNull("nodesWithinDistance should return null when input src is null", var2);
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when input src is null");
    }

  }

  @Test
  public void testSrcNotInGraph() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "banana", 3);
      Assert.assertNull("nodesWithinDistance should return null when input src is not in graph", var2);
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when input src is not in graph");
    }

  }

  @Test
  public void testNegativeDistance() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "0", -1);
      Assert.assertNull("nodesWithinDistance should return null when distance is negative", var2);
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when distance is negative");
    }

  }

  @Test
  public void testZeroDistance() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "0", 0);
      Assert.assertNull("nodesWithinDistance should return null when distance is zero", var2);
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when distance is zero");
    }

  }

  @Test
  public void testOnlyNodeInGraph() {
    UndirectedGraph var1 = new UndirectedGraph();
    var1.addNode(new Node("lonely"));

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "lonely", 2);
      Assert.assertNotNull("nodesWithinDistance returns null when specified node is only node in graph and distance >= 1", var2);
      Assert.assertTrue("nodesWithinDistance should return empty Set when specified node is only node in graph and distance >= 1", var2.isEmpty());
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when specified node is only node in graph and distance >= 1");
    }

  }

  @Test
  public void testDistance1Undirected() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "0", 1);
      Assert.assertNotNull("nodesWithinDistance returns null when distance = 1 in undirected graph", var2);
      Assert.assertEquals(
          "nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in undirected graph",
          4, var2.size());
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", var2.contains("1"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", var2.contains("2"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", var2.contains("3"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in undirected graph", var2.contains("5"));
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when distance = 1 in undirected graph");
    }

  }

  @Test
  public void testDistance1Directed() {
    DirectedGraph var1 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "1", 1);
      Assert.assertNotNull("nodesWithinDistance returns null when distance = 1 in directed graph", var2);
      Assert.assertEquals(
          "nodesWithinDistance returns Set with incorrect number of elements when distance = 1 in directed graph",
          2, var2.size());
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", var2.contains("2"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance = 1 in directed graph", var2.contains("5"));
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when distance = 1 in directed graph");
    }

  }

  @Test
  public void testDistanceGreaterThan1Undirected() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "0", 3);
      Assert.assertNotNull("nodesWithinDistance returns null when distance > 1 in undirected graph", var2);
      Assert.assertEquals(
          "nodesWithinDistance returns Set with incorrect number of elements when distance > 1 in undirected graph",
          6, var2.size());
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", var2.contains("1"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", var2.contains("2"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", var2.contains("3"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", var2.contains("4"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", var2.contains("5"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in undirected graph", var2.contains("6"));
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when distance > 1 in undirected graph");
    }

  }

  @Test
  public void testDistanceGreaterThan1Directed() {
    DirectedGraph var1 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file graph_builder_test.txt");
    }

    try {
      Set var2 = GraphUtils.nodesWithinDistance(var1, "2", 2);
      Assert.assertNotNull("nodesWithinDistance returns null when distance > 1 in directed graph", var2);
      Assert.assertEquals(
          "nodesWithinDistance returns Set with incorrect number of elements when distance > 1 in directed graph",
          3, var2.size());
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", var2.contains("4"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", var2.contains("5"));
      Assert.assertTrue("nodesWithinDistance returns Set with incorrect elements when distance > 1 in directed graph", var2.contains("6"));
    } catch (Exception var3) {
      Assert.fail("nodesWithinDistance throws " + var3 + " when distance > 1 in directed graph");
    }

  }
}