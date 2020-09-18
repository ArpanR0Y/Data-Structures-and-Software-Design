import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FunctionalityTest {
  protected Class<?> dataTierClass;
  protected Class<?> logicTierClass;
  protected Class<?> presentationTierClass;

  protected String projectPath = Paths.get(".").normalize().toAbsolutePath().toString();

  public FunctionalityTest() {
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
  public void testGetAllBooks() {
    Class var1 = this.determineClassForMethod("getAllBooks");
    if (var1 != this.dataTierClass) {
      Assert.fail("Could not determine the correctness of getAllBooks: it is not implemented in the correct class");
    }

    File var2 = new File(projectPath + "\\src\\test\\resources\\test.txt");
    if (!var2.exists()) {
      Assert.fail("Could not determine correctness of getAllBooks: please be sure that test.txt is in the project root directory or the directory where you started Java.");
    }

    try {
      Constructor var3 = var1.getConstructor(String.class);
      Object var4 = var3.newInstance(projectPath + "\\src\\test\\resources\\test.txt");
      Method[] var5 = var1.getDeclaredMethods();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
        Method var8 = var5[var7];
        if (var8.getName().equals("getAllBooks")) {
          Object var9 = null;
          String var10 = "Collection";
          if (Collection.class.isAssignableFrom(var8.getReturnType())) {
            Type[] var11 = ((ParameterizedType)var8.getGenericReturnType()).getActualTypeArguments();
            if (!var11[0].getTypeName().equals("Book")) {
              Assert.fail("Could not determine the correctness of getAllBooks: it returns a Collection of the incorrect type");
            }

            var9 = (Collection)var8.invoke(var4);
            if (var9 == null) {
              Assert.fail("Collection returned by getAllBooks is null.");
            }
          } else if (var8.getReturnType().getName().equals("[LBook;")) {
            Book[] var17 = (Book[])((Book[])var8.invoke(var4));
            if (var17 == null) {
              Assert.fail("Array returned by getAllBooks is null.");
            }

            var9 = new LinkedList();
            Book[] var12 = var17;
            int var13 = var17.length;

            for(int var14 = 0; var14 < var13; ++var14) {
              Book var15 = var12[var14];
              ((Collection)var9).add(var15);
            }

            var10 = "Array";
          } else {
            Assert.fail("Could not determine the correctness of getAllBooks: it should return a Collection or an array");
          }

          Book var18 = new Book("title1", "author1", 1);
          Book var19 = new Book("title2", "author2", 2);
          Book var20 = new Book("title 3", "author 3", 3);
          Assert.assertNotNull("getAllBooks returns null for valid input", var9);
          Assert.assertTrue(var10 + " returned by getAllBooks contains incorrect number of Books", ((Collection)var9).size() == 3);
          Assert.assertTrue(var10 + " returned by getAllBooks does not contain correct Book objects", ((Collection)var9).contains(var18));
          Assert.assertTrue(var10 + " returned by getAllBooks does not contain correct Book objects", ((Collection)var9).contains(var19));
          Assert.assertTrue(var10 + " returned by getAllBooks does not contain correct Book objects", ((Collection)var9).contains(var20));
        }
      }
    } catch (Exception var16) {
      var16.printStackTrace();
      Assert.fail("An error occurred in trying to test the correctness of getAllBooks: " + var16);
    }

  }

  protected static boolean isNumericType(Class<?> var0) {
    if (Number.class.isAssignableFrom(var0)) {
      return true;
    } else {
      String var1 = var0.getName();
      return var1.equals("int") || var1.equals("long") || var1.equals("short") || var1.equals("double") || var1.equals("float");
    }
  }

  @Test
  public void testFindNumberOfBooksInYear() {
    Class var1 = this.determineClassForMethod("findNumberOfBooksInYear");
    if (var1 != this.logicTierClass) {
      Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: it is not implemented in the correct class");
    }

    File var2 = new File(projectPath + "\\src\\test\\resources\\books.txt");
    if (!var2.exists()) {
      Assert.fail("Could not determine correctness of findNumberOfBooksInYear: please be sure that books.txt is in the project root directory or the directory where you started Java.");
    }

    try {
      Constructor var3 = var1.getConstructor(DataTier.class);
      DataTier var4 = new DataTier(projectPath + "\\src\\test\\resources\\books.txt");
      Object var5 = var3.newInstance(var4);
      Method[] var6 = var1.getDeclaredMethods();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
        Method var9 = var6[var8];
        if (var9.getName().equals("findNumberOfBooksInYear")) {
          Object var10 = null;
          Class[] var11 = var9.getParameterTypes();
          if (var11.length == 0) {
            Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: it should take a numeric parameter");
          }

          if (isNumericType(var11[0])) {
            var10 = new Integer(1999);
          } else if (var11[0].getName().equals("java.lang.String")) {
            var10 = "1999";
          } else {
            Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: it should take a numeric parameter");
          }

          if (isNumericType(var9.getReturnType())) {
            Number var12 = (Number)var9.invoke(var5, var10);
            Assert.assertTrue("findNumberOfBooksInYear returns incorrect value when using books.txt as input file", var12.intValue() == 3);
          } else {
            Assert.fail("Could not determine the correctness of findNumberOfBooksInYear: its return type should be numeric");
          }
        }
      }
    } catch (Exception var13) {
      Assert.fail("An error occurred in trying to test the correctness of findNumberOfBooksInYear: " + var13);
    }

  }

  @Test
  public void testFindBookTitlesByAuthor() {
    Class var1 = this.determineClassForMethod("findBookTitlesByAuthor");
    if (var1 != this.logicTierClass) {
      Assert.fail("Could not determine the correctness of findBookTitlesByAuthor: it is not implemented in the correct class");
    }

    File var2 = new File(projectPath + "\\src\\test\\resources\\books.txt");
    if (!var2.exists()) {
      Assert.fail("Could not determine correctness of findBookTitlesByAuthor: please be sure that books.txt is in the project root directory or the directory where you started Java.");
    }

    try {
      Constructor var3 = var1.getConstructor(DataTier.class);
      DataTier var4 = new DataTier(projectPath + "\\src\\test\\resources\\books.txt");
      Object var5 = var3.newInstance(var4);
      Method[] var6 = var1.getDeclaredMethods();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
        Method var9 = var6[var8];
        if (var9.getName().equals("findBookTitlesByAuthor")) {
          Object var10 = null;
          String var11 = "Collection";
          if (Collection.class.isAssignableFrom(var9.getReturnType())) {
            Type[] var12 = ((ParameterizedType)var9.getGenericReturnType()).getActualTypeArguments();
            if (!var12[0].getTypeName().equals("java.lang.String")) {
              Assert.fail("Could not determine the correctness of findBookTitlesByAuthor: it returns a Collection of the incorrect type");
            }

            var10 = (Collection)var9.invoke(var5, "Fielding");
            if (var10 == null) {
              Assert.fail("Collection returned by findBookTitlesByAuthor is null");
            }
          } else if (var9.getReturnType().getName().equals("[Ljava.lang.String;")) {
            String[] var18 = (String[])((String[])var9.invoke(var5, "Fielding"));
            if (var18 == null) {
              Assert.fail("Array returned by findBookTitlesByAuthor is null");
            }

            var10 = new LinkedList();
            String[] var13 = var18;
            int var14 = var18.length;

            for(int var15 = 0; var15 < var14; ++var15) {
              String var16 = var13[var15];
              ((Collection)var10).add(var16);
            }

            var11 = "Array";
          } else {
            Assert.fail("Could not determine the correctness of findBookTitlesByAuthor: it should return a Collection or an array");
          }

          Assert.assertTrue(var11 + " returned by findBookTitlesByAuthor contains incorrect number of book titles", ((Collection)var10).size() == 2);
          Assert.assertTrue(var11 + " returned by findBookTitlesByAuthor does not contain correct book titles", ((Collection)var10).contains("Bridget Jones: The Edge of Reason"));
          Assert.assertTrue(var11 + " returned by findBookTitlesByAuthor does not contain correct book titles", ((Collection)var10).contains("Bridget Jones's Diary:A Novel"));
        }
      }
    } catch (Exception var17) {
      Assert.fail("An error occurred in trying to test the correctness of findBookTitlesByAuthor: " + var17);
    }

  }
}