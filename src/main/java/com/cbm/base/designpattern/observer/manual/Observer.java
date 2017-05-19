package com.cbm.base.designpattern.observer.manual;

/**
 * 观察者需要实现的接口
 * @author byron
 *
 */
public interface Observer {

	public void update(float temp, float humidity, float pressure);
	
}
