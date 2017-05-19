package com.cbm.base.designpattern.strategy.impl;

import com.cbm.base.designpattern.strategy.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly");
	}

}
