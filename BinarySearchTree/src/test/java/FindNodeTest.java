import BinarySearchTree.BinarySearchTree;
import BinarySearchTree.BinarySearchTree.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindNodeTest {
  protected BinarySearchTree<String> tree;

  public FindNodeTest() {
  }

  @Before
  public void setUp() throws Exception {
    this.tree = new BinarySearchTree();
    this.tree.add("dog");
    this.tree.add("cat");
    this.tree.add("pig");
  }

  @Test
  public void testTargetIsRoot() {
    try {
      Node var1 = this.tree.findNode("dog");
      if (var1 == null) {
        Assert.fail("findNode returned null when looking for value that is root");
      }

      Assert.assertEquals("findNode returned incorrect Node when looking for value that is root", "dog", var1.value);
    } catch (Exception var2) {
      Assert.fail("findNode throws " + var2 + " when looking for value that is root");
    }

  }

  @Test
  public void testTargetIsLeftChildOfRoot() {
    try {
      Node var1 = this.tree.findNode("cat");
      if (var1 == null) {
        Assert.fail("findNode returned null when looking for value that is left child of root");
      }

      Assert.assertEquals("findNode returned incorrect Node when looking for value that is left child of root", "cat", var1.value);
    } catch (Exception var2) {
      Assert.fail("findNode throws " + var2 + " when looking for value that is left child of root");
    }

  }

  @Test
  public void testTargetIsRightChildOfRoot() {
    try {
      Node var1 = this.tree.findNode("pig");
      if (var1 == null) {
        Assert.fail("findNode returned null when looking for value that is right child of root");
      }

      Assert.assertEquals("findNode returned incorrect Node when looking for value that is right child of root", "pig", var1.value);
    } catch (Exception var2) {
      Assert.fail("findNode throws " + var2 + " when looking for value that is right child of root");
    }

  }

  @Test
  public void testTargetIsGrandchildOfRoot() {
    this.tree.add("ant");

    try {
      Node var1 = this.tree.findNode("ant");
      if (var1 == null) {
        Assert.fail("findNode returned null when looking for value that is grandchild of root");
      }

      Assert.assertEquals("findNode returned incorrect Node when looking for value that is grandchild of root", "ant", var1.value);
    } catch (Exception var2) {
      Assert.fail("findNode throws " + var2 + " when looking for value that is grandchild of root");
    }

  }

  @Test
  public void testTargetIsNotInTree() {
    try {
      Node var1 = this.tree.findNode("monkey");
      Assert.assertNull("findNode did not return null when looking for value that is not in tree", var1);
    } catch (Exception var2) {
      Assert.fail("findNode throws " + var2 + " when looking for value that is not in tree");
    }

  }

  @Test
  public void testTargetIsNull() {
    try {
      Node var1 = this.tree.findNode(null);
      Assert.assertNull("findNode did not return null when input value is null", var1);
    } catch (Exception var2) {
      Assert.fail("findNode throws " + var2 + " when input value is null");
    }

  }
}