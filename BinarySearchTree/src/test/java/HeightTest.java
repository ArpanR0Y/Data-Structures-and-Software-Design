import BinarySearchTree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeightTest {
  protected BinarySearchTree<String> tree;

  public HeightTest() {
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
      int var1 = this.tree.height(null);
      Assert.assertEquals("height should be -1 when input value is null", -1L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("height throws " + var2 + " when input value is null");
    }

  }

  @Test
  public void testNotInTree() {
    try {
      int var1 = this.tree.height("banana");
      Assert.assertEquals("height should be -1 when input value is not in tree", -1L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("height throws " + var2 + " when input value is not in tree");
    }

  }

  @Test
  public void testLeaf() {
    try {
      int var1 = this.tree.height("cat");
      Assert.assertEquals("height should be 0 when input value is leaf", 0L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("height throws " + var2 + " when input value is leaf");
    }

  }

  @Test
  public void testParentOfLeaves() {
    try {
      int var1 = this.tree.height("dog");
      Assert.assertEquals("height should be 1 when input value is parent of two leaves", 1L, (long)var1);
    } catch (Exception var2) {
      Assert.fail("height throws " + var2 + " when input value is parent of two leaves");
    }

  }

  @Test
  public void testNumerousDescendants() {
    this.tree.add("ant");
    this.tree.add("cow");
    this.tree.add("aah!");

    try {
      int var1 = this.tree.height("dog");
      Assert.assertTrue("height incorrect when input value has numerous descendants", 3 == var1);
    } catch (Exception var2) {
      Assert.fail("height throws " + var2 + " when input value has numerous descendants");
    }

  }
}