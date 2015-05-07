package com.learn.android.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.learn.android.R;
import com.learn.android.base.BaseActivity;
import com.learn.android.demos.game2048.Game2048Activity;
import com.learn.android.demos.juhe.JuHeApiMainActivity;

/**
 * <pre>
 *  	这是一个学习和交流的项目,记录个人在android项目开发中的所学习和掌握的技术点,一些个人收集和学习的书籍,心得等,希望和大家一起交流学习.
 * </pre>
 * 
 * @author JUN email jun_dev@qq.com QQ群 313683173
 * 
 */
public class MainActivity extends BaseActivity implements OnClickListener {
	private Button toast_btn;
	private Button guide_btn;
	private Button game2048_btn;
	private Button juhe_btn;

	// private Button toast_btn;
	// private Button toast_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
	}

	@Override
	protected void initView() {
		toast_btn = (Button) findViewById(R.id.toast_btn);
		guide_btn = (Button) findViewById(R.id.guide_btn);
		game2048_btn = (Button) findViewById(R.id.game2048_btn);
		juhe_btn = (Button) findViewById(R.id.juhe_btn);

	}

	@Override
	protected void initData() {
		toast_btn.setOnClickListener(this);
		guide_btn.setOnClickListener(this);
		game2048_btn.setOnClickListener(this);
		juhe_btn.setOnClickListener(this);
	}



	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.toast_btn:
			openActivity(ToastActivity.class);
			break;

		case R.id.guide_btn:
			openActivity(GuideActivity.class);
			break;

		case R.id.game2048_btn:
			openActivity(Game2048Activity.class);
			break;

		case R.id.juhe_btn:
			openActivity(JuHeApiMainActivity.class);
			break;

		default:
			break;
		}

	}
}
