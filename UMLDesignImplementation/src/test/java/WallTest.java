import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WallTest {
  Class<?> c;

  public WallTest() {
  }

  @Before
  public void setUp() throws Exception {
    try {
      this.c = Class.forName("Wall");
    } catch (ClassNotFoundException var2) {
      throw new Exception("Class Wall does not exist");
    }
  }

  @Test
  public void testSuperClass() {
    if (!MasterTester7.hasSuperClass(this.c, "Object")) {
      Assert.fail("Wall should not extend anything");
    }

  }

  @Test
  public void testAbstract() {
    if (MasterTester7.isAbstract(this.c)) {
      Assert.fail("Wall should not be abstract");
    }

  }

  @Test
  public void testNumFields() {
    if (!MasterTester7.hasNumFields(this.c, 0)) {
      Assert.fail("Wall should have 0 fields");
    }

  }

  @Test
  public void testNumMethods() {
    if (!MasterTester7.hasNumMethods(this.c, 0)) {
      Assert.fail("Wall should have 0 methods");
    }

  }
}