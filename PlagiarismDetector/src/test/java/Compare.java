import java.io.File;
import java.util.Scanner;

public class Compare {
  private static final double THRESHOLD = 40.0D;

  public Compare() {
  }

  public static void main(String[] var0) {
    String var1 = var0[0];
    String var2 = var0[1];
    String var3 = var0[2];

    try {
      Scanner var4 = new Scanner(new File(var3));

      String var5;
      for(var5 = null; var4.hasNext(); var5 = var4.nextLine()) {
      }

      if (var5 == null || !var5.equals("SUCCESS")) {
        System.out.println("Output of PlagiarismDetector is incorrect. You must fix this before submitting.");
        System.exit(1);
      }

      var4 = new Scanner(new File(var1));

      for(var5 = null; var4.hasNext(); var5 = var4.nextLine()) {
      }

      String var6 = new String(var5);

      for(var4 = new Scanner(new File(var2)); var4.hasNext(); var5 = var4.nextLine()) {
      }

      String var7 = new String(var5);
      String var8 = var6.trim().split("\t")[1];
      String var9 = var7.trim().split("\t")[1];
      double var10 = convertToSeconds(var8);
      double var12 = convertToSeconds(var9);
      double var14 = var10 / var12 * 100.0D;
      if (var14 < 40.0D) {
        System.out.println("The improvement is " + (int)var14 + "% of the baseline time, which is sufficient for this assignment. Great job!");
      } else {
        int var16 = 100 - (int)(var14 - 40.0D) * 2;
        System.out.println("The execution time is " + (int)var14 + "% of the baseline; needs to be " + 40 + "% or lower. Your score would be " + var16);
      }
    } catch (Exception var17) {
      var17.printStackTrace();
    }

  }

  public static double convertToSeconds(String var0) {
    String var1 = var0.split("m")[0];
    String var2 = var0.split("m")[1];
    String var3 = var2.split("s")[0];
    return (double)(Integer.parseInt(var1) * 60) + Double.parseDouble(var3);
  }
}