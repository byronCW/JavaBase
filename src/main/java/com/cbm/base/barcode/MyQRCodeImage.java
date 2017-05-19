package com.cbm.base.barcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class MyQRCodeImage implements QRCodeImage {

	BufferedImage bufImg;

	public MyQRCodeImage(BufferedImage bufImg) {
		this.bufImg = bufImg;
	}

	public int getWidth() {
		return bufImg.getWidth();
	}

	public int getHeight() {
		return bufImg.getHeight();
	}

	public int getPixel(int x, int y) {
		return bufImg.getRGB(x, y);
	}

}
