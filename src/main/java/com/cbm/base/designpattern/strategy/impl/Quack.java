package com.cbm.base.designpattern.strategy.impl;

import com.cbm.base.designpattern.strategy.QuackBehavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack");
	}

}
