package com.example.homework_serg_checkbox;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckListActivity extends ActionBarActivity {
	TextView tvName;
	ListView listGoods;
	AlertDialog.Builder builder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		String name = getIntent().getStringExtra(CheckingData.EXTRA_NAME);
		ArrayList<String> things = getIntent().getStringArrayListExtra(
				CheckingData.EXTRA_THINGS);

		setContentView(R.layout.activity_list_check_box);
		tvName = (TextView) findViewById(R.id.textView_name);
		tvName.setText(name);
		listGoods = (ListView) findViewById(R.id.listView1);
		listGoods.setAdapter(new Adapter(this, things));

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.check_list_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_add) {
			builder = new AlertDialog.Builder(this);
			View view = getLayoutInflater().inflate(R.layout.dialog_check_list, null);
			builder.setView(view);
			builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(CheckListActivity.this, "save",
							Toast.LENGTH_SHORT).show();

				}
			});
			builder.setNegativeButton("cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							Toast.makeText(CheckListActivity.this, "cancel",
									Toast.LENGTH_SHORT).show();

						}
					});
			builder.create();
			builder.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
