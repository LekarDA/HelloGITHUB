package com.example.classworkserg_1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class ABList extends Button implements myinterface {

public ABList(Context context) {
		this(context,null);
		
	}

public ABList(Context context, AttributeSet attrs) {
	this(context, attrs,0);
	// TODO Auto-generated constructor stub
}

public ABList(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

@Override
	public Dirrection getOrientation() {
		
		return null;
	}

}
