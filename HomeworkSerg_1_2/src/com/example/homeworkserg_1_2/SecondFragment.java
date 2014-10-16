package com.example.homeworkserg_1_2;

import android.app.Fragment;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

public class SecondFragment extends Fragment implements OnClickListener {
	View cancenable;
	private static final String EXTRA_IMAGE_RES_ID="EXTRA_IMAGE_RES_ID";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.fragment_second, container,false);
		ImageView image=(ImageView)rootView.findViewById(R.id.imageViewUkraine);
		image.setImageResource(getArguments().getInt(EXTRA_IMAGE_RES_ID));
		cancenable=rootView.findViewById(R.id.view1);
		cancenable.setOnClickListener(this);
		//image.setOnClickListener(this); прописать код для дрыгания
		return rootView;
	}
	public static SecondFragment newInstance(int ImageResourcesId) {
		SecondFragment fragment = new SecondFragment();
		Bundle arg = new Bundle();
		arg.putInt(EXTRA_IMAGE_RES_ID, ImageResourcesId);
		fragment.setArguments(arg);
		return fragment;
	}
	@Override
	public void onClick(View arg0) {
		getFragmentManager().popBackStack();
		
	}
	
}
