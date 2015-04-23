package com.learn.android.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * MD5Util.java
 * @author JUN
 * 说明： MD5 工具类
 * 2015-4-13上午10:48:21
 */
public class MD5Util {

	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private static MessageDigest messageDigest = null;

	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String getFileMD5String(File file) {
		String ret = "";
		FileInputStream in = null;
		FileChannel ch = null;
		try {
			in = new FileInputStream(file);
			ch = in.getChannel();
			ByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
					file.length());
			messageDigest.update(byteBuffer);
			ret = bytesToHex(messageDigest.digest());
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ch != null) {
				try {
					ch.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	public static String getFileMD5String(String fileName) {
		return getFileMD5String(new File(fileName));
	}

	public static String getMD5String(String str) {

		return getMD5String(str.getBytes());
	}

	public static String getMD5String(byte[] bytes) {
		messageDigest.update(bytes);
		return bytesToHex(messageDigest.digest());
	}

	public static boolean checkPassword(String pwd, String md5) {
		return getMD5String(pwd).equalsIgnoreCase(md5);
	}

	public static boolean checkPassword(char[] pwd, String md5) {
		return checkPassword(new String(pwd), md5);

	}

	public static boolean checkFileMD5(File file, String md5) {
		return getFileMD5String(file).equalsIgnoreCase(md5);

	}

	public static boolean checkFileMD5(String fileName, String md5) {
		return checkFileMD5(new File(fileName), md5);

	}

	public static String bytesToHex(byte bytes[]) {
		return bytesToHex(bytes, 0, bytes.length);

	}

	public static String bytesToHex(byte bytes[], int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < start + end; i++) {
			sb.append(byteToHex(bytes[i]));
		}
		return sb.toString();

	}

	public static String byteToHex(byte bt) {
		return HEX_DIGITS[(bt & 0xf0) >> 4] + "" + HEX_DIGITS[bt & 0xf];

	}

	// 测试
	public static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		String md5 = getMD5String("123456");
		long end = System.currentTimeMillis();
//		System.out.println("MD5:\t" + md5 + "\nTime:\t" + (end - begin) + "ms");

	}

	/**
	 * 暴露md5的方法
	 */
	public static String getMD5(String str) {
		return getMD5String(str.getBytes()).toLowerCase();
	}

}