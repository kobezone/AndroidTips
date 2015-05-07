package com.learn.android.ui;

import android.os.Bundle;
import android.view.View;

import com.learn.android.R;
import com.learn.android.base.BaseActivity;
import com.learn.android.demos.game2048.Game2048Activity;

/**
 * <pre>
 *  	这是一个学习和交流的项目,记录个人在android项目开发中的所学习和掌握的技术点,一些个人收集和学习的书籍,心得等,希望和大家一起交流学习.
 * </pre>
 * @author JUN 
 * email jun_dev@qq.com
 * QQ群 313683173
 * 
 */
public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void initView() {
		
		
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		
	}
	
	public void toastTest(View v){
		openActivity(ToastActivity.class);
	}
	
	public void guideTest(View v){
		openActivity(GuideActivity.class);
	}
	public void game2048Test(View v){
		openActivity(Game2048Activity.class);
	}
}
