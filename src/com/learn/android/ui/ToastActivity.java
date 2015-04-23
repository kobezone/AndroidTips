package com.learn.android.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.learn.android.base.BaseActivity;
import com.learn.android.demos.toast.Crouton;
import com.learn.android.demos.toast.Style;

/**
 * 使用crouton
 * @author JUN jun_dev@qq.com
 * 2015-4-23t下午3:24:03
 * @desciption
 */
public class ToastActivity extends BaseActivity {

	private Button alter_btn;
	private Button confirm_btn;
	private Button info_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	
	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		alter_btn = new Button(this);
		alter_btn.setText("Style.ALERT");
		android.widget.LinearLayout.LayoutParams lp= new android.widget.LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
		alter_btn.setLayoutParams(lp);
		
		confirm_btn = new Button(this);
		confirm_btn.setText("Style.CONFIRM");
		confirm_btn.setLayoutParams(lp);
		
		info_btn = new Button(this);
		info_btn.setText("Style.INFO");
		info_btn.setLayoutParams(lp);
		
		View.OnClickListener listener = new MyClickListener();
		alter_btn.setOnClickListener(listener);
		confirm_btn.setOnClickListener(listener);
		info_btn.setOnClickListener(listener);
		
		//添加到布局中
		LinearLayout ll = new LinearLayout(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		ll.setOrientation(LinearLayout.VERTICAL);
		ll.setLayoutParams(layoutParams);
		ll.addView(alter_btn);
		ll.addView(confirm_btn);
		ll.addView(info_btn);
		
		setContentView(ll);
		
	}

	private class MyClickListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			if(v instanceof Button){
				v = (Button)v;
				String type = ((Button) v).getText().toString();
				
				if("Style.ALERT".equals(type)){
					Crouton.makeText(ToastActivity.this, type, Style.ALERT).show();
				}else if("Style.CONFIRM".equals(type)){
					Crouton.makeText(ToastActivity.this, type, Style.CONFIRM).show();
				}else if("Style.INFO".equals(type)){
					Crouton.makeText(ToastActivity.this, type, Style.INFO).show();
				}
				
			}
			
		}
	}
	
	@Override
	protected void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		Crouton.cancelAllCroutons();
		
	}


}
