import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParseMovieRatingsTest {
  List<UserMovieRating> ratings;

  public ParseMovieRatingsTest() {
  }

  @Before
  public void setUp() {
    this.ratings = new LinkedList();
    this.ratings.add(new UserMovieRating("singles", 5));
    this.ratings.add(new UserMovieRating("singles", 4));
    this.ratings.add(new UserMovieRating("zootopia", 4));
    this.ratings.add(new UserMovieRating("zootopia", 2));
  }

  @Test
  public void testNull() {
    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings((List)null);
      if (var1 == null) {
        Assert.fail("parseMovieRatings should return empty TreeMap when input is null");
      }

      Assert.assertTrue("parseMovieRatings should return empty TreeMap when input is null", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("parseMovieRatings throws " + var2 + " when input is null");
    }

  }

  @Test
  public void testEmpty() {
    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings(new LinkedList());
      if (var1 == null) {
        Assert.fail("parseMovieRatings should return empty TreeMap when input is empty");
      }

      Assert.assertTrue("parseMovieRatings should return empty TreeMap when input is empty", var1.isEmpty());
    } catch (Exception var2) {
      Assert.fail("parseMovieRatings throws " + var2 + " when input is empty");
    }

  }

  @Test
  public void testNormalInput() {
    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings(this.ratings);
      if (var1 == null) {
        Assert.fail("parseMovieRatings returns null for valid input List");
      }

      Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List", 2L, (long)var1.size());
      PriorityQueue var2 = (PriorityQueue)var1.get("singles");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys for valid input List");
      }

      int var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 4L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 5L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List", var2.isEmpty());
      var2 = (PriorityQueue)var1.get("zootopia");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys for valid input List");
      }

      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 2L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 4L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List", var2.isEmpty());
    } catch (Exception var4) {
      Assert.fail("parseMovieRatings throws " + var4 + " for valid input List");
    }

  }

  @Test
  public void testIgnoreNullRating() {
    this.ratings.add(null);

    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings(this.ratings);
      if (var1 == null) {
        Assert.fail("parseMovieRatings returns null when input List contains null rating");
      }

      Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating", 2L, (long)var1.size());
      PriorityQueue var2 = (PriorityQueue)var1.get("singles");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains null rating");
      }

      int var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 4L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 5L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating", var2.isEmpty());
      var2 = (PriorityQueue)var1.get("zootopia");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains null rating");
      }

      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 2L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 4L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating", var2.isEmpty());
    } catch (Exception var4) {
      Assert.fail("parseMovieRatings throws " + var4 + " when input List contains null rating");
    }

  }

  @Test
  public void testIgnoreNullTitle() {
    this.ratings.add(new UserMovieRating((String)null, 5));

    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings(this.ratings);
      if (var1 == null) {
        Assert.fail("parseMovieRatings returns null when input List contains rating with null title");
      }

      Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title", 2L, (long)var1.size());
      PriorityQueue var2 = (PriorityQueue)var1.get("singles");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with null title");
      }

      int var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 4L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 5L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title", var2.isEmpty());
      var2 = (PriorityQueue)var1.get("zootopia");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with null title");
      }

      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 2L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 4L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title", var2.isEmpty());
    } catch (Exception var4) {
      Assert.fail("parseMovieRatings throws " + var4 + " when input List contains rating with null title");
    }

  }

  @Test
  public void testIgnoreEmptyTitle() {
    this.ratings.add(new UserMovieRating("", 5));

    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings(this.ratings);
      if (var1 == null) {
        Assert.fail("parseMovieRatings returns null when input List contains rating with empty title");
      }

      Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title", 2L, (long)var1.size());
      PriorityQueue var2 = (PriorityQueue)var1.get("singles");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with empty title");
      }

      int var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 4L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 5L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title", var2.isEmpty());
      var2 = (PriorityQueue)var1.get("zootopia");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with empty title");
      }

      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 2L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 4L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title", var2.isEmpty());
    } catch (Exception var4) {
      Assert.fail("parseMovieRatings throws " + var4 + " when input List contains rating with empty title");
    }

  }

  @Test
  public void testIgnoreNegativeRating() {
    this.ratings.add(new UserMovieRating("Singles", -4));

    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings(this.ratings);
      if (var1 == null) {
        Assert.fail("parseMovieRatings returns null when input List contains rating with negative rating");
      }

      Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating", 2L, (long)var1.size());
      PriorityQueue var2 = (PriorityQueue)var1.get("singles");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with negative rating");
      }

      int var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 4L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 5L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating", var2.isEmpty());
      var2 = (PriorityQueue)var1.get("zootopia");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with negative rating");
      }

      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 2L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 4L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating", var2.isEmpty());
    } catch (Exception var4) {
      Assert.fail("parseMovieRatings throws " + var4 + " when input List contains rating with negative rating");
    }

  }

  @Test
  public void testIgnoreCase() {
    this.ratings.add(new UserMovieRating("ZOOTOPIA", 3));

    try {
      TreeMap var1 = MovieRatingsParser.parseMovieRatings(this.ratings);
      if (var1 == null) {
        Assert.fail("parseMovieRatings returns null when input List contains movies with same case-insensitive titles");
      }

      Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles", 2L, (long)var1.size());
      PriorityQueue var2 = (PriorityQueue)var1.get("singles");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains movies with same case-insensitive titles");
      }

      int var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 4L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 5L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles", var2.isEmpty());
      var2 = (PriorityQueue)var1.get("zootopia");
      if (var2 == null) {
        Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains movies with same case-insensitive titles");
      }

      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 2L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 3L, (long)var3);
      var3 = (Integer)var2.remove();
      Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 4L, (long)var3);
      Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles", var2.isEmpty());
    } catch (Exception var4) {
      Assert.fail("parseMovieRatings throws " + var4 + " when input List contains movies with same case-insensitive titles");
    }

  }
}