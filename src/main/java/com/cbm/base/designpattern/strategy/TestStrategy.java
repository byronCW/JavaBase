package com.cbm.base.designpattern.strategy;

import org.junit.Test;

/**
 * 策略模式定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户
 * @author byron
 *
 */
public class TestStrategy {
	
	@Test
	public void test() {
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
	}

}
