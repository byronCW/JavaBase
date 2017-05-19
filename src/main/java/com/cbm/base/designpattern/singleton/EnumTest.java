package com.cbm.base.designpattern.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnumTest {

	@Test
	public void testEnumSingleton() {
		EnumSingleton es = EnumSingleton.INSTANCE;
		System.out.println(es.getSomething());
		assertEquals(es.getSomething(), "String");
	}
}
