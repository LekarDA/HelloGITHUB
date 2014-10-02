package com.example.classworkserg_1;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity implements OnTouchListener {
	ABButton button1;
	ABButton button2;
	ABButton button3;
	ArrayAdapter<String> adapter;
	ABList listView;
	ArrayList<String> data;
	
	String [] names={"Дима","Жека","Вася","Сережа","Глеб","Артём","Григорий","eric","NIck","Emma","Bob"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		data=new ArrayList<String>();
		adapter=new ArrayAdapter<String>(this,R.layout.item,names);
		listView=(ABList)findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		button1=(ABButton)findViewById(R.id.button1);
		button2=(ABButton)findViewById(R.id.button2);
		button3=(ABButton)findViewById(R.id.button3);
		button1.setOnTouchListener(new ListListener());
		button2.setOnTouchListener(new ListListener());
		button3.setOnTouchListener(new ListListener());
		listView.setOnTouchListener(new ListListener());
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
		// TODO Auto-generated method stub
		return false;
	}


	

}
