/**
 * @Title: ReflectTestClass.java
 * @Package com.cbm.base.reflect
 * @Description: TODO(用一句话描述该文件做什么)
 * @author byron
 * @date 2017年4月26日
 * @version V1.0
 */
package com.cbm.base.reflect;

import java.io.Serializable;

/**
 * @ClassName: ReflectTestClass
 * @Description: 反射实验类
 * @author byron
 * @date 2017年4月26日
 *
 */
public class ReflectTestClass extends ReflectSuperClass implements ReflectInterface, Serializable {
    
    private static final long serialVersionUID = -4133025678918571472L;

    char ch;
    
    public int sum;
    
    private String app;
    
    protected long length;
    
    public static final String MONTH = "JAN";
    
    private String[] MONTHS = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JULY", "AUG", "SEP", "OCT", "NOV", "DEC"};
    
    /**
     * 构造方法
     */
    public ReflectTestClass() {
        
    }
    
    public ReflectTestClass(int sum, String app) {
        this.sum = sum;
        this.app = app;
    }
    
    public ReflectTestClass(int sum) {
        this.sum = sum;
    }
    
    public static int getTotal() {
        return 100;
    }
    
    public String getFullName(String first, String last) {
        return first + " " + last;
    }
    public String getFullName(String[] names) {
        return names[0] + " " + names[1];
    }
    
    public String getGrade(int[] grades) throws Exception {
        return gradesToString(grades[0]) + "-" + grades[1];
    }
    
    private String gradesToString(int grade) {
        String temp = "00000" + grade;
        return temp.substring(temp.length() - 5);
    }
    
    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    @Override
    public String monthNumToString(int month) {
        return MONTHS[month-1];
    }
}
