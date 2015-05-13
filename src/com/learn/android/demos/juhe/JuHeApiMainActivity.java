package com.learn.android.demos.juhe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.learn.android.R;

public class JuHeApiMainActivity extends Activity  implements OnClickListener{
	private Button ip_btn;
	private Button weather_btn;
	private Button preg_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_juhe_main);
		
		
		ip_btn =(Button) findViewById(R.id.ip_btn);
		weather_btn = (Button) findViewById(R.id.weather_btn);
		preg_btn = (Button) findViewById(R.id.preg_btn);
		
		ip_btn.setOnClickListener(this);
		weather_btn.setOnClickListener(this);
		
		
		
		
	}
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.ip_btn:
			startActivity(new Intent(this,IPActivity.class));
			break;
		case R.id.weather_btn:
			startActivity(new Intent(this,WeatherActivity.class));
			break;
		case R.id.preg_btn:
			startActivity(new Intent(this,PregActivity.class));
			break;
		default:
			break;
		}
		
	}
	
	
	
}
