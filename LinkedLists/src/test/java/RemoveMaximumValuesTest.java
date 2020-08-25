//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveMaximumValuesTest {
  public RemoveMaximumValuesTest() {
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testNull() {
    try {
      LinkedListUtils.removeMaximumValues((LinkedList)null, 2);
    } catch (Exception var2) {
      Assert.fail("removeMaximumValues throws " + var2 + " when input LinkedList is null");
    }

  }

  @Test
  public void testNegativeSize() {
    LinkedList var1 = new LinkedList();
    var1.add("doge");
    var1.add("cat");

    try {
      LinkedListUtils.removeMaximumValues(var1, -1);
    } catch (Exception var3) {
      Assert.fail("removeMaximumValues throws " + var3 + " when number of elements to remove is negative");
    }

    if (var1.size() < 2) {
      Assert.fail("removeMaximumValues removes elements from LinkedList when number of elenents to remove is negative");
    }

    if (var1.size() > 2) {
      Assert.fail("removeMaximumValues adds elements to LinkedList when number of elenents to remove is negative");
    }

  }

  @Test
  public void testInsertEmpty() {
    LinkedList var1 = new LinkedList();

    try {
      LinkedListUtils.removeMaximumValues(var1, 1);
    } catch (Exception var3) {
      Assert.fail("removeMaximumValues throws " + var3 + " when input LinkedList is empty");
    }

    Assert.assertTrue("removeMaximumValues adds elements to list when input LinkedList is empty", var1.isEmpty());
  }

  @Test
  public void testRemoveGreaterThanSize() {
    LinkedList var1 = new LinkedList();
    var1.add("doge");

    try {
      LinkedListUtils.removeMaximumValues(var1, 2);
    } catch (Exception var3) {
      Assert.fail("removeMaximumValues throws " + var3 + " when number of elements to remove is greater than size of input LinkedList");
    }

    Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to remove is greater than size of input LinkedList", var1.isEmpty());
  }

  @Test
  public void testRemoveEqualsSize() {
    LinkedList var1 = new LinkedList();
    var1.add("doge");

    try {
      LinkedListUtils.removeMaximumValues(var1, 1);
    } catch (Exception var3) {
      Assert.fail("removeMaximumValues throws " + var3 + " when number of elements to remove equals size of input LinkedList");
    }

    Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to remove equals size of input LinkedList", var1.isEmpty());
  }

  @Test
  public void testEachMaxAppearsOnce() {
    LinkedList var1 = new LinkedList();
    var1.add("doge");
    var1.add("cat");
    var1.add("kangaroo");
    var1.add("koala");
    var1.add("bear");

    try {
      LinkedListUtils.removeMaximumValues(var1, 2);
    } catch (Exception var3) {
      Assert.fail("removeMaximumValues throws " + var3 + " when number of elements to remove is less than size of input");
    }

    if (var1.size() < 3) {
      Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to remove is less than size of input");
    }

    if (var1.size() > 3) {
      Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements to remove is less than size of input");
    }

    if (var1.contains("kangaroo") || var1.contains("koala")) {
      Assert.fail("removeMaximumValues does not remove correct elements from LinkedList when number of elements to remove is less than size of input");
    }

    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", ((String)var1.get(0)).equals("doge"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", ((String)var1.get(1)).equals("cat"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input", ((String)var1.get(2)).equals("bear"));
  }

  @Test
  public void testMaxValuesAppearMoreThanOnce() {
    LinkedList var1 = new LinkedList();
    var1.add("doge");
    var1.add("kangaroo");
    var1.add("cat");
    var1.add("kangaroo");
    var1.add("koala");
    var1.add("bear");
    var1.add("doge");
    var1.add("koala");
    var1.add("kangaroo");

    try {
      LinkedListUtils.removeMaximumValues(var1, 2);
    } catch (Exception var3) {
      Assert.fail("removeMaximumValues throws " + var3 + " when number of elements to remove is less than size of input and maximum elements appear more than once");
    }

    if (var1.size() < 4) {
      Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
    }

    if (var1.contains("kangaroo") || var1.contains("koala")) {
      Assert.fail("removeMaximumValues does not remove all instances of max elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
    }

    if (var1.size() > 4) {
      Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements to remove is less than size of input and maximum elements appear more than once");
    }

    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String)var1.get(0)).equals("doge"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String)var1.get(1)).equals("cat"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String)var1.get(2)).equals("bear"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements to remove is less than size of input and maximum elements appear more than once", ((String)var1.get(3)).equals("doge"));
  }
}
