package com.cbm.base.designpattern.strategy.impl;

import com.cbm.base.designpattern.strategy.QuackBehavior;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Squeak");
	}

}
