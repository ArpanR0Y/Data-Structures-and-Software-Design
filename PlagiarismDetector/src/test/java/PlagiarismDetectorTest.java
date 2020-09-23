import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class PlagiarismDetectorTest {
  public PlagiarismDetectorTest() {
  }

  public static void main(String[] var0) {
    if (var0.length == 0) {
      System.out.println("Please specify the name of the directory containing the corpus.");
      System.exit(0);
    }

    String var1 = var0[0];
    Map var2 = null;

    try {
      var2 = PlagiarismDetector.detectPlagiarism(var1, 4, 5);
    } catch (Exception var9) {
      System.out.println("INCORRECT OUTPUT: detectPlagiarism throws " + var9.toString() + " when windowSize = 4 and threshold = 5");
      System.exit(1);
    }

    if (var2 == null) {
      System.out.println("INCORRECT OUTPUT: Map returned by detectPlagiarism is null when windowSize = 4 and threshold = 5");
      System.exit(1);
    }

    Set var3 = var2.entrySet();
    if (var3.size() != 4) {
      System.out.println("INCORRECT OUTPUT: Map returned by detectPlagiarism has incorrect number of entries; should return Map with four elements when windowSize = 4 and threshold = 5");
      System.exit(1);
    }

    int var4 = 0;

    for(Iterator var5 = var3.iterator(); var5.hasNext(); ++var4) {
      Entry var6 = (Entry)var5.next();
      String var7 = (String)var6.getKey();
      if (var7 == null) {
        System.out.println("INCORRECT OUTPUT: Key in Map returned by detectPlagiarism is null when windowSize = 4 and threshold = 5");
        System.exit(1);
      }

      int var8 = (Integer)var6.getValue();
      if (var4 == 0) {
        if (!var7.contains("bwa242.txt") || !var7.contains("sra42.txt") || var8 != 10) {
          System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map; first match should be bwa242.txt-sra42.txt with value 10 when windowSize = 4 and theshold = 5");
          System.exit(1);
        }
      } else if (var4 == 1) {
        if (!var7.contains("bwa242.txt") || !var7.contains("bwa249.txt") || var8 != 8) {
          System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map; second match should be bwa242.txt-bwa249.txt with value 8 when windowSize = 4 and theshold = 5");
          System.exit(1);
        }
      } else if (var4 == 2) {
        if (!var7.contains("edo20.txt") || !var7.contains("edo26.txt") || var8 != 7) {
          System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map; third match should be edo20.txt-edo26.txt with value 7 when windowSize = 4 and theshold = 5");
          System.exit(1);
        }
      } else if (var4 == 3 && (!var7.contains("bwa242.txt") || !var7.contains("ecu201.txt") || var8 != 6)) {
        System.out.println("INCORRECT OUTPUT: incorrect key/value pair in Map; fourth match should be bwa242.txt-ecu201.txt with value 6 when windowSize = 4 and threshold = 5");
        System.exit(1);
      }
    }

    System.out.println("SUCCESS");
  }
}