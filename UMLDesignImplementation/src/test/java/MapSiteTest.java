import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapSiteTest {
  Class<?> c;

  public MapSiteTest() {
  }

  @Before
  public void setUp() throws Exception {
    try {
      this.c = Class.forName("MapSite");
    } catch (ClassNotFoundException var2) {
      throw new Exception("Class MapSite does not exist");
    }
  }

  @Test
  public void testSuperClass() {
    if (!MasterTester7.hasSuperClass(this.c, "Object")) {
      Assert.fail("MapSite should not extend anything");
    }

  }

  @Test
  public void testAbstract() {
    if (!MasterTester7.isAbstract(this.c)) {
      Assert.fail("MapSite should be abstract class");
    }

  }

  @Test
  public void testNumFields() {
    if (!MasterTester7.hasNumFields(this.c, 0)) {
      Assert.fail("MapSite should not have any fields");
    }

  }

  @Test
  public void testNumMethods() {
    if (!MasterTester7.hasNumMethods(this.c, 1)) {
      Assert.fail("MapSite should have 1 method");
    }

  }

  @Test
  public void testEnterMethod() {
    if (!MasterTester7.hasMethod(this.c, "enter", Void.TYPE, new Class[0])) {
      Assert.fail("MapSite should have an \"enter\" method that accepts no parameters and returns void");
    }

  }
}