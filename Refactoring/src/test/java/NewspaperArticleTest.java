import java.util.Date;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewspaperArticleTest {
  Class<?> c;

  public NewspaperArticleTest() {
  }

  @Before
  public void setUp() throws Exception {
    try {
      this.c = Class.forName("NewspaperArticle");
    } catch (ClassNotFoundException var2) {
      throw new Exception("Class NewspaperArticle does not exist");
    }
  }

  @Test
  public void testSuperClass() {
    if (!MasterTester9.hasSuperClass(this.c, "Document")) {
      Assert.fail("NewspaperArticle should extend Document");
    }

  }

  @Test
  public void testAbstract() {
    if (MasterTester9.isAbstract(this.c)) {
      Assert.fail("NewspaperArticle should not be abstract");
    }

  }

  @Test
  public void testNumFields() {
    if (!MasterTester9.hasNumFields(this.c, 4)) {
      Assert.fail("NewspaperArticle should have 4 fields");
    }

  }

  @Test
  public void testNewspaperFieldName() {
    if (!MasterTester9.hasPrivateField(this.c, "String", "newspaper")) {
      Assert.fail("NewspaperArticle should have a private String field named newspaper");
    }

  }

  @Test
  public void testStartPageField() {
    if (!MasterTester9.hasPrivateField(this.c, "int", "startPage")) {
      Assert.fail("NewspaperArticle should have private int field named startPage");
    }

  }

  @Test
  public void testEndPageField() {
    if (!MasterTester9.hasPrivateField(this.c, "int", "endPage")) {
      Assert.fail("NewspaperArticle should have private int field named endPage");
    }

  }

  @Test
  public void testEditorsField() {
    if (!MasterTester9.hasPrivateField(this.c, "Set", "editors")) {
      Assert.fail("NewspaperArticle should have private Set field named editors");
    }

  }

  @Test
  public void testGetStartPageMethod() {
    if (!MasterTester9.hasMethod(this.c, "getStartPage", (Class)null, Integer.TYPE)) {
      Assert.fail("NewspaperArticle should have getStartPage method");
    }

  }

  @Test
  public void testGetEndPageMethod() {
    if (!MasterTester9.hasMethod(this.c, "getEndPage", (Class)null, Integer.TYPE)) {
      Assert.fail("NewspaperArticle should have getEndPage method");
    }

  }

  @Test
  public void testNumPagesMethod() {
    if (!MasterTester9.hasMethod(this.c, "numPages", (Class)null, Integer.TYPE)) {
      Assert.fail("NewspaperArticle should have method called numPages with 0 parameters that returns int");
    }

  }

  @Test
  public void testGetEditorsMethod() {
    if (!MasterTester9.hasMethod(this.c, "getEditors", (Class)null, Set.class)) {
      Assert.fail("NewspaperArticle should have getEditors method");
    }

  }

  @Test
  public void testSameNewspaperMethod() {
    if (!MasterTester9.hasMethod(this.c, "sameNewspaper", NewspaperArticle.class, Boolean.TYPE)) {
      Assert.fail("NewspaperArticle should have method called sameNewspaper with a NewspaperArticle parameter that returns boolean");
    }

  }

  @Test
  public void testGetNewspaperMethod() {
    if (!MasterTester9.hasMethod(this.c, "getNewspaper", (Class)null, String.class)) {
      Assert.fail("NewspaperArticle should have a getNewspaper method");
    }

  }

  @Test
  public void testCommonEditorsMethod() {
    if (!MasterTester9.hasMethod(this.c, "commonEditors", NewspaperArticle.class, Set.class)) {
      Assert.fail("NewspaperArticle should have method called commonEditors with NewspaperArticle parameter that returns Set");
    }

  }

  @Test
  public void testNumEditorsMethod() {
    if (!MasterTester9.hasMethod(this.c, "numEditors", (Class)null, Integer.TYPE)) {
      Assert.fail("NewspaperArticle should have numEditors method");
    }

  }

  @Test
  public void testGetTitleMethod() {
    if (MasterTester9.hasMethod(this.c, "getTitle", (Class)null, String.class)) {
      Assert.fail("NewspaperArticle should not have getTitle method");
    }

  }

  @Test
  public void testGetAuthorMethod() {
    if (MasterTester9.hasMethod(this.c, "getAuthor", (Class)null, String.class)) {
      Assert.fail("NewspaperArticle should not have getAuthor method");
    }

  }

  @Test
  public void testGetDateMethod() {
    if (MasterTester9.hasMethod(this.c, "getDate", (Class)null, Date.class)) {
      Assert.fail("NewspaperArticle should not have getDate method");
    }

  }

  @Test
  public void testCompareDatesMethod() {
    if (MasterTester9.hasMethod(this.c, "compareDates", Document.class, Integer.TYPE)) {
      Assert.fail("NewspaperArticle should not have compareDates method");
    }

  }

  @Test
  public void testCompareWithGeneralDateMethod() {
    if (MasterTester9.hasMethod(this.c, "compareWithGeneralDate", Date.class, Integer.TYPE)) {
      Assert.fail("NewspaperArticle should not have compareWithGeneralDate method");
    }

  }

  @Test
  public void testSameAuthorMethod() {
    if (MasterTester9.hasMethod(this.c, "sameAuthor", Document.class, Boolean.TYPE)) {
      Assert.fail("NewspaperArticle should not have sameAuthor method");
    }

  }
}