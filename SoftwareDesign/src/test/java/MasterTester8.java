import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class MasterTester8 {
  public MasterTester8() {
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

  public static boolean hasPublicField(Class<?> var0, String var1, String var2) {
    Field[] var3 = var0.getDeclaredFields();
    Field[] var4 = var3;
    int var5 = var3.length;

    for(int var6 = 0; var6 < var5; ++var6) {
      Field var7 = var4[var6];
      if (var7.getName().equals(var2)) {
        if (!var7.getType().getSimpleName().equals(var1)) {
          return false;
        }

        if (!Modifier.isPublic(var7.getModifiers())) {
          return false;
        }

        return true;
      }
    }

    return false;
  }

  public static boolean hasField(Class<?> var0, String var1, String var2) {
    Field[] var3 = var0.getDeclaredFields();
    Field[] var4 = var3;
    int var5 = var3.length;

    for(int var6 = 0; var6 < var5; ++var6) {
      Field var7 = var4[var6];
      if (var7.getName().equals(var2)) {
        if (!var7.getType().getSimpleName().equals(var1)) {
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

  public static boolean hasMethod(Class<?> var0, String var1) {
    Method[] var2 = var0.getDeclaredMethods();
    Method[] var3 = var2;
    int var4 = var2.length;

    for(int var5 = 0; var5 < var4; ++var5) {
      Method var6 = var3[var5];
      if (var6.getName().equals(var1)) {
        return true;
      }
    }

    return false;
  }

  public static boolean hasMethod(Class<?> var0, String var1, Class<?> var2, Class<?>... var3) {
    if (var3 == null) {
      Method[] var10 = var0.getDeclaredMethods();
      Method[] var5 = var10;
      int var6 = var10.length;

      for(int var7 = 0; var7 < var6; ++var7) {
        Method var8 = var5[var7];
        if (var8.getName().equals(var1) && var8.getReturnType().equals(var2)) {
          return true;
        }
      }

      return false;
    } else {
      try {
        Method var4 = var0.getDeclaredMethod(var1, var3);
        return var4.getReturnType().equals(var2);
      } catch (NoSuchMethodException var9) {
        return false;
      }
    }
  }

  public static boolean hasMethodReturnsCollection(Class<?> var0, String var1, String var2, String var3, Class<?>... var4) {
    try {
      Method var5 = var0.getDeclaredMethod(var1, var4);
      ParameterizedType var6 = (ParameterizedType)var5.getGenericReturnType();
      Type[] var7 = var6.getActualTypeArguments();
      Type[] var8 = var7;
      int var9 = var7.length;

      for(int var10 = 0; var10 < var9; ++var10) {
        Type var11 = var8[var10];
        if (var5.getReturnType().getName().equals(var2) && var11.getTypeName().equals(var3)) {
          return true;
        }
      }

      return false;
    } catch (NoSuchMethodException var12) {
      return false;
    }
  }

  public static boolean hasNumFields(Class<?> var0, int var1) {
    return var0.getDeclaredFields().length == var1;
  }

  public static boolean hasNumMethods(Class<?> var0, int var1) {
    return var0.getDeclaredMethods().length == var1;
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