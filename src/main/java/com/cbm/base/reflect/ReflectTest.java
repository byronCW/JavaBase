/**
 * @Title: ReflectTest.java
 * @Package com.cbm.base.reflect
 * @Description: 反射测试类
 * @author byron
 * @date 2017年4月26日
 * @version V1.0
 */
package com.cbm.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * @ClassName: ReflectTest
 * @Description: 反射测试类
 * @author byron
 * @date 2017年4月26日
 *
 */
public class ReflectTest {

    /**
     * @Description: 获取反射Class类的三种方法
     * @throws Exception  参数
     * @return void    返回类型
     * @throws
     */
    @Test
    public void testReflect() throws Exception {
        
        Class<?> clazz1 = ReflectTestClass.class;
        System.out.println(clazz1.getName());
        
        Class<?> clazz2 = Class.forName("com.cbm.base.reflect.ReflectTestClass");
        System.out.println(clazz2.getSimpleName());
        
        Class<?> clazz3 = new ReflectTestClass().getClass();
        System.out.println(clazz3.getName());
    }
    
    /**
     * 
     * @Description: 通过反射获取父类及实现的接口
     * @return void    返回类型
     * @throws
     */
    @Test
    public void testSuperAndInterface() {
        Class<?> clazz = ReflectTestClass.class;
        
        Class<?> superCls = clazz.getSuperclass();
        System.out.println("SuperClass: " + superCls.getName());
        
        Class<?>[] interfaces = clazz.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("Interface: " + interfaces[i].getName());
        }
    }
    
    /**
     * 
     * @Description: 获取构造方法
     * @return void    返回类型
     * @throws
     */
    @Test
    public void testConstructor() {
        try {
            Class<?> clazz = ReflectTestClass.class;
            
            // 根据参数获取匹配的 public 构造参数
            Constructor<?> con1 = clazz.getConstructor();
            System.out.println("getConstructor(): " + con1);
            
            Constructor<?> con2 = clazz.getConstructor(int.class, String.class);
            System.out.println("\ngetConstructor(int.class, String.class): " + con2);
            
            // 获取所有 public 构造方法
            Constructor<?>[] cons1 = clazz.getConstructors();
            System.out.println("\ngetConstructors(): ");
            for (int i = 0; i < cons1.length; i++) {
                System.out.println(cons1[i]);
            }
            
            
            // 获取匹配参数的所有构造方法，包括public/private/protected
            Constructor<?> con3 = clazz.getDeclaredConstructor(int.class);
            System.out.println("\ngetDeclaredConstructor(int.class): " + con3);
            // 获取所有构造方法，包括public/private/protected
            Constructor<?>[] cons2 = clazz.getDeclaredConstructors();
            System.out.println("\ngetDeclaredConstructors(): ");
            for (int i = 0; i < cons1.length; i++) {
                System.out.println(cons2[i]);
            }
            
            
            // 如果这个类是“其它类的构造函数中的内部类”，调用getEnclosingConstructor()就是这个类所在的构造函数；若不存在，返回null。
            Constructor<?> con5 = clazz.getEnclosingConstructor();
            System.out.println("\ngetEnclosingConstructor: " + con5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * @Description: 获取类的属性
     * @return void    返回类型
     * @throws
     */
    @Test
    public void testField() {
        Class<?> clazz = ReflectTestClass.class;
        System.out.println("===============本类属性===============");
        // 取得本类的全部属性
        Field[] fieldSelf = clazz.getDeclaredFields();
        for (int i = 0; i < fieldSelf.length; i++) {
            // 权限修饰符
            int mo = fieldSelf[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = fieldSelf[i].getType();
            // 判断属性类型是否为数组
            String typeStr = type.isArray() ? type.getComponentType().getSimpleName() + "[]" : type.getSimpleName();
            System.out.println(priv + " " + typeStr + " " + fieldSelf[i].getName() + ";");
        }

        System.out.println("==========实现的接口或者父类的属性==========");
        // 取得当前类及其实现的接口和父类的 public 属性
        Field[] filedSuper = clazz.getFields();
        for (int j = 0; j < filedSuper.length; j++) {
            // 权限修饰符
            int mo = filedSuper[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filedSuper[j].getType();
            String typeStr = type.isArray() ? type.getComponentType().getSimpleName() + "[]" : type.getSimpleName();
            System.out.println(priv + " " + typeStr + " " + filedSuper[j].getName() + ";");
        }
    }
    
    @Test
    public void testFeild2() throws Exception {
        Class<?> clazz = ReflectTestClass.class;
        System.out.println(clazz.getField(""));
        System.out.println(clazz.getField(""));
        System.out.println(clazz.getField(""));
        System.out.println(clazz.getField(""));
    }
    
    @Test
    public void testAccessFeild() throws Exception {
        Class<?> clazz = ReflectTestClass.class;
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("app");
        // 改变private属性的访问控制
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));
        
        // 访问接口的属性
        int days = clazz.getField("DAYS_OF_WEEK").getInt(obj);
        System.out.println(days);
        
        // 访问对象及其父类和接口的所有 public 属性
        Field[] fs = clazz.getFields();
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fs[i]);
        }
        
        System.out.println();
        // 访问对象及其父类和接口的所有 public 属性
        Field[] dfs = clazz.getDeclaredFields();
        for (int i = 0; i < dfs.length; i++) {
            System.out.println(dfs[i]);
        }
    }
    
    /**
     * @Description: 获取方法
     * @return void    返回类型
     * @throws
     */
    @Test
    public void testMethod() {
        Class<?> clazz = ReflectTestClass.class;
        
        // 获取类自身的所有方法及继承自父类的所有public方法
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(getMethodDefine(methods[i]));
        }
        
        System.out.println("\ngetDeclaredMethods:");
        // 获取类自身的所有方法（包括public/private/protected/default），不包括继承的方法
        Method[] declareds = clazz.getDeclaredMethods();
        for (int i = 0; i < declareds.length; i++) {
            System.out.println(getMethodDefine(declareds[i]));
        }
        
    }
    
    private String getMethodDefine(Method m) {
        String defineStr = "";
        // 方法的修饰符，例如 private, public static
        String modifier = Modifier.toString(m.getModifiers());
        // 方法的返回值的类型
        String returnType = handleArrayType(m.getReturnType());
        // 方法名
        String methodName = m.getName();
        
        defineStr = modifier + " " + returnType + " " +  methodName + "(";
        
        // 方法参数
        Class<?>[] params = m.getParameterTypes();
        for (int i = 0; i < params.length; i++) {
            defineStr = defineStr + handleArrayType(params[i]) + " args" + i;
            if (i < params.length - 1) {
                defineStr += ", ";
            }
        }
        defineStr += ")";
        
        // 方法抛出的异常
        Class<?>[] exceptions = m.getExceptionTypes();
        if (exceptions.length > 0) {
            defineStr += " throws ";
            for (int i = 0; i < exceptions.length; i++) {
                defineStr += exceptions[i].getSimpleName();
                if (i < exceptions.length - 1) {
                    defineStr += ", ";
                }
            }
        }
        return defineStr;
    }
    
    /**
     * @Description: 判断类型是否为数组
     * @param clazz
     * @return String    返回类型
     * @throws
     */
    private String handleArrayType(Class<?> clazz) {
        return clazz.isArray() ? clazz.getComponentType() + "[]" : clazz.getSimpleName();
    }
    
    /**
     * 
     * @Description: 方法调用
     * @return void    返回类型
     * @throws
     */
    @Test
    public void testInvokeMethod() {
        Class<?> clazz = ReflectTestClass.class;
        
        try {
            Method method = clazz.getMethod("getFullName", String.class, String.class);
            String name = (String) method.invoke(clazz.newInstance(), "Byron", "King");
            System.out.println(name);
            
            String[] names = {"Byron", "King"};
            method = clazz.getMethod("getFullName", String[].class);
            // 此处调用必须以 new Object[]{names} 方式传参
            name = (String) method.invoke(clazz.newInstance(), new Object[]{names});
            System.out.println(name);
            
            // 基本类型的数组，可直接传入数组
            int[] grades = new int[]{35, 118};
            method = clazz.getMethod("getGrade", int[].class);
//            String grade = (String) method.invoke(clazz.newInstance(), new Object[]{grades});
            String grade = (String) method.invoke(clazz.newInstance(), grades);
            System.out.println(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    @Test
    public void testProxy() {
        
    }
}
