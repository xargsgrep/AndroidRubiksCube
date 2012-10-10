package com.xargsgrep.rubikscube.android;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class RubiksCubeGLSurfaceView extends GLSurfaceView {
	
	RubiksCubeGLRenderer renderer;
	
	private final float TOUCH_SCALE_FACTOR = 180.0f / 320.0f;
	private float previousX = 0; 
	private float previousY = 0;
	
	public RubiksCubeGLSurfaceView(Context context) {
		super(context);
		
		renderer = new RubiksCubeGLRenderer(context);
		this.setRenderer(renderer);
		this.requestFocus();
		this.setFocusableInTouchMode(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float currentX = event.getX();
		float currentY = event.getY();
		float deltaX, deltaY;
		
		switch (event.getAction()) {
			case MotionEvent.ACTION_MOVE:
				deltaX = currentX - previousX;
				deltaY = currentY - previousY;
				renderer.addToCameraAngleX(deltaY * TOUCH_SCALE_FACTOR);
				renderer.addToCameraAngleY(deltaX * TOUCH_SCALE_FACTOR);
		}
		
		previousX = currentX;
		previousY = currentY;
		
		return true;
	}
	
	public RubiksCubeGLRenderer getRenderer() {
		return renderer;
	}
}
