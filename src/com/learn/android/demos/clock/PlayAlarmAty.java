package com.learn.android.demos.clock;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.learn.android.R;

public class PlayAlarmAty extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_player);
		
		mp = MediaPlayer.create(this, R.raw.alarm_music);
		mp.start();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		finish();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		mp.stop();
		mp.release();
	}
	
	private MediaPlayer mp;
}
