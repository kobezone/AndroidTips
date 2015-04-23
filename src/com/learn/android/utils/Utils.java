package com.learn.android.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;

import org.json.JSONException;
import org.json.JSONObject;

import com.learn.android.utils.tools.SDCardUtils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

/**
 * 个人常用工具箱
 * @author JUN jun_dev@qq.com
 * 2015-4-23t下午2:46:23
 * @desciption
 */
public class Utils {
	private static final String TAG = null;
	//记录上次操作的时间
	public  static long lastClickTime=0l;
	
	/**
	 * 判断是否是双击的事件  屏蔽掉快速点击导致的事件多次触发
	 * @return
	 */
	public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (timeD >= 0 && timeD <= 1000) {
            return true;
        } else {
            lastClickTime = time;
            return false;
        }
    }
	
	
	
	/**
	 * 正则校验 验证表单
	 * 
	 * @param value
	 * @param reg
	 * @return
	 */
	public static boolean valid(String value, String reg) {
		if (value == null || reg == null) {
			return false;
		}
		return value.matches(reg);
	}
	
	

	// 判断wifi是否可用
	public static boolean isWiFiEnabled(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		return networkInfo != null
				&& networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
	}

	// 判断网络是否可用
	public static boolean isConnnected(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (null != connectivityManager) {
			NetworkInfo networkInfo[] = connectivityManager.getAllNetworkInfo();
			if (null != networkInfo) {
				for (NetworkInfo info : networkInfo) {
					if (info.getState() == NetworkInfo.State.CONNECTED) {
						Log.e(TAG, "the net is ok");
						return true;
					}
				}
			}
		}
		// Toast.makeText(context, "网络连接失败", Toast.LENGTH_SHORT).show();
		Log.e(TAG, "网络连接失败");
		return false;
	}
	
	
	/**
	 * 读取assert中的json字符串
	 * @param contex
	 * @param fileName
	 * @return
	 * @throws JSONException
	 */
	
	
	public static JSONObject readMyTest(Context contex, String fileName)
			throws JSONException {
		String result = "";
		try {
			InputStreamReader inputReader = new InputStreamReader(contex
					.getResources().getAssets().open(fileName));
			BufferedReader bufReader = new BufferedReader(inputReader);
			String line = "";
			while ((line = bufReader.readLine()) != null)
				result += line;
			return new JSONObject(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject(result);
	}
	
	
	/**
	 * 安装apk
	 * 
	 * @param context
	 * @param apkpath
	 */
	public static void installApk(Context context, String apkpath) {
		String path = SDCardUtils.getSDCardPath()+ apkpath;
		File apkfile = new File(path);
		if (!apkfile.exists()) {
			return;
		}
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse("file://" + apkfile.toString()),
				"application/vnd.android.package-archive");
		context.startActivity(intent);
	}
	
	/**
	 * 得到实际文件的大小(计算日志文件的大小)
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static long getFileRealSize(Context context, File file) {
		FileInputStream fis = null;
		long size = -1l;
		try {
			fis = new FileInputStream(file);
			FileChannel fc = fis.getChannel();
			if (fis != null) {
				size = fc.size();
				fis.close();
				if (fc != null) {
					fc.close();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return size;
	}

	/**
	 * 获取手机通知栏的高度
	 */
	public static int getStatusBarHeight() {
		return Resources.getSystem().getDimensionPixelSize(
				Resources.getSystem().getIdentifier("status_bar_height",
						"dimen", "android"));
	}
	/**
	 * 获取手机状态栏高度
	 * 
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context) {
		Class<?> c = null;
		Object obj = null;
		java.lang.reflect.Field field = null;
		int x = 0;
		int statusBarHeight = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			statusBarHeight = context.getResources().getDimensionPixelSize(x);
			return statusBarHeight;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusBarHeight;
	}

	// 转换文件大小
	public static String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}
	
	/**
	 * 根据手机分辨率从dp转成px
	 * 
	 * @param context 上下文
	 * @param dpValue dp值
	 * @return int 像素值
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/** 
	 * 根据手机的分辨率从 的单位 转成为 dp 
	*/
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
}
