package com.cbm.base.barcode;

import java.io.File;

import org.junit.Test;

public class BarCodeTest {

	@Test
	public void testDir() {
		System.out.println(System.getProperty("user.dir"));
	}

	@Test
	public void testCreateByZxing() {
		String content = "Test for Zxing";
		String dir = System.getProperty("user.dir") + File.separator + "img";
		String name = "zxing-001";
		BarCodeUtil.generateByZxing(content, dir, name);
	}

	@Test
	public void testParseByZxing() {
		String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator + "zxing-001.png";
		String content = BarCodeUtil.parseByZxing(imgPath);
		System.out.println(content);
	}

}
