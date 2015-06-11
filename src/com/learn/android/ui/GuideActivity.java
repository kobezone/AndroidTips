package com.learn.android.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.learn.android.R;
import com.learn.android.adapter.MyPagerAdapter;

public class GuideActivity extends Activity implements OnPageChangeListener {

	public static boolean isFirst = true;
	private ViewPager guide_vp;
	private MyPagerAdapter pagerAdapter;
	private List<View> mList = new ArrayList<View>();

	private ImageView[] dots;

	private int[] dotsIds = new int[] { R.id.iv1, R.id.iv2, R.id.iv3 };

	private Button start_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		initView();

		initDots();
	}

	private void initDots() {
		dots = new ImageView[dotsIds.length];
		for (int i = 0, len = dots.length; i < len; i++) {
			dots[i] = (ImageView) findViewById(dotsIds[i]);
		}

	}

	public void initView() {
		guide_vp = (ViewPager) findViewById(R.id.guide_vp);
	
		ImageView iv1 = new ImageView(this);
		iv1.setBackgroundResource(R.drawable.ic_welcome01);

		ImageView iv2 = new ImageView(this);
		iv2.setBackgroundResource(R.drawable.ic_welcome02);

		
		View view = LayoutInflater.from(this).inflate(R.layout.activity_guide_end, null);
		
		start_btn  = (Button) view.findViewById(R.id.start_btn);
		
	
		mList.add(iv1);
		mList.add(iv2);
		mList.add(view);
		pagerAdapter = new MyPagerAdapter(this, mList);
		guide_vp.setAdapter(pagerAdapter);
		guide_vp.setOnPageChangeListener(this);
		
		start_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(GuideActivity.this,MainActivity.class ));
			}
		});
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		for (int i = 0; i < dotsIds.length; i++) {
			if (arg0 == i) {
				dots[i].setImageResource(R.drawable.ic_point_selected);
			} else {
				dots[i].setImageResource(R.drawable.ic_point);
			}
		}
			
			
		
		
		
	}
}
