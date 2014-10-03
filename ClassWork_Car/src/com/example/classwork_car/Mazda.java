package com.example.classwork_car;

import android.content.Context;
import android.widget.Toast;

public class Mazda extends Avto {
	Context mContext;

	public Mazda(Context context) {
		mContext = context;
	}

	@Override
	public void startClakson() {
		Toast.makeText(mContext, "BI-BI", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void stopClakson() {
		Toast.makeText(mContext, "Stop BI-BI", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void getGo() {
		Toast.makeText(mContext, "Good speed", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void getTurnRight() {
		Toast.makeText(mContext, "Turn to right", Toast.LENGTH_SHORT)
				.show();

	}

	@Override
	public void getTurnLeft() {
		Toast.makeText(mContext, "Turn to left", Toast.LENGTH_SHORT)
		.show();
		
	}

	@Override
	public void getBack() {
		Toast.makeText(mContext, "Go back", Toast.LENGTH_SHORT)
		.show();
		
	}
}
