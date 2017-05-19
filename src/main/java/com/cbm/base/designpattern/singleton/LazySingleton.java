package com.cbm.base.designpattern.singleton;

public class LazySingleton {

	private static LazySingleton instance = null;

	private LazySingleton() {

	}

	public static LazySingleton getInstance() {
		// 使用的时候去检测是否已经初始化
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
