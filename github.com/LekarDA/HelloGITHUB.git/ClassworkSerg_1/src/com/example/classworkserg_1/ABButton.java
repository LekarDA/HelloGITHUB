package com.example.classworkserg_1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;

public class ABButton extends ListView implements myinterface {
	

private Dirrection mDirrection;
	
 public  ABButton(Context context) {
	super(context);

}
public ABButton(Context context, AttributeSet attrs) {
	super(context, attrs);
	
}

public ABButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
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
