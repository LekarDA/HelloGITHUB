package com.example.classworkserg_1;

import com.example.classworkserg_1.myinterface.Dirrection;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ListView;

public class ABList extends ListView implements myinterface {

private Dirrection mDirrection;

public ABList(Context context) {
		super(context);
		customConstructor(context, null);
	}

public ABList(Context context, AttributeSet attrs) {
	super(context, attrs);
	customConstructor(context, attrs);
}

public ABList(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		customConstructor(context, attrs);
	}
private void customConstructor(Context context, AttributeSet attrs) {
	TypedArray attributes=context.getTheme().obtainStyledAttributes(attrs,  R.styleable.ABBButton, 0,0);
	try {
	switch (attributes.getInt(R.styleable.ABBButton_direction, 0)) {
	default:
	case 0:
		setDirrection(Dirrection.LEFTTORIGHT);
		break;
	case 1:
		setDirrection(Dirrection.RIGHTTOLEFT);
		break;
	}
	}finally {
		attributes.recycle();
	}
}
@Override
	public Dirrection getOrientation() {
		
		return null;
	}
public void setDirrection(Dirrection mDirrection){
	this.mDirrection=mDirrection;
}

}
