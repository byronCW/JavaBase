/**
 * @Title: UserDao.java
 * @Package com.cbm.base.reflect.proxy
 * @Description: TODO(用一句话描述该文件做什么)
 * @author byron
 * @date 2017年4月27日
 * @version V1.0
 */
package com.cbm.base.reflect.proxy;

/**
 * @ClassName: UserDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author byron
 * @date 2017年4月27日
 *
 */
public class UserDao implements IUserDao {

    public void save() {
        System.out.println("Save");

    }

}
