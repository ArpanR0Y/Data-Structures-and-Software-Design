//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainsTest {
  public ContainsTest() {
  }

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testContainsMiddle() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(8);
    var2.add(3);
    var2.add(12);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second in middle of list", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first LinkedList contains second in middle of list");
    }

  }

  @Test
  public void testContainsFront() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(4);
    var2.add(8);
    var2.add(3);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second at front of list", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first LinkedList contains second at front of list");
    }

  }

  @Test
  public void testContainsRear() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(3);
    var2.add(12);
    var2.add(6);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second at rear of list", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first LinkedList contains second at rear of list");
    }

  }

  @Test
  public void testNoOverlap() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(5);
    var2.add(9);
    var2.add(2);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when lists have no overlapping elements", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when lists have no overlapping elements");
    }

  }

  @Test
  public void testSomeOverlap() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(8);
    var2.add(3);
    var2.add(9);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when lists have some overlapping elements but first does not contain all elements of second", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when lists have some overlapping elements but first does not contain all elements of second");
    }

  }

  @Test
  public void testOverlapWrongOrder() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(12);
    var2.add(8);
    var2.add(6);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when first LinkedList contains all elements of second but not in same order", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first LinkedList contains all elements of second but not in same order");
    }

  }

  @Test
  public void testOverlapOtherElementsInSequenceInOne() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(8);
    var2.add(3);
    var2.add(6);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when first LinkedList contains all elements of second but with other elements in sequence", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first LinkedList contains all elements of second but with other elements in sequence");
    }

  }

  @Test
  public void testOverlapOtherElementsInSequenceInTwo() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(8);
    var2.add(3);
    var2.add(9);
    var2.add(12);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when first LinkedList contains all elements of second but with other elements in sequence", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first LinkedList contains all elements of second but with other elements in sequence");
    }

  }

  @Test
  public void testOverlapAtEndOfOne() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(12);
    var2.add(6);
    var2.add(7);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when lists overlap at end of first LinkedList but it does not contain all elements of second", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when lists overlap at end of first LinkedList but it does not contain all elements of second");
    }

  }

  @Test
  public void testFirstNull() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(12);
    var2.add(6);
    var2.add(7);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence((LinkedList)null, var2);
      Assert.assertFalse("containsSubsequence returns true when first input is null", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first input is null");
    }

  }

  @Test
  public void testSecondNull() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);
    var2.add(12);
    var2.add(6);
    var2.add(7);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, (LinkedList)null);
      Assert.assertFalse("containsSubsequence returns true when second input is null", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws  " + var4 + " when second input is null");
    }

  }

  @Test
  public void testFirstEmpty() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var2.add(12);
    var2.add(6);
    var2.add(7);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when first input is empty", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when first input is empty");
    }

  }

  @Test
  public void testSecondEmpty() {
    LinkedList var1 = new LinkedList();
    LinkedList var2 = new LinkedList();
    var1.add(4);
    var1.addLast(8);
    var1.addLast(3);
    var1.addLast(12);
    var1.addLast(6);

    try {
      boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
      Assert.assertFalse("containsSubsequence returns true when second input is empty", var3);
    } catch (Exception var4) {
      Assert.fail("containsSubsequence throws " + var4 + " when second input is empty");
    }

  }
}
