import java.io.File;
import java.util.Scanner;

public class PrintTime {
  public PrintTime() {
  }

  public static void main(String[] var0) {
    String var1 = var0[0];

    try {
      Scanner var2 = new Scanner(new File(var1));

      String var3;
      for(var3 = null; var2.hasNext(); var3 = var2.nextLine()) {
      }

      String var4 = new String(var3);
      String var5 = var4.trim().split("\t")[1];
      System.out.format("Spent %.3f seconds on CPU\n", convertToSeconds(var5));
    } catch (Exception var6) {
      var6.printStackTrace();
    }

  }

  public static double convertToSeconds(String var0) {
    String var1 = var0.split("m")[0];
    String var2 = var0.split("m")[1];
    String var3 = var2.split("s")[0];
    return (double)(Integer.parseInt(var1) * 60) + Double.parseDouble(var3);
  }
}