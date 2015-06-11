package com.learn.android.demos.canvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.view.View.OnTouchListener;

public class MyCanvasView extends SurfaceView implements Callback,OnTouchListener{

	public MyCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public MyCanvasView(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
		p.setColor(Color.RED);
		p.setTextSize(10);
		p.setAntiAlias(true);
		p.setStyle(Style.STROKE);
		setOnTouchListener(this);
	}

	public MyCanvasView(Context context) {
		super(context);
	}
	
	
	private Paint p = new Paint();
	private Path path = new Path();
	

	public void draw(){
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(Color.WHITE);
		canvas.drawPath(path, p);
		getHolder().unlockCanvasAndPost(canvas);
	}
	
	
	public void clear(){
		path.reset();
		draw();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		draw();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(event.getX(), event.getY());
			draw();
			break;

		case MotionEvent.ACTION_MOVE:
			path.lineTo(event.getX(), event.getY());
			draw();
			break;
		}
		
		return true;
	}
	

}
