package com.learn.android.demos.canvas;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.learn.android.R;
import com.learn.android.base.BaseActivity;
import com.learn.android.demos.canvas.view.MyCanvasView;

public class MyCanvasActivity extends BaseActivity {

	private MyCanvasView mycanvas_mv;
	private Button clear_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demos_mycanvas);
		initView();
		initData();
	}
	
	
	
	@Override
	protected void initView() {
		mycanvas_mv = (MyCanvasView) findViewById(R.id.mycanvas_mv);
		clear_btn= (Button) findViewById(R.id.clear_btn);

	}

	@Override
	protected void initData() {
		clear_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mycanvas_mv.clear();
			}
		});
	}



	@Override
	public void onClick(View v) {
	
	}

}
