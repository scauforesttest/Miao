package com.miao.singlechat;

import com.miao.main.R;
import com.miao.main.R.layout;
import com.miao.main.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SingleChat extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_chat);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_chat, menu);
		return true;
	}

}
