package com.learn.android.demos.gamecatchcrazycat;

import android.app.Activity;
import android.os.Bundle;

/**
 * 抓住神经猫的入口
 * @author JUN jun_dev@qq.com
 * 2015-5-13t上午11:09:37
 * @desciption
 */
public class CatchCrazyCatMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new Playground(this));
	}

}
