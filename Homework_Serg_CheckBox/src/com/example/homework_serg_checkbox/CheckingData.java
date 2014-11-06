package com.example.homework_serg_checkbox;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckingData {

	public static final String EXTRA_NAME = "EXTRA_NAME";
	public static final String EXTRA_THINGS = "EXTRA_THINGS";

	private String mName;
	private ArrayList<String> mThings;

	public CheckingData(String name, ArrayList<String> things) {
		mName = name;
		mThings = things;
	}

	public CheckingData(String name, String... things) {
		this(name, new ArrayList<String>(Arrays.asList(things)));
	}

	public String getName() {
		return mName;
	}

	public ArrayList<String> getThings() {
		return mThings;
	}

}
