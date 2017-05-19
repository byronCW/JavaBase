/**
 * @Title: ArrayListTest.java
 * @Package com.cbm.base.collection
 * @Description: TODO(用一句话描述该文件做什么)
 * @author byron
 * @date 2017年5月4日
 * @version V1.0
 */
package com.cbm.base.collection;

import java.util.ArrayList;

/**
 * @ClassName: ArrayListTest
 * @Description: 
 * @author byron
 * @date 2017年5月4日
 *
 */
public class ArrayListTest {

    public static void main(String[] args) {
        testEnsureCap();
    }
    
    private static void testEnsureCap() {
        ArrayList<String> list = new ArrayList<>();
        list.ensureCapacity(5);
        
        ArrayList<String> list2 = new ArrayList<>();
        list2.ensureCapacity(15);
    }
}
