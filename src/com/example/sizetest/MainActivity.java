package com.example.sizetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnTouchListener {

	private RelativeLayout rootLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rootLayout = (RelativeLayout)findViewById(R.id.root);
		rootLayout.setOnTouchListener(this);
		CircleView cv0 = new CircleView(this, 1, 50, 400, 10);
		CircleView cv1 = new CircleView(this, 1, 100, 400, 20);
		CircleView cv2 = new CircleView(this, 1, 300, 400, 30);
		CircleView cv3 = new CircleView(this, 1, 500, 400, 40);
		CircleView cv4 = new CircleView(this, 1, 700, 400, 50);
		CircleView cv5 = new CircleView(this, 1, 900, 400, 60);
		rootLayout.addView(cv0);
		rootLayout.addView(cv1);
		rootLayout.addView(cv2);
		rootLayout.addView(cv3);
		rootLayout.addView(cv4);
		rootLayout.addView(cv5);
		
		Button clean = (Button)findViewById(R.id.button1);
		clean.setOnTouchListener(new ButtonLitener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN){
			RelativeLayout rootLayout = (RelativeLayout)findViewById(R.id.root);
			CircleView cv = new CircleView(this, 1, event.getX(), event.getY(), event.getSize()*60);
			Log.i("TEST", String.valueOf(event.getSize()));
			rootLayout.addView(cv);
		}
		return false;
	}
	
	class ButtonLitener implements OnTouchListener{

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN){
				rootLayout.removeAllViews();
				CircleView cv0 = new CircleView(getApplicationContext(), 1, 50, 400, 10);
				CircleView cv1 = new CircleView(getApplicationContext(), 1, 100, 400, 20);
				CircleView cv2 = new CircleView(getApplicationContext(), 1, 300, 400, 30);
				CircleView cv3 = new CircleView(getApplicationContext(), 1, 500, 400, 40);
				CircleView cv4 = new CircleView(getApplicationContext(), 1, 700, 400, 50);
				CircleView cv5 = new CircleView(getApplicationContext(), 1, 900, 400, 60);
				rootLayout.addView(cv0);
				rootLayout.addView(cv1);
				rootLayout.addView(cv2);
				rootLayout.addView(cv3);
				rootLayout.addView(cv4);
				rootLayout.addView(cv5);
			}
			return false;
		}
		
	}
}
