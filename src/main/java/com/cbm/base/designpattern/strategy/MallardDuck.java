package com.cbm.base.designpattern.strategy;

import com.cbm.base.designpattern.strategy.impl.FlyWithWings;
import com.cbm.base.designpattern.strategy.impl.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {
		this.flyBehavior = new FlyWithWings();
		this.quackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}

}
