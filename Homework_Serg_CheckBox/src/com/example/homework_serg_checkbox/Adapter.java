package com.example.homework_serg_checkbox;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

public class Adapter extends BaseAdapter {
	ArrayList<String> listGoods;
	LayoutInflater inflater;
	Context mContext;

	public Adapter(Context context, ArrayList<String> list) {
		mContext = context;
		listGoods = list;
		inflater = LayoutInflater.from(mContext);
	}

	public static Adapter getDemoAdapter(Context context) {
		ArrayList<String> tempArrayList = new ArrayList<String>();
		tempArrayList.add("Кросы");
		tempArrayList.add("Футболка");
		tempArrayList.add("Шорты");
		tempArrayList.add("Вода");
		tempArrayList.add("Перчатки");
		return new Adapter(context, tempArrayList);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listGoods.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return listGoods.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = inflater.inflate(R.layout.item, parent, false);
		CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkBox1);
		checkbox.setText(getItem(position));
		return convertView;
	}

}
