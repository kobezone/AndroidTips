package com.learn.android.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {

	private Context mContext;
	private List<View> mViews;

	public MyPagerAdapter(Context context, List<View> list) {
		this.mContext = context;
		this.mViews = list;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {

		((ViewPager) container).removeView(mViews.get(position));
	}

	@Override
	public Object instantiateItem(View container, int position) {

		((ViewPager) container).addView(mViews.get(position));

		return mViews.get(position);

	}

	@Override
	public int getCount() {
		return mViews.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);
	}

}
