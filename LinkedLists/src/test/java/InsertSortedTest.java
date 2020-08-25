//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertSortedTest {
  public InsertSortedTest() {
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testInsertMiddle() {
    LinkedList var1 = new LinkedList();
    var1.add(3);
    var1.addLast(8);
    var1.addLast(11);

    try {
      LinkedListUtils.insertSorted(var1, 10);
    } catch (Exception var3) {
      Assert.fail("insertSorted throws " + var3 + " when placing value in middle of list");
    }

    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value in middle of list", var1.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", (Integer)var1.get(0) == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", (Integer)var1.get(1) == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", (Integer)var1.get(2) == 10);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of list", (Integer)var1.get(3) == 11);
  }

  @Test
  public void testInsertEnd() {
    LinkedList var1 = new LinkedList();
    var1.add(3);
    var1.addLast(8);
    var1.addLast(11);

    try {
      LinkedListUtils.insertSorted(var1, 14);
    } catch (Exception var3) {
      Assert.fail("insertSorted throws " + var3 + " when placing value at end of list");
    }

    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at end of list", var1.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", (Integer)var1.get(0) == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", (Integer)var1.get(1) == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", (Integer)var1.get(2) == 11);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list", (Integer)var1.get(3) == 14);
  }

  @Test
  public void testInsertFront() {
    LinkedList var1 = new LinkedList();
    var1.add(3);
    var1.addLast(8);
    var1.addLast(11);

    try {
      LinkedListUtils.insertSorted(var1, 1);
    } catch (Exception var3) {
      Assert.fail("insertSorted throws " + var3 + " when placing value at front of list");
    }

    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at front of list", var1.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", (Integer)var1.get(0) == 1);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", (Integer)var1.get(1) == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", (Integer)var1.get(2) == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of list", (Integer)var1.get(3) == 11);
  }

  @Test
  public void testInsertMiddleEqualToExistingElement() {
    LinkedList var1 = new LinkedList();
    var1.add(3);
    var1.addLast(8);
    var1.addLast(11);

    try {
      LinkedListUtils.insertSorted(var1, 8);
    } catch (Exception var3) {
      Assert.fail("insertSorted throws " + var3 + " when placing value that is equal to value already in list");
    }

    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value that is equal to value already in list", var1.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", (Integer)var1.get(0) == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", (Integer)var1.get(1) == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", (Integer)var1.get(2) == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal to value already in list", (Integer)var1.get(3) == 11);
  }

  @Test
  public void testNull() {
    try {
      LinkedListUtils.insertSorted((LinkedList)null, 0);
    } catch (Exception var2) {
      Assert.fail("insertSorted throws " + var2 + " when input LinkedList is null");
    }

  }

  @Test
  public void testInsertEmpty() {
    LinkedList var1 = new LinkedList();

    try {
      LinkedListUtils.insertSorted(var1, 10);
    } catch (Exception var3) {
      Assert.fail("insertSorted throws " + var3 + " when inserting into empty list");
    }

    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when inserting into empty list", var1.size() == 1);
    Assert.assertTrue("insertSorted does not correctly insert element into empty list", (Integer)var1.get(0) == 10);
  }
}
