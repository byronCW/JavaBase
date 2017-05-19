package com.cbm.base.designpattern.singleton;

public class DoubleCheckSingleton {

	private static volatile DoubleCheckSingleton instance = null;

	private DoubleCheckSingleton() {

	}

	public static DoubleCheckSingleton getInstance() {
		// 两层校验才能确保单例
		if (instance == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}
}
