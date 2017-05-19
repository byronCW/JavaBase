package com.cbm.base.designpattern.strategy.impl;

import com.cbm.base.designpattern.strategy.FlyBehavior;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("I'm flying!");
	}

}
