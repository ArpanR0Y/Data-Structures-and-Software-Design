import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveAllRatingsBelowTest {
  TreeMap<String, PriorityQueue<Integer>> map;

  public RemoveAllRatingsBelowTest() {
  }

  @Before
  public void setUp() {
    this.map = new TreeMap();
    PriorityQueue var1 = new PriorityQueue();
    var1.add(3);
    var1.add(5);
    this.map.put("sabrina", var1);
    PriorityQueue var2 = new PriorityQueue();
    var2.add(4);
    var2.add(1);
    this.map.put("inception", var2);
    PriorityQueue var3 = new PriorityQueue();
    var3.add(4);
    var3.add(5);
    var3.add(1);
    var3.add(1);
    var3.add(5);
    this.map.put("ratatouille", var3);
    PriorityQueue var4 = new PriorityQueue();
    var4.add(4);
    var4.add(3);
    this.map.put("grease", var4);
  }

  @Test
  public void testNull() {
    try {
      TreeMap var1 = MovieRatingsProcessor.removeAllRatingsBelow((TreeMap)null, 2);
      if (var1 == null) {
        Assert.fail("removeAllRatingsBelow should return empty List when input is null");
      }

      Assert.assertTrue("removeAllRatingsBelow should return empty List when input is null", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("removeAllRatingsBelow throws " + var2 + " when input is null");
    }

  }

  @Test
  public void testEmpty() {
    try {
      TreeMap var1 = MovieRatingsProcessor.removeAllRatingsBelow(new TreeMap(), 2);
      if (var1 == null) {
        Assert.fail("removeAllRatingsBelow should return empty List when input is empty");
      }

      Assert.assertTrue("removeAllRatingsBelow should return empty List when input is empty", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("removeAllRatingsBelow throws " + var2 + " when input is empty");
    }

  }

  @Test
  public void testModifySomeMovies() {
    try {
      TreeMap var1 = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 2);
      if (var1 == null) {
        Assert.fail("removeAllRatingsBelow returns null when some movies have ratings to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when some movies have ratings to be removed", 2L, (long)var1.size());
      if (!var1.containsKey("inception")) {
        Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings to be removed", 1L, (long)(Integer)var1.get("inception"));
      if (!var1.containsKey("ratatouille")) {
        Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings to be removed", 2L, (long)(Integer)var1.get("ratatouille"));
      Assert.assertEquals("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed", 4L, (long)this.map.size());
      PriorityQueue var2 = (PriorityQueue)this.map.get("inception");
      if (var2 == null) {
        Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed");
      }

      if (var2.size() != 1) {
        Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings to be removed");
      }

      if ((Integer)var2.peek() < 2) {
        Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
      }

      var2 = (PriorityQueue)this.map.get("ratatouille");
      if (var2 == null) {
        Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed");
      }

      if (var2.size() != 3) {
        Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings to be removed");
      }

      if ((Integer)var2.remove() < 2) {
        Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
      }

      if ((Integer)var2.remove() < 2) {
        Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
      }
    } catch (Exception var3) {
      Assert.fail("removeAllRatingsBelow throws " + var3 + " when some movies have ratings to be removed");
    }

  }

  @Test
  public void testModifyNoMovies() {
    try {
      TreeMap var1 = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 0);
      if (var1 == null) {
        Assert.fail("removeAllRatingsBelow returns null when no movies have ratings to be removed");
      }

      Assert.assertTrue("removeAllRatingsBelow should return empty TreeMap when no movies have ratings to be removed", var1.isEmpty());
      PriorityQueue var2 = (PriorityQueue)this.map.get("sabrina");
      if (var2 == null) {
        Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
      }

      if (var2.size() != 2) {
        Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
      }

      var2 = (PriorityQueue)this.map.get("inception");
      if (var2 == null) {
        Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
      }

      if (var2.size() != 2) {
        Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
      }

      var2 = (PriorityQueue)this.map.get("ratatouille");
      if (var2 == null) {
        Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
      }

      if (var2.size() != 5) {
        Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
      }

      var2 = (PriorityQueue)this.map.get("grease");
      if (var2 == null) {
        Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
      }

      if (var2.size() != 2) {
        Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
      }
    } catch (Exception var3) {
      Assert.fail("removeAllRatingsBelow throws " + var3 + " when no movies have ratings to be removed");
    }

  }

  @Test
  public void testRemoveAllRatings() {
    try {
      TreeMap var1 = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 10);
      if (var1 == null) {
        Assert.fail("removeAllRatingsBelow returns null when all ratings for all movies are to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when all ratings for all movies are to be removed", 4L, (long)var1.size());
      if (!var1.containsKey("sabrina")) {
        Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2L, (long)(Integer)var1.get("sabrina"));
      if (!var1.containsKey("inception")) {
        Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2L, (long)(Integer)var1.get("inception"));
      if (!var1.containsKey("ratatouille")) {
        Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 5L, (long)(Integer)var1.get("ratatouille"));
      if (!var1.containsKey("grease")) {
        Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2L, (long)(Integer)var1.get("grease"));
      Assert.assertTrue("removeAllRatingsBelow should return remove all elements from input TreeMap when all ratings for all movies are to be removed", this.map.isEmpty());
    } catch (Exception var2) {
      Assert.fail("removeAllRatingsBelow throws " + var2 + " when all ratings for all movies are to be removed");
    }

  }

  @Test
  public void testRemoveBelowButNotEqual() {
    this.map.remove("sabrina");
    this.map.remove("grease");
    this.map.remove("inception");

    try {
      TreeMap var1 = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 4);
      if (var1 == null) {
        Assert.fail("removeAllRatingsBelow returns null when some movies have ratings to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when some movies have ratings to be removed", 1L, (long)var1.size());
      if (!var1.containsKey("ratatouille")) {
        Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
      }

      Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings that are equal to threshold", 2L, (long)(Integer)var1.get("ratatouille"));
      PriorityQueue var2 = (PriorityQueue)this.map.get("ratatouille");
      if (var2 == null) {
        Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings equal to threshold");
      }

      if (var2.size() != 3) {
        Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings equal to threshold");
      }
    } catch (Exception var3) {
      Assert.fail("removeAllRatingsBelow throws " + var3 + " when some movies have ratings to be removed");
    }

  }
}