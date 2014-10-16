package com.example.homeworkserg_1_2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.homeworkserg_1_2.GridAdapter.Type;

public class GridFragment extends Fragment implements OnItemClickListener {
	GridAdapter adapter;
	GridView gridview;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_main, null);
		adapter = new GridAdapter(getActivity().getBaseContext());
		gridview = (GridView) v.findViewById(R.id.GridView);
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(this);

		return v;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_3x3Image:
			((GridAdapter) gridview.getAdapter()).setType(Type._3x3);
			gridview.setNumColumns(3);

			break;
		case R.id.action_4x4Image:
			((GridAdapter) gridview.getAdapter()).setType(Type._4x4);
			gridview.setNumColumns(4);
			break;

		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View itemClicked,
			int position, long id) {
		getFragmentManager()
				.beginTransaction()
				.add(R.id.container,
						SecondFragment.newInstance((Integer)parent.getAdapter().getItem(position)))
				.addToBackStack(null).commit();

	}
}
