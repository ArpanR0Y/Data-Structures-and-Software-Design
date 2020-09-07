import BinarySearchTree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepthTest {
  protected BinarySearchTree<String> tree;

  public DepthTest() {
  }

  @Before
  public void setUp() throws Exception {
    this.tree = new BinarySearchTree();
    this.tree.add("dog");
    this.tree.add("cat");
    this.tree.add("pig");
  }

  @Test
  public void testNull() {
    try {
      int var1 = this.tree.depth(null);
      Assert.assertEquals("depth should be -1 when input value is null", -1L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("depth throws " + var2 + " when input value is null");
    }

  }

  @Test
  public void testNotInTree() {
    try {
      int var1 = this.tree.depth("banana");
      Assert.assertEquals("depth should be -1 when input value is not in tree", -1L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("depth throws " + var2 + " when input value is not in tree");
    }

  }

  @Test
  public void testRoot() {
    try {
      int var1 = this.tree.depth("dog");
      Assert.assertEquals("depth should be 0 when input value is root", 0L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("depth throws " + var2 + " when input value is root");
    }

  }

  @Test
  public void testLeftChildOfRoot() {
    try {
      int var1 = this.tree.depth("cat");
      Assert.assertEquals("depth should be 1 when input value is left child of root", 1L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("depth throws " + var2 + " when input value is left child of root");
    }

  }

  @Test
  public void testRightChildOfRoot() {
    try {
      int var1 = this.tree.depth("pig");
      Assert.assertEquals("depth should be 1 when input value is right child of root", 1L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("depth throws " + var2 + " when input value is right child of root");
    }

  }

  @Test
  public void testGrandchildOfRoot() {
    try {
      this.tree.add("ant");
      int var1 = this.tree.depth("ant");
      Assert.assertEquals("depth should be 2 when input value is grandchild of root", 2L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("depth throws " + var2 + " when input value is grandchild of root");
    }

  }
}