package com.cbm.base.barcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class BarCodeUtil {

	/**
	 * 使用zxing生成二维码
	 * 
	 * @param content
	 * @param directory
	 * @param imgName
	 */
	public static void generateByZxing(String content, String directory, String imgName) {
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "png";

		// 设置二维码的参数
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			// 生成二维码
			File outputFile = new File(directory + File.separator + imgName + ".png");
			MatrixToImageWriter.writeToPath(bitMatrix, format, outputFile.toPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用zxing解析二维码
	 * 
	 * @param imgPath
	 * @return
	 */
	public static String parseByZxing(String imgPath) {
		String parseContent = null;
		try {
			MultiFormatReader formatReader = new MultiFormatReader();

			File file = new File(imgPath);
			if (!file.exists()) {
				return null;
			}

			BufferedImage image = ImageIO.read(file);

			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

			Result result = formatReader.decode(binaryBitmap, hints);

			System.out.println("二维码格式类型 = " + result.getBarcodeFormat());
			System.out.println("二维码文本内容 = " + result.getText());
			parseContent = result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parseContent;
	}

	/**
	 * 使用qrcode生成二维码
	 * 
	 * @param content
	 * @param directory
	 * @param imgName
	 */
	public static void generateByQrcode(String content, String directory, String imgName) {
		try {
			Qrcode qrcodeHandler = new Qrcode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			// N代表数字,A代表字符a-Z,B代表其他字符
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 版本1为21*21矩阵，版本每增1，二维码的两个边长都增4；所以版本7为45*45的矩阵；最高版本为是40，是177*177的矩阵
			int version = 5;
			qrcodeHandler.setQrcodeVersion(version);
			int imgSize = 67 + 12 * (version - 1);

			byte[] contentBytes = content.getBytes("UTF-8");

			BufferedImage bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();

			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize);

			// 设定图像颜色 > BLACK
			gs.setColor(Color.BLACK);

			// 设置偏移量 不设置可能导致解析出错
			int pixoff = 2;
			// 输出内容 -> 二维码
			System.out.println(contentBytes.length);
			if (contentBytes.length > 0 && contentBytes.length < 130) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,130 ].");
			}

			gs.dispose();
			bufImg.flush();

			File imgFile = new File(directory + File.separator + imgName);

			// 生成二维码QRCode图片
			ImageIO.write(bufImg, "png", imgFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用qrcode解析二维码
	 * 
	 * @param imgPath
	 * @return
	 */
	public static String parseByQrcode(String imgPath) {
		// QRCode 二维码图片的文件  
        File imageFile = new File(imgPath);  
  
        BufferedImage bufImg = null;  
        String decodedData = null;  
        try {  
            bufImg = ImageIO.read(imageFile);  
  
            QRCodeDecoder decoder = new QRCodeDecoder();  
            decodedData = new String(decoder.decode(new MyQRCodeImage(bufImg)),"UTF-8");  
  
        } catch (Exception e) {  
            System.out.println("Error: " + e.getMessage());  
            e.printStackTrace();  
        } 
        return decodedData;
	}

}
