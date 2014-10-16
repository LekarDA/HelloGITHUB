
package com.example.homeworkserg_1_2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {
Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new GridFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	//		switch (item.getItemId()) {
	//		case R.id.action_oneImage:
	//			Toast.makeText(this, "YESS", Toast.LENGTH_LONG).show();
	//			Button imageButton=new Button(this);
//			
//			return true;
//		case R.id.action_3x3Image:
//			Toast.makeText(this, "YESS 9 photo", Toast.LENGTH_LONG).show();
//			intent=new Intent(MainActivity.this, GridFragment.class);
//			startActivity(intent);
//			
//			return true;
//		case R.id.action_4x4Image:
//			Toast.makeText(this, "wow 16 images", Toast.LENGTH_LONG).show();
//			return true;
//		default:
			return super.onOptionsItemSelected(item);
			
		
		//}
		
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
