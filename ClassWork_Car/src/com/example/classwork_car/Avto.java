package com.example.classwork_car;

import android.content.Context;
import android.widget.Toast;

public abstract class Avto implements Moving,Clakson,turn {
	private boolean voiceClakson;
	private float gaslevel;

	public boolean isVoise(){
		return voiceClakson;
	}
	
 
	public void setGasLevel(float gaslevel){
		this.gaslevel=gaslevel;
	}
	



}
