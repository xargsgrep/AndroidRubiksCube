package com.xargsgrep.rubikscube.android;

import com.xargsgrep.rubikscube.android.R;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class RubiksCubeGLActivity extends Activity {
	
	private RubiksCubeGLSurfaceView glView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView = new RubiksCubeGLSurfaceView(this);
        setContentView(glView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
	    	case R.id.menu_settings:
	    		return true;
	    	case R.id.menu_scramble:
	    		glView.getRenderer().toggleScrambleCube();
	    		return true;
	    	case R.id.menu_solve:
	    		glView.getRenderer().toggleSolveCube();
	    		return true;
    	}
    	return false;
    }
    
}
