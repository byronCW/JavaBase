/**
 * @Title: ReflectSuperClass.java
 * @Package com.cbm.base.reflect
 * @Description: TODO(用一句话描述该文件做什么)
 * @author byron
 * @date 2017年4月26日
 * @version V1.0
 */
package com.cbm.base.reflect;

import java.util.ArrayList;

/**
 * @ClassName: ReflectSuperClass
 * @Description: 反射实验用到的父类
 * @author byron
 * @date 2017年4月26日
 *
 */
public class ReflectSuperClass {

    private int book;
    
    public ArrayList<String> bookNames;
    
    public String getBookName(int index) {
        return bookNames.get(index);
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }
}
