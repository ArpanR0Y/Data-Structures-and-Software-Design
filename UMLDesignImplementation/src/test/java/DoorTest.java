import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoorTest {
  Class<?> c;

  public DoorTest() {
  }

  @Before
  public void setUp() throws Exception {
    try {
      this.c = Class.forName("Door");
    } catch (ClassNotFoundException var2) {
      throw new Exception("Class Door does not exist");
    }
  }

  @Test
  public void testSuperClass() {
    if (!MasterTester7.hasSuperClass(this.c, "MapSite")) {
      Assert.fail("Door should extend MapSite");
    }

  }

  @Test
  public void testAbstract() {
    if (MasterTester7.isAbstract(this.c)) {
      Assert.fail("Door should not be abstract");
    }

  }

  @Test
  public void testNumFields() {
    if (!MasterTester7.hasNumFields(this.c, 3)) {
      Assert.fail("Door should have 3 fields");
    }

  }

  @Test
  public void testIsOpenField() {
    if (!MasterTester7.hasPublicField(this.c, "boolean", "isOpen")) {
      Assert.fail("Door should have public field of type boolean called isOpen");
    }

  }

  @Test
  public void testRoom1Field() {
    if (!MasterTester7.hasPublicField(this.c, "Room", "room1")) {
      Assert.fail("Door should have public field of type Room called room1");
    }

  }

  @Test
  public void testRoom2Field() {
    if (!MasterTester7.hasPublicField(this.c, "Room", "room2")) {
      Assert.fail("Door should have public field of type Room called room2");
    }

  }

  @Test
  public void testNumMethods() {
    if (!MasterTester7.hasNumMethods(this.c, 1)) {
      Assert.fail("Door should have 1 method");
    }

  }

  @Test
  public void testEnterMethod() {
    if (!MasterTester7.hasMethod(this.c, "enter", Void.TYPE, new Class[0])) {
      Assert.fail("Door should have an \"enter\" method that accepts no parameters and returns void");
    }

  }
}