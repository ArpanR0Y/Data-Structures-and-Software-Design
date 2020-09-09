import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetAlphabeticalMoviesTest {
  TreeMap<String, PriorityQueue<Integer>> map;

  public GetAlphabeticalMoviesTest() {
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
  }

  @Test
  public void testNull() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMovies((TreeMap)null);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMovies should return empty List when input is null");
      }

      Assert.assertTrue("getAlphabeticalMovies should return empty List when input is null", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMovies throws " + var2 + " when input is null");
    }

  }

  @Test
  public void testEmpty() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMovies(new TreeMap());
      if (var1 == null) {
        Assert.fail("getAlphabeticalMovies should return empty List when input is empty");
      }

      Assert.assertTrue("getAlphabeticalMovies should return empty List when input is empty", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMovies throws " + var2 + " when input is empty");
    }

  }

  @Test
  public void testValidInput() {
    try {
      List var1 = MovieRatingsProcessor.getAlphabeticalMovies(this.map);
      if (var1 == null) {
        Assert.fail("getAlphabeticalMovies returns null for valid input");
      }

      Assert.assertEquals("getAlphabeticalMovies returns List with incorrect number of entries for valid input", 3L, (long)var1.size());
      Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", var1.contains("sabrina"));
      Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", var1.contains("inception"));
      Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", var1.contains("ratatouille"));
      Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", ((String)var1.get(0)).equals("inception"));
      Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", ((String)var1.get(1)).equals("ratatouille"));
      Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", ((String)var1.get(2)).equals("sabrina"));
    } catch (Exception var2) {
      Assert.fail("getAlphabeticalMovies throws " + var2 + " for valid input");
    }

  }
}