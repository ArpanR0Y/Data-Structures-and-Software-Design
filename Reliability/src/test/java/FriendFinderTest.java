import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FriendFinderTest {
  protected ClassesDataSource cds;
  protected StudentsDataSource sds;
  protected FriendFinder ff;

  public FriendFinderTest() {
  }

  @Before
  public void setUp() throws Exception {
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        return new ArrayList();
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        return new ArrayList();
      }
    };
  }

  @Test
  public void testNullClassesDataSource() {
    this.ff = new FriendFinder((ClassesDataSource)null, this.sds);

    try {
      this.ff.findClassmates(new Student("chris"));
      Assert.fail("findClassmates does not correctly handle situation in which ClasssesDataSource field is null");
    } catch (IllegalStateException var2) {
    } catch (Exception var3) {
      Assert.fail("findClassmates throws " + var3 + " when ClasssesDataSource field is null");
    }

  }

  @Test
  public void testNullStudentsDataSource() {
    this.ff = new FriendFinder(this.cds, (StudentsDataSource)null);

    try {
      this.ff.findClassmates(new Student("chris"));
      Assert.fail("findClassmates does not correctly handle situation in which StudentsDataSource field is null");
    } catch (IllegalStateException var2) {
    } catch (Exception var3) {
      Assert.fail("findClassmates throws " + var3 + " when StudentsDataSource field is null");
    }

  }

  @Test
  public void testNullInput() {
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      this.ff.findClassmates((Student)null);
      Assert.fail("findClassmates does not correctly handle situation in which input is null");
    } catch (IllegalArgumentException var2) {
    } catch (Exception var3) {
      Assert.fail("findClassmates throws " + var3 + " when input is null");
    }

  }

  @Test
  public void testNullInputStudentName() {
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      this.ff.findClassmates(new Student((String)null));
      Assert.fail("findClassmates does not correctly handle situation in which name of input Student is null");
    } catch (IllegalArgumentException var2) {
    } catch (Exception var3) {
      Assert.fail("findClassmates throws " + var3 + " when name of input Student is null");
    }

  }

  @Test
  public void testClassesDataSourceGetReturnsNull() {
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        return null;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      Set var1 = this.ff.findClassmates(new Student("chris"));
    } catch (Exception var2) {
      Assert.fail("findClassmates throws " + var2 + " when ClassesDataSource.get returns null for input name");
    }

  }

  @Test
  public void testStudentsDataSourceGetReturnsNull() {
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add("cis573");
        return var2;
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        return null;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      Set var1 = this.ff.findClassmates(new Student("chris"));
    } catch (Exception var2) {
      Assert.fail("findClassmates throws " + var2 + " when StudentsDataSource.get returns null");
    }

  }

  @Test
  public void testClassesDataSourceGetReturnsNullForOtherStudents() {
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        ArrayList var2 = new ArrayList();
        if (var1.equals("chris")) {
          var2.add("cis573");
          return var2;
        } else {
          return null;
        }
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add(new Student("swap"));
        return var2;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      Set var1 = this.ff.findClassmates(new Student("chris"));
    } catch (Exception var2) {
      Assert.fail("findClassmates throws " + var2 + " when ClassesDataSource.get returns null for some students");
    }

  }

  @Test
  public void testClassesDataSourceGetReturnsListContainingNull() {
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add("cis573");
        var2.add((Object)null);
        return var2;
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add(new Student("swap"));
        return var2;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      this.ff.findClassmates(new Student("chris"));
    } catch (Exception var2) {
      Assert.fail("findClassmates throws " + var2 + " when ClassesDataSource.get returns a List containing null");
    }

  }

  @Test
  public void testStudentsDataSourceGetReturnsListContainingNull() {
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add("cis573");
        return var2;
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add(new Student("swap"));
        var2.add((Object)null);
        return var2;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      this.ff.findClassmates(new Student("chris"));
    } catch (Exception var2) {
      Assert.fail("findClassmates throws " + var2 + " when StudentsDataSource.get returns a List containing null");
    }

  }

  @Test
  public void testStudentsDataSourceGetReturnsListContainingStudentWithNullName() {
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add("cis573");
        return var2;
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        ArrayList var2 = new ArrayList();
        var2.add(new Student("swap"));
        var2.add(new Student((String)null));
        return var2;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      this.ff.findClassmates(new Student("chris"));
    } catch (Exception var2) {
      Assert.fail("findClassmates throws " + var2 + " when StudentsDataSource.get returns a List containing a Student with name = null");
    }

  }

  @Test
  public void testOneOtherStudentTakingSameClassesAsMe() {
    String var1 = "Me";
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        ArrayList var2 = new ArrayList();
        if (var1.equals("Me")) {
          var2.add("CIS573");
          var2.add("CIS550");
        } else if (var1.equals("A")) {
          var2.add("CIS573");
          var2.add("CIS550");
        } else if (var1.equals("B")) {
          var2.add("CIS573");
          var2.add("CIS550");
        } else if (var1.equals("C")) {
          var2.add("CIS573");
        } else {
          var2.add("");
        }

        return var2;
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        ArrayList var2 = new ArrayList();
        if (var1.equals("CIS573")) {
          var2.add(new Student("Me"));
          var2.add(new Student("A"));
          var2.add(new Student("B"));
          var2.add(new Student("C"));
        } else if (var1.equals("CIS550")) {
          var2.add(new Student("Me"));
          var2.add(new Student("A"));
          var2.add(new Student("B"));
        } else {
          var2.add(new Student(""));
        }

        return var2;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      Set var2 = this.ff.findClassmates(new Student(var1));
      Assert.assertTrue("findClassmates returns List with incorrect number of classmates when there are two or more other students taking the same classes", var2.size() == 2);
      Assert.assertTrue("findClassmates returns List with incorrect classmate names when there are two or more other students taking the same classes", var2.contains("A"));
      Assert.assertTrue("findClassmates returns List with incorrect classmate names when there are two or more other students taking the same classes", var2.contains("B"));
    } catch (Exception var3) {
      Assert.fail("findClassmates throws " + var3 + " when there are two or more other students taking the same classes");
    }

  }

  @Test
  public void testTwoOtherStudentsTakingSameClassesAsMe() {
    String var1 = "Me";
    this.cds = new ClassesDataSource() {
      public List<String> getClasses(String var1) {
        ArrayList var2 = new ArrayList();
        if (var1.equals("Me")) {
          var2.add("CIS573");
          var2.add("CIS550");
        } else if (var1.equals("A")) {
          var2.add("CIS573");
          var2.add("CIS550");
        } else if (var1.equals("B")) {
          var2.add("CIS573");
        } else {
          var2.add("");
        }

        return var2;
      }
    };
    this.sds = new StudentsDataSource() {
      public List<Student> getStudents(String var1) {
        ArrayList var2 = new ArrayList();
        if (var1.equals("CIS573")) {
          var2.add(new Student("Me"));
          var2.add(new Student("A"));
          var2.add(new Student("B"));
        } else if (var1.equals("CIS550")) {
          var2.add(new Student("Me"));
          var2.add(new Student("A"));
        } else {
          var2.add(new Student(""));
        }

        return var2;
      }
    };
    this.ff = new FriendFinder(this.cds, this.sds);

    try {
      Set var2 = this.ff.findClassmates(new Student(var1));
      Assert.assertTrue("findClassmates returns List with incorrect number of classmates when there is exactly one other student taking the same classes", var2.size() == 1);
      Assert.assertTrue("findClassmates returns List with incorrect classmate names when there is exactly one other student taking the same classes", var2.contains("A"));
    } catch (Exception var3) {
      Assert.fail("findClassmates throws " + var3 + " when there is exactly one other student taking the same classes");
    }

  }
}