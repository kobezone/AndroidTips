package com.learn.android;

import com.thinkland.sdk.android.JuheSDKInitializer;

import android.app.Application;

public class MyApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		//聚合sdk的注册
		JuheSDKInitializer.initialize(getApplicationContext());
	}
	
}
