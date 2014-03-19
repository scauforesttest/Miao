package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SuijipipeiActivity extends Activity {
	
	private ImageView fanHui;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sui_ji_pi_pei);
		
		fanHui = (ImageView) findViewById(R.id.fanhui);
		fanHui.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}

}