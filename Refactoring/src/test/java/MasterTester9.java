import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class MasterTester9 {
  public MasterTester9() {
  }

  public static boolean hasSuperClass(Class<?> var0, String var1) {
    return var0.getSuperclass().getSimpleName().equals(var1);
  }

  public static boolean isAbstract(Class<?> var0) {
    return Modifier.isAbstract(var0.getModifiers());
  }

  public static boolean hasFieldType(Class<?> var0, String var1) {
    Field[] var2 = var0.getDeclaredFields();
    Field[] var3 = var2;
    int var4 = var2.length;

    for(int var5 = 0; var5 < var4; ++var5) {
      Field var6 = var3[var5];
      if (var6.getType().getSimpleName().equals(var1)) {
        return true;
      }
    }

    return false;
  }

  public static boolean hasFieldName(Class<?> var0, String var1) {
    Field[] var2 = var0.getDeclaredFields();
    Field[] var3 = var2;
    int var4 = var2.length;

    for(int var5 = 0; var5 < var4; ++var5) {
      Field var6 = var3[var5];
      if (var6.getName().equals(var1)) {
        return true;
      }
    }

    return false;
  }

  public static boolean hasPrivateField(Class<?> var0, String var1, String var2) {
    Field[] var3 = var0.getDeclaredFields();
    Field[] var4 = var3;
    int var5 = var3.length;

    for(int var6 = 0; var6 < var5; ++var6) {
      Field var7 = var4[var6];
      if (var7.getName().equals(var2)) {
        if (!var7.getType().getSimpleName().equals(var1)) {
          return false;
        }

        if (!Modifier.isPrivate(var7.getModifiers())) {
          return false;
        }

        return true;
      }
    }

    return false;
  }

  public static boolean hasNumberOfFieldType(Class<?> var0, String var1, int var2) {
    int var3 = 0;
    Field[] var4 = var0.getDeclaredFields();
    Field[] var5 = var4;
    int var6 = var4.length;

    for(int var7 = 0; var7 < var6; ++var7) {
      Field var8 = var5[var7];
      if (var8.getType().getSimpleName().equals(var1)) {
        ++var3;
      }
    }

    return var3 == var2;
  }

  public static boolean hasMethod(Class<?> var0, String var1, Class<?> var2, Class<?> var3) {
    if (var2 == null) {
      Method[] var10 = var0.getDeclaredMethods();
      Method[] var5 = var10;
      int var6 = var10.length;

      for(int var7 = 0; var7 < var6; ++var7) {
        Method var8 = var5[var7];
        if (var8.getName().equals(var1)) {
          return true;
        }
      }

      return false;
    } else {
      try {
        Method var4 = var0.getDeclaredMethod(var1, var2);
        return var4.getReturnType().equals(var3);
      } catch (NoSuchMethodException var9) {
        return false;
      }
    }
  }

  public static boolean hasNumFields(Class<?> var0, int var1) {
    return var0.getDeclaredFields().length == var1;
  }

  public boolean implementsInterfaces(Class<?> var1, List<String> var2) {
    Class[] var3 = var1.getInterfaces();
    int var4 = 0;
    Class[] var5 = var3;
    int var6 = var3.length;

    for(int var7 = 0; var7 < var6; ++var7) {
      Class var8 = var5[var7];
      if (!var2.contains(var8.getSimpleName())) {
        return false;
      }

      ++var4;
    }

    return var2.size() == var4;
  }
}