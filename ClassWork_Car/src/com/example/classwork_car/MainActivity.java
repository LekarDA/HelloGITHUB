package com.example.classwork_car;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener,OnTouchListener   {
	Button Go;
	Button Back;
	Button Right;
	Button Left;
	Button Acsilirate;
	Button Clakson;
	Button Stop;
	Mazda myMazda=new Mazda(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Go=(Button)findViewById(R.id.go);
		Back=(Button)findViewById(R.id.back);
		Left=(Button)findViewById(R.id.left);
		Right=(Button)findViewById(R.id.right);
		Acsilirate=(Button)findViewById(R.id.acsilirate);
		Stop=(Button)findViewById(R.id.stop);
		Clakson=(Button)findViewById(R.id.clakson);
		
		Go.setOnClickListener(this);
		Back.setOnClickListener(this);
		Left.setOnClickListener(this);
		Right.setOnClickListener(this);
		Acsilirate.setOnClickListener(this);
		Stop.setOnClickListener(this);
		Clakson.setOnTouchListener(this);
		
		
		

//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
	
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
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.go:
			myMazda.getGo();
			break;
		case R.id.right:
			myMazda.getTurnRight();
			break;
		case R.id.left:
			myMazda.getTurnLeft();
			break;
		case R.id.back:
			myMazda.getBack();
			
			break;
		case R.id.acsilirate:
			Toast.makeText(this, "acsilirate", Toast.LENGTH_SHORT).show();
			
			break;
		case R.id.stop:
			Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show();
			
			break;
		
		default:
			break;
		}
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v.getId()==R.id.clakson)
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			myMazda.startClakson();
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			myMazda.stopClakson();
		default:
			break;
		}
		return false;
	}

	

	/**
	 * A placeholder fragment containing a simple view.
	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container,
//					false);
//			return rootView;
//		}
//	}

}
