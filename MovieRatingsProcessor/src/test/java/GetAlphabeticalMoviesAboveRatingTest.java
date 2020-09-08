import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetAlphabeticalMoviesAboveRatingTest {
  TreeMap<String, PriorityQueue<Integer>> map;

  public GetAlphabeticalMoviesAboveRatingTest() {
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
    var3.add(3);
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
      List var1 = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating((TreeMap)null, 2);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMoviesAboveRating should return empty List when input is null");
      }

      Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when input is null", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMoviesAboveRating throws " + var2 + " when input is null");
    }

  }

  @Test
  public void testEmpty() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(new TreeMap(), 2);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMoviesAboveRating should return empty List when input is empty");
      }

      Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when input is empty", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMoviesAboveRating throws " + var2 + " when input is empty");
    }

  }

  @Test
  public void testReturnMoviesAbove() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 2);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMoviesAboveRating returns null for valid input");
      }

      Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when some movies are above threshold", 2L, (long)var1.size());
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies are above threshold", var1.contains("sabrina"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies are above threshold", var1.contains("grease"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies are above threshold", ((String)var1.get(0)).equals("grease"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies are above threshold", ((String)var1.get(1)).equals("sabrina"));
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMoviesAboveRating throws " + var2 + " for valid input");
    }

  }

  @Test
  public void testReturnMoviesAboveNotEqual() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 1);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMoviesAboveRating returns null for valid input");
      }

      Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when some movies' minimum rating equals threshold", 2L, (long)var1.size());
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies' minimum rating equals threshold", var1.contains("sabrina"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies' minimum rating equals threshold", var1.contains("grease"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies' minimum rating equals threshold", ((String)var1.get(0)).equals("grease"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies' minimum rating equals threshold", ((String)var1.get(1)).equals("sabrina"));
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMoviesAboveRating throws " + var2 + " for valid input");
    }

  }

  @Test
  public void testAllMoviesBelowThreshold() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 8);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMoviesAboveRating returns null when all movies' minimum rating is below threshold");
      }

      Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when all movies' minimum rating is below threshold", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMoviesAboveRating throws " + var2 + " when all movies' minimum rating is below threshold");
    }

  }

  @Test
  public void testAllMoviesAbove() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 0);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMoviesAboveRating returns null when all movies are above threshold");
      }

      Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when all movies are above threshold", 4L, (long)var1.size());
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", var1.contains("sabrina"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", var1.contains("grease"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", var1.contains("inception"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", var1.contains("ratatouille"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)var1.get(0)).equals("grease"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)var1.get(1)).equals("inception"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)var1.get(2)).equals("ratatouille"));
      Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)var1.get(3)).equals("sabrina"));
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMoviesAboveRating throws " + var2 + " when all movies are above threshold");
    }

  }
}