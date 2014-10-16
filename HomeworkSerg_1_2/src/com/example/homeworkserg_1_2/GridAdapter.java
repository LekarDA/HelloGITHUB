package com.example.homeworkserg_1_2;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

	public static enum Type {
		_3x3, _4x4
	};

	public static final Type DEFAULT_TYPE = Type._3x3;
	private static final int[] COUNTRY = { R.drawable.britain,
			R.drawable.canada, R.drawable.denmark, R.drawable.egypt,
			R.drawable.finland, R.drawable.france, R.drawable.georgia,
			R.drawable.germany, R.drawable.greece, R.drawable.italy,
			R.drawable.jamaica, R.drawable.south_korea, R.drawable.sweden,
			R.drawable.switzerland, R.drawable.ukraine,
			R.drawable.united_states };

	private ArrayList<Integer> mItems;
	private Context mContext;
	private Type mType;

	public GridAdapter(Context context) {
		this(context, generateItems(16));
	}

	public GridAdapter(Context context, ArrayList<Integer> items) {
		mContext = context;
		this.mItems = items;
		setType(DEFAULT_TYPE);
	}

	private static ArrayList<Integer> generateItems(int count) {
		ArrayList<Integer> tempitems = new ArrayList<Integer>();
		for (int i = 0; i < count; i++)
			tempitems.add(COUNTRY[i]);
		return tempitems;
	}

	@Override
	public int getCount() {

		return mType == Type._3x3 ? 9 : 16;
	}

	@Override
	public Integer getItem(int position) {

		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = new ImageView(mContext);
		((ImageView) convertView).setImageResource(getItem(position));
		((ImageView) convertView).setAdjustViewBounds(true);

		return convertView;
	}

	public void setType(Type type) {
		mType = type;

	}

}
