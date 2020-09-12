import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsHamiltonianPathTest {
  static final String projectPath = Paths.get(".").normalize().toAbsolutePath().toString();
  protected static final String FILENAME = projectPath + "\\src\\test\\resources\\is_hamiltonian_path_test.txt";

  public IsHamiltonianPathTest() {
  }

  protected List<String> createValidPath() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("1");
    var1.add("2");
    var1.add("3");
    var1.add("4");
    var1.add("5");
    var1.add("0");
    return var1;
  }

  @Before
  public void setUp() {
  }

  @Test
  public void testNullGraph() {
    List<String> var1 = this.createValidPath();

    try {
      boolean var2 = GraphUtils.isHamiltonianPath(null, var1);
      Assert.assertFalse("isHamiltonianPath should return false when input Graph is null", var2);
    } catch (Exception var3) {
      Assert.fail("isHamiltonianPath throws " + var3 + " when input Graph is null");
    }

  }

  @Test
  public void testNullLinkedList() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var2 = GraphUtils.isHamiltonianPath(var1, null);
      Assert.assertFalse("isHamiltonianPath should return false when input LinkedList is null", var2);
    } catch (Exception var3) {
      Assert.fail("isHamiltonianPath throws " + var3 + " when input LinkedList is null");
    }

  }

  @Test
  public void testEmptyLinkedList() {
    UndirectedGraph var1 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var1 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var2 = GraphUtils.isHamiltonianPath(var1, new LinkedList<>());
      Assert.assertFalse("isHamiltonianPath should return false when input LinkedList is empty", var2);
    } catch (Exception var3) {
      Assert.fail("isHamiltonianPath throws " + var3 + " when input LinkedList is empty");
    }

  }

  @Test
  public void testValidUndirected() {
    List<String> var1 = this.createValidPath();
    UndirectedGraph var2 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertTrue("isHamiltonianPath returns false when list represents a valid Hamiltonian path in undirected graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid Hamiltonian path in undirected graph");
    }

  }

  @Test
  public void testValidDirected() {
    List<String> var1 = this.createValidPath();
    DirectedGraph var2 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertTrue("isHamiltonianPath returns false when list represents a valid Hamiltonian path in directed graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid Hamiltonian path in directed graph");
    }

  }

  @Test
  public void testValidDoesntVisitAllNodesUndirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("2");
    var1.add("5");
    var1.add("0");
    UndirectedGraph var2 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that does not visit all nodes in undirected graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid path that does not visit all nodes in undirected graph");
    }

  }

  @Test
  public void testValidDoesntVisitAllNodesDirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("2");
    var1.add("5");
    var1.add("0");
    DirectedGraph var2 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that does not visit all nodes in directed graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid path that does not visit all nodes in directed graph");
    }

  }

  @Test
  public void testNotCycleUndirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("1");
    var1.add("2");
    var1.add("4");
    var1.add("5");
    var1.add("3");
    UndirectedGraph var2 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that is not a cycle in undirected graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid path that is not a cycle in undirected graph");
    }

  }

  @Test
  public void testNotCycleDirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("1");
    var1.add("2");
    var1.add("4");
    var1.add("5");
    var1.add("3");
    DirectedGraph var2 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that is not a cycle in directed graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid path that is not a cycle in directed graph");
    }

  }

  @Test
  public void testVisitsNodeMoreThanOnceUndirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("5");
    var1.add("3");
    var1.add("1");
    var1.add("4");
    var1.add("5");
    var1.add("0");
    UndirectedGraph var2 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that visits a node more than once in undirected graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid path that visits a node more than once in undirected graph");
    }

  }

  @Test
  public void testVisitsNodeMoreThanOnceDirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("5");
    var1.add("3");
    var1.add("1");
    var1.add("4");
    var1.add("5");
    var1.add("0");
    DirectedGraph var2 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a valid path that visits a node more than once in directed graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a valid path that visits a node more than once in directed graph");
    }

  }

  @Test
  public void testUnconnectedNodesUndirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("1");
    var1.add("3");
    var1.add("2");
    var1.add("4");
    var1.add("5");
    var1.add("0");
    UndirectedGraph var2 = GraphBuilder.buildUndirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in undirected graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath " + var4 + " when list represents a path in which some nodes are not connected in undirected graph");
    }

  }

  @Test
  public void testUnconnectedNodesDirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("0");
    var1.add("1");
    var1.add("3");
    var1.add("2");
    var1.add("4");
    var1.add("5");
    var1.add("0");
    DirectedGraph var2 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in directed graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a path in which some nodes are not connected in directed graph");
    }

  }

  @Test
  public void testNotConnectedDirectedButConnectedUndirected() {
    LinkedList<String> var1 = new LinkedList<>();
    var1.add("5");
    var1.add("4");
    var1.add("3");
    var1.add("2");
    var1.add("1");
    var1.add("0");
    var1.add("5");
    DirectedGraph var2 = GraphBuilder.buildDirectedGraph(FILENAME);
    if (var2 == null) {
      Assert.fail("Could not run test: unable to build graph from file is_hamiltonian_path_test.txt");
    }

    try {
      boolean var3 = GraphUtils.isHamiltonianPath(var2, var1);
      Assert.assertFalse("isHamiltonianPath returns true when list represents a path in which some nodes are not connected in a directed graph but are connected in underlying undirected graph", var3);
    } catch (Exception var4) {
      Assert.fail("isHamiltonianPath throws " + var4 + " when list represents a path in which some nodes are not connected in a directed graph but are connected in underlying undirected graph");
    }

  }
}