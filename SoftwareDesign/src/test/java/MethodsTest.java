import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MethodsTest {
  protected Class<?> dataTierClass;
  protected Class<?> logicTierClass;
  protected Class<?> presentationTierClass;

  public MethodsTest() {
  }

  @Before
  public void setUp() throws Exception {
    try {
      this.dataTierClass = Class.forName("DataTier");
    } catch (ClassNotFoundException var4) {
      throw new Exception("Class DataTier does not exist");
    }

    try {
      this.logicTierClass = Class.forName("LogicTier");
    } catch (ClassNotFoundException var3) {
      throw new Exception("Class LogicTier does not exist");
    }

    try {
      this.presentationTierClass = Class.forName("PresentationTier");
    } catch (ClassNotFoundException var2) {
      throw new Exception("Class PresentationTier does not exist");
    }
  }

  @Test
  public void testFindBookTitlesByAuthorClass() {
    if (!MasterTester8.hasMethod(this.logicTierClass, "findBookTitlesByAuthor")) {
      Assert.fail("findBookTitlesByAuthor method is not implemented in correct class");
    } else if (MasterTester8.hasMethod(this.dataTierClass, "findBookTitlesByAuthor")) {
      Assert.fail("findBookTitlesByAuthor method is implemented in incorrect class");
    } else if (MasterTester8.hasMethod(this.presentationTierClass, "findBookTitlesByAuthor")) {
      Assert.fail("findBookTitlesByAuthor method is implemented in incorrect class");
    }

  }

  protected Class<?> determineClassForMethod(String var1) {
    Class var2 = null;
    if (MasterTester8.hasMethod(this.dataTierClass, var1)) {
      var2 = this.dataTierClass;
    } else if (MasterTester8.hasMethod(this.logicTierClass, var1)) {
      var2 = this.logicTierClass;
    } else if (MasterTester8.hasMethod(this.presentationTierClass, var1)) {
      var2 = this.presentationTierClass;
    }

    return var2;
  }

  @Test
  public void testFindBookTitlesByAuthorReturnType() {
    Class var1 = this.determineClassForMethod("findBookTitlesByAuthor");
    if (var1 == null) {
      Assert.fail("No class implements findBookTitlesByAuthor.");
    }

    Method[] var2 = var1.getDeclaredMethods();
    int var3 = var2.length;

    for(int var4 = 0; var4 < var3; ++var4) {
      Method var5 = var2[var4];
      if (var5.getName().equals("findBookTitlesByAuthor")) {
        if (var5.getGenericReturnType() instanceof ParameterizedType) {
          Type[] var6 = ((ParameterizedType)var5.getGenericReturnType()).getActualTypeArguments();
          if (!var6[0].getTypeName().equals("java.lang.String")) {
            Assert.fail("findBookTitlesByAuthor returns Collection of incorrect type");
          }
        } else if (!var5.getReturnType().getName().equals("[Ljava.lang.String;")) {
          Assert.fail("findBookTitlesByAuthor should return Collection or array of correct type");
        }
      }
    }

  }

  @Test
  public void testGetAllBooksReturnType() {
    Class var1 = this.determineClassForMethod("getAllBooks");
    if (var1 == null) {
      Assert.fail("No class implements getAllBooks.");
    }

    Method[] var2 = var1.getDeclaredMethods();
    int var3 = var2.length;

    for(int var4 = 0; var4 < var3; ++var4) {
      Method var5 = var2[var4];
      if (var5.getName().equals("getAllBooks")) {
        if (var5.getGenericReturnType() instanceof ParameterizedType) {
          String var6 = var5.getReturnType().getName();
          if (!var6.equals("java.util.List") && !var6.equals("java.util.Set") && !var6.equals("java.util.Collection")) {
            Assert.fail("getAllBooks should return generic List, Set, or Collection");
          }

          Type[] var7 = ((ParameterizedType)var5.getGenericReturnType()).getActualTypeArguments();
          if (!var7[0].getTypeName().equals("Book")) {
            Assert.fail("getAllBooks returns Collection of incorrect type");
          }
        } else if (!var5.getReturnType().getName().equals("[LBook;")) {
          Assert.fail("getAllBooks should return Collection or array of correct type");
        }
      }
    }

  }

  @Test
  public void testFindNumberOfBooksInYearClass() {
    if (!MasterTester8.hasMethod(this.logicTierClass, "findNumberOfBooksInYear")) {
      Assert.fail("findNumberOfBooksInYear method is not implemented in correct class");
    } else if (MasterTester8.hasMethod(this.dataTierClass, "findNumberOfBooksInYear")) {
      Assert.fail("findNumberOfBooksInYear method is implemented in incorrect class");
    } else if (MasterTester8.hasMethod(this.presentationTierClass, "findNumberOfBooksInYear")) {
      Assert.fail("findNumberOfBooksInYear method is implemented in incorrect class");
    }

  }

  @Test
  public void testGetAllBooksClass() {
    if (!MasterTester8.hasMethod(this.dataTierClass, "getAllBooks")) {
      Assert.fail("getAllBooks method is not implemented in correct class");
    } else if (MasterTester8.hasMethod(this.logicTierClass, "getAllBooks")) {
      Assert.fail("getAllBooks method is implemented in incorrect class");
    } else if (MasterTester8.hasMethod(this.presentationTierClass, "getAllBooks")) {
      Assert.fail("getAllBooks method is implemented in incorrect class");
    }

  }

  @Test
  public void testShowBookTitlesByAuthorClass() {
    if (!MasterTester8.hasMethod(this.presentationTierClass, "showBookTitlesByAuthor")) {
      Assert.fail("showBookTitlesByAuthor method is not implemented in correct class");
    } else if (MasterTester8.hasMethod(this.logicTierClass, "showBookTitlesByAuthor")) {
      Assert.fail("showBookTitlesByAuthor method is implemented in incorrect class");
    } else if (MasterTester8.hasMethod(this.dataTierClass, "showBookTitlesByAuthor")) {
      Assert.fail("showBookTitlesByAuthor method is implemented in incorrect class");
    }

  }

  @Test
  public void testShowNumberOfBooksInYearClass() {
    if (!MasterTester8.hasMethod(this.presentationTierClass, "showNumberOfBooksInYear")) {
      Assert.fail("showNumberOfBooksInYear method is not implemented in correct class");
    } else if (MasterTester8.hasMethod(this.logicTierClass, "showNumberOfBooksInYear")) {
      Assert.fail("showNumberOfBooksInYear method is implemented in incorrect class");
    } else if (MasterTester8.hasMethod(this.dataTierClass, "showNumberOfBooksInYear")) {
      Assert.fail("showNumberOfBooksInYear method is implemented in incorrect class");
    }

  }
}