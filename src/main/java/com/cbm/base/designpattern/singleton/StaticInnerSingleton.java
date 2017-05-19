package com.cbm.base.designpattern.singleton;

public class StaticInnerSingleton {

	private static class Holder {
		private static StaticInnerSingleton singleton = new StaticInnerSingleton();
	}

	private StaticInnerSingleton() {
	}

	public static StaticInnerSingleton getSingleton() {
		return Holder.singleton;
	}
}
