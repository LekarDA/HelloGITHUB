package com.example.classworkserg_1;

import android.content.Context;
import android.hardware.display.DisplayManager.DisplayListener;
import android.location.Location;
import android.provider.Settings.Global;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;

public class ListListener implements OnTouchListener {

	public static final String Tag = ListListener.class.getSimpleName();

	public static enum Zone {
		TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER_CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
	}

	public static enum Location {
		LEFT_SIDE, MIDLE, RIGHT_SIDE
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Location location = GlobalLocation(v);
		Zone zone = TouchLocation(v, event);
		Log.d(Tag, "view location is" + location);
		Log.d(Tag, "touch zone is"+zone);
		return false;
	}

	private Zone TouchLocation(View v, MotionEvent event) {
		float relativeX = event.getX() / v.getWidth();
		float relativeY = event.getY() / v.getHeight();
		Log.d(Tag, "relativeX = " + relativeX);
		Log.d(Tag, "relativeY = " + relativeY);
		StringBuilder zoneBuilder = new StringBuilder();
		zoneBuilder.append(relativeY < 1 / 3f ? "TOP"
				: relativeY > 2 / 3f ? "BOTTOM" : "CENTER");
		zoneBuilder.append("_");
		zoneBuilder.append(relativeX < 1/3f?"LEFT":relativeX>2/3f?"RIGHT":"CENTER");
		return Zone.valueOf(zoneBuilder.toString());
	}

	private Location GlobalLocation(View v) {
		WindowManager manager = (WindowManager) v.getContext()
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics displayMetrics = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(displayMetrics);
		int displayWidth = displayMetrics.widthPixels;
		int viewWidth = v.getWidth();
		int[] mLocation = new int[2];
		v.getLocationInWindow(mLocation);
		float viewHorisontalCenter = mLocation[0] + viewWidth / 2f;
		if (viewHorisontalCenter / displayWidth < 0.4f)
			return Location.LEFT_SIDE;
		else if (viewHorisontalCenter / displayWidth > 0.6f)
			return Location.RIGHT_SIDE;
		else
			return Location.MIDLE;

	}

}
