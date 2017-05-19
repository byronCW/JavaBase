/**
 * @Title: Pizza.java
 * @Package com.cbm.base.designpattern.factory
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 34991
 * @date 2016年12月14日
 * @version V1.0
 */
package com.cbm.base.designpattern.factory;

import java.util.ArrayList;

/**
 * @ClassName: Pizza
 * @Description: 产品的抽象类
 * @author 34991
 * @date 2016年12月14日
 *
 */
public abstract class Pizza {

	private String name;
	
	private String dough;
	
	private String sauce;
	
	private ArrayList<String> toppings = new ArrayList<>();
	
	public void prepare() {
		System.out.println("Prepare " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.print("Adiing toppings:");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println("  " + toppings.get(i));
		}
	}
	
	public void bake() {
		System.out.println("Bake 25 mins at 350.");
	}
	
	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices.");
	}
	
	public void box() {
		System.out.println("Box with white paper box.");
	}
}
