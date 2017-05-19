package com.cbm.base.designpattern.strategy.impl;

import com.cbm.base.designpattern.strategy.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}

}
