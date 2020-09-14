import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RandomizedMazeGameTest {
  Class<?> c;

  public RandomizedMazeGameTest() {
  }

  @Before
  public void setUp() throws Exception {
    try {
      this.c = Class.forName("RandomizedMazeGame");
    } catch (ClassNotFoundException var2) {
      throw new Exception("Class RandomizedMazeGame does not exist");
    }
  }

  @Test
  public void testSuperClass() {
    if (!MasterTester7.hasSuperClass(this.c, "MazeGame")) {
      Assert.fail("RandomizedMazeGame should extend MazeGame");
    }

  }

  @Test
  public void testAbstract() {
    if (MasterTester7.isAbstract(this.c)) {
      Assert.fail("RandomizedMazeGame should not be abstract");
    }

  }

  @Test
  public void testNumFields() {
    if (!MasterTester7.hasNumFields(this.c, 0)) {
      Assert.fail("RandomizedMazeGame should have 0 fields");
    }

  }

  @Test
  public void testNumMethods() {
    if (!MasterTester7.hasNumMethods(this.c, 1)) {
      Assert.fail("RandomizedMazeGame should have 1 method");
    }

  }

  @Test
  public void testRandomizeMethod() {
    if (!MasterTester7.hasMethod(this.c, "randomize", Maze.class, new Class[]{Integer.TYPE})) {
      Assert.fail("RandomizedMazeGame should have a \"randomize\" method that accepts an int parameter and returns a Maze object");
    }

  }
}