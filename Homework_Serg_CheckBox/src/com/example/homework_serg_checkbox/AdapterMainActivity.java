package com.example.homework_serg_checkbox;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterMainActivity extends BaseAdapter {

	ArrayList<CheckingData> listCheckingData;
	Context mContext;
	LayoutInflater inflater;

	
	

	

	public AdapterMainActivity(Context context, ArrayList<CheckingData> list) {
		mContext = context;
		listCheckingData = list;
		inflater = LayoutInflater.from(mContext);
	}
	public AdapterMainActivity(Context context) {
		mContext = context;
		listCheckingData = getDemoListEvent();
		inflater = LayoutInflater.from(mContext);
	}

	public static ArrayList<CheckingData> getDemoListEvent() {
		ArrayList<CheckingData>  templist = new ArrayList<>();
		templist.add(new CheckingData("Поездка", "футболка", "джинсы", "кросы",
				"куртка", "ноут", "деньги", "паспорт", "сумка"));
		templist.add(new CheckingData("СпортЗал", "футболка", "шорты", "кросы",
				"вода"));
		templist.add(new CheckingData("Море", "футболка", "шорты", "тапки",
				"полотенце", "зонт", "деньги"));
		templist.add(new CheckingData("Магазин", "деньги", "список", "сумка"));
		return templist;
	}
	
//	public static AdapterMainActivity getDemoAdapterEvent(Context context) {
//		ArrayList<CheckingData>  templist = new ArrayList<>();
//		templist.add(new CheckingData("Поездка", "футболка", "джинсы", "кросы",
//				"куртка", "ноут", "деньги", "паспорт", "сумка"));
//		templist.add(new CheckingData("СпортЗал", "футболка", "шорты", "кросы",
//				"вода"));
//		templist.add(new CheckingData("Море", "футболка", "шорты", "тапки",
//				"полотенце", "зонт", "деньги"));
//		templist.add(new CheckingData("Магазин", "деньги", "список", "сумка"));
//		return new AdapterMainActivity(context, templist);
//	}
	
	public void addEvent(String text){
		listCheckingData.add(new CheckingData(text, "что то"));
		notifyDataSetChanged();
		
	}
	

	@Override
	public int getCount() {
		return listCheckingData.size();
	}

	@Override
	public CheckingData getItem(int position) {
		return listCheckingData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = inflater.inflate(R.layout.activity_main_item, parent,
					false);
		TextView textEvent = (TextView) convertView
				.findViewById(R.id.textView_Event);
		textEvent.setText(getItem(position).getName());
		return convertView;
	}

}
