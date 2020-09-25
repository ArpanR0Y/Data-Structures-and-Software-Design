import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Baseline {
  public Baseline() {
  }

  public static Map<String, Integer> detectPlagiarism(String var0, int var1, int var2) {
    File var3 = new File(var0);
    String[] var4 = var3.list();
    HashMap var5 = new HashMap();

    for(int var6 = 0; var6 < var4.length; ++var6) {
      String var7 = var4[var6];

      for(int var8 = 0; var8 < var4.length; ++var8) {
        String var9 = var4[var8];
        Set var10 = createPhrases(var0 + "/" + var7, var1);
        Set var11 = createPhrases(var0 + "/" + var9, var1);
        if (var10 == null || var11 == null) {
          return null;
        }

        Set var12 = findMatches(var10, var11);
        if (var12 == null) {
          return null;
        }

        if (var12.size() > var2) {
          String var13 = var7 + "-" + var9;
          if (!var5.containsKey(var9 + "-" + var7) && !var7.equals(var9)) {
            var5.put(var13, var12.size());
          }
        }
      }
    }

    return sortResults(var5);
  }

  protected static List<String> readFile(String var0) {
    if (var0 == null) {
      return null;
    } else {
      LinkedList var1 = new LinkedList();

      try {
        Scanner var2 = new Scanner(new File(var0));

        while(var2.hasNext()) {
          var1.add(var2.next().replaceAll("[^a-zA-Z]", "").toUpperCase());
        }

        return var1;
      } catch (Exception var3) {
        var3.printStackTrace();
        return null;
      }
    }
  }

  protected static Set<String> createPhrases(String var0, int var1) {
    if (var0 != null && var1 >= 1) {
      List var2 = readFile(var0);
      HashSet var3 = new HashSet();

      for(int var4 = 0; var4 < var2.size() - var1 + 1; ++var4) {
        String var5 = "";

        for(int var6 = 0; var6 < var1; ++var6) {
          var5 = var5 + (String)var2.get(var4 + var6) + " ";
        }

        var3.add(var5);
      }

      return var3;
    } else {
      return null;
    }
  }

  protected static Set<String> findMatches(Set<String> var0, Set<String> var1) {
    HashSet var2 = new HashSet();
    if (var0 != null && var1 != null) {
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
        String var4 = (String)var3.next();
        Iterator var5 = var1.iterator();

        while(var5.hasNext()) {
          String var6 = (String)var5.next();
          if (var4.equalsIgnoreCase(var6)) {
            var2.add(var4);
          }
        }
      }
    }

    return var2;
  }

  protected static LinkedHashMap<String, Integer> sortResults(Map<String, Integer> var0) {
    HashMap var1 = new HashMap();
    Iterator var2 = var0.keySet().iterator();

    while(var2.hasNext()) {
      String var3 = (String)var2.next();
      var1.put(var3, var0.get(var3));
    }

    LinkedHashMap var8 = new LinkedHashMap();

    for(int var9 = 0; var9 < var1.size(); ++var9) {
      int var4 = 0;
      String var5 = null;
      Iterator var6 = var1.keySet().iterator();

      while(var6.hasNext()) {
        String var7 = (String)var6.next();
        if ((Integer)var1.get(var7) > var4) {
          var4 = (Integer)var1.get(var7);
          var5 = var7;
        }
      }

      var8.put(var5, var4);
      var1.put(var5, -1);
    }

    return var8;
  }

  public static void main(String[] var0) {
    if (var0.length == 0) {
      System.out.println("Please specify the name of the directory containing the corpus.");
      System.exit(0);
    }

    String var1 = var0[0];
    Map var2 = null;

    try {
      var2 = detectPlagiarism(var1, 4, 5);
    } catch (Exception var9) {
      System.out.println("INCORRECT OUTPUT: detectPlagiarism throws " + var9.toString());
      System.exit(1);
    }

    if (var2 == null) {
      System.out.println("INCORRECT OUTPUT: Map returned by detectPlagiarism is null");
      System.exit(1);
    }

    Set var3 = var2.entrySet();
    if (var3.size() != 4) {
      System.out.println("INCORRECT OUTPUT: Map returned by detectPlagiarism has incorrect number of entries");
      System.exit(1);
    }

    int var4 = 0;

    for(Iterator var5 = var3.iterator(); var5.hasNext(); ++var4) {
      Entry var6 = (Entry)var5.next();
      String var7 = (String)var6.getKey();
      if (var7 == null) {
        System.out.println("INCORRECT OUTPUT: Key in Map returned by detectPlagiarism is null");
        System.exit(1);
      }

      int var8 = (Integer)var6.getValue();
      if (var4 == 0) {
        if (!var7.equals("bwa242.txt-sra42.txt") || var8 != 10) {
          System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map");
          System.exit(1);
        }
      } else if (var4 == 1) {
        if (!var7.equals("bwa242.txt-bwa249.txt") || var8 != 8) {
          System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map");
          System.exit(1);
        }
      } else if (var4 == 2) {
        if (!var7.equals("edo20.txt-edo26.txt") || var8 != 7) {
          System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map");
          System.exit(1);
        }
      } else if (var4 == 3 && (!var7.equals("bwa242.txt-ecu201.txt") || var8 != 6)) {
        System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map");
        System.exit(1);
      }
    }

    System.out.println("SUCCESS");
  }
}