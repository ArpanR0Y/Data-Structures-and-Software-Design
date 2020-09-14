import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MazeTest {
  Class<?> c;

  public MazeTest() {
  }

  @Before
  public void setUp() throws Exception {
    try {
      this.c = Class.forName("Maze");
    } catch (ClassNotFoundException var2) {
      throw new Exception("Class Maze does not exist");
    }
  }

  @Test
  public void testSuperClass() {
    if (!MasterTester7.hasSuperClass(this.c, "Object")) {
      Assert.fail("Maze should not extend anything");
    }

  }

  @Test
  public void testAbstract() {
    if (MasterTester7.isAbstract(this.c)) {
      Assert.fail("Maze should not be abstract");
    }

  }

  @Test
  public void testNumFields() {
    if (!MasterTester7.hasNumFields(this.c, 1)) {
      Assert.fail("Maze should have 1 field");
    }

  }

  @Test
  public void testRoomField() {
    if (!MasterTester7.hasPublicField(this.c, "Room[]", "rooms")) {
      Assert.fail("Maze should have public Room[] field called rooms");
    }

  }

  @Test
  public void testNumMethods() {
    if (!MasterTester7.hasNumMethods(this.c, 1)) {
      Assert.fail("Maze should have 1 method");
    }

  }

  @Test
  public void testAddRoomMethod() {
    if (!MasterTester7.hasMethod(this.c, "addRoom", Void.TYPE, new Class[]{Room.class})) {
      Assert.fail("Maze should have a \"addRoom\" method that accepts a Room object parameter and returns void");
    }

  }
}