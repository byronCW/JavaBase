/**
 * @Title: InputStreamTest.java
 * @Package com.cbm.base.io
 * @Description: TODO(用一句话描述该文件做什么)
 * @author byron
 * @date 2017年4月25日
 * @version V1.0
 */
package com.cbm.base.io;

import java.io.ByteArrayInputStream;

/**
 * @ClassName: InputStreamTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author byron
 * @date 2017年4月25日
 *
 */
public class InputStreamTest {
    
    public static void main(String[] args) {
        readByteArray();
    }
    
    public static void readByteArray() {
        byte[] names = {'a', 'b', 'c', 'd'};
        ByteArrayInputStream bais = new ByteArrayInputStream(names);
        int b = -1;
        while((b = bais.read()) != -1){
            System.out.println((char)b);
        };
    }

}
