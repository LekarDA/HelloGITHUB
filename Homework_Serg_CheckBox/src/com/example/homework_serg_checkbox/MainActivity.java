package com.example.homework_serg_checkbox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		OnItemClickListener {

	private ListView list;
	AlertDialog.Builder dialog;
	EditText text; 
	AdapterMainActivity adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		adapter=new AdapterMainActivity(this);
		list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);

		list.setOnItemClickListener(this);

		// if (savedInstanceState == null) {
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment())
		// .commit();
		// }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_add) {
			dialog = new AlertDialog.Builder(this);
			View view = getLayoutInflater().inflate(R.layout.dialog_main, null);
			dialog.setView(view);
			text=(EditText)view.findViewById(R.id.editTextEvent);
	
			dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					adapter.addEvent(text.getText().toString());
						
					

				}
			});
			dialog.setNegativeButton("cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							Toast.makeText(MainActivity.this, "cancel",
									Toast.LENGTH_SHORT).show();

						}
					});
			dialog.create();
			dialog.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
//

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		// @Override
		// public View onCreateView(LayoutInflater inflater, ViewGroup
		// container,
		// Bundle savedInstanceState) {
		// View rootView = inflater.inflate(R.layout.fragment_main, container,
		// false);
		// return rootView;
		// }
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		AdapterMainActivity adapter = (AdapterMainActivity) parent.getAdapter();

		Intent intent = new Intent(MainActivity.this, CheckListActivity.class);
		intent.putExtra(CheckingData.EXTRA_NAME, adapter.getItem(position)
				.getName());
		intent.putExtra(CheckingData.EXTRA_THINGS, adapter.getItem(position)
				.getThings());
		startActivity(intent);

		// startActivity(new Intent(MainActivity.this,
		// ActivityCheckList.class));
	}
}
