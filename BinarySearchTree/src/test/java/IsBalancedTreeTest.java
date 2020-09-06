import BinarySearchTree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsBalancedTreeTest {
  protected BinarySearchTree<String> tree;

  public IsBalancedTreeTest() {
  }

  @Before
  public void setUp() throws Exception {
    this.tree = new BinarySearchTree();
    this.tree.add("dog");
    this.tree.add("cat");
    this.tree.add("pig");
  }

  @Test
  public void testRootAndTwoChildren() {
    try {
      boolean var1 = this.tree.isBalanced();
      Assert.assertTrue("isBalanced should be true when only nodes are root of tree and its two children", var1);
    } catch (Exception var2) {
      Assert.fail("isBalanced throws " + var2 + " when only nodes are root of tree and its two children");
    }

  }

  @Test
  public void testRootAndTwoChildrenAndOneLeftGrandchild() {
    this.tree.add("ant");

    try {
      boolean var1 = this.tree.isBalanced();
      Assert.assertTrue("isBalanced should be true when difference in heights of root's left and right subtrees is 1", var1);
    } catch (Exception var2) {
      Assert.fail("isBalanced throws " + var2 + " when difference in heights of root's left and right subtrees is 1");
    }

  }

  @Test
  public void testRootAndTwoChildrenAndOneRightGrandchild() {
    this.tree.add("skunk");

    try {
      boolean var1 = this.tree.isBalanced();
      Assert.assertTrue("isBalanced should be true when difference in heights of root's left and right subtrees is 1", var1);
    } catch (Exception var2) {
      Assert.fail("isBalanced throws " + var2 + " when difference in heights of root's left and right subtrees is 1");
    }

  }

  @Test
  public void testRightHeightIsMoreThanOneGreaterThanLeft() {
    this.tree.add("skunk");
    this.tree.add("zebra");

    try {
      boolean var1 = this.tree.isBalanced();
      Assert.assertFalse("isBalanced should be false when difference in heights of root's left and right subtrees is greater than 1", var1);
    } catch (Exception var2) {
      Assert.fail("isBalanced throws " + var2 + " when difference in heights of root's left and right subtrees is greater than 1");
    }

  }

  @Test
  public void testLeftHeightIsMoreThanOneGreaterThanRight() {
    this.tree.add("ant");
    this.tree.add("aah!");

    try {
      boolean var1 = this.tree.isBalanced();
      Assert.assertFalse("isBalanced should be false when difference in heights of root's left and right subtrees is greater than 1", var1);
    } catch (Exception var2) {
      Assert.fail("isBalanced throws " + var2 + " when difference in heights of root's left and right subtrees is greater than 1");
    }

  }

  @Test
  public void testRootIsBalancedButChildrenAreNot() {
    this.tree.add("ant");
    this.tree.add("aah!");
    this.tree.add("skunk");
    this.tree.add("zebra");

    try {
      boolean var1 = this.tree.isBalanced();
      Assert.assertFalse("isBalanced should be false when root Node is balanced but its children are not", var1);
    } catch (Exception var2) {
      Assert.fail("isBalanced throws " + var2 + " when root Node is balanced but its children are not");
    }

  }
}