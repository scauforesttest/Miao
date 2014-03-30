package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class FuJinYongHuActivity extends Activity {
	
	private ImageView fanHui;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fu_jin_yong_hu);
		
		fanHui = (ImageView) findViewById(R.id.fanhui);
		fanHui.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}

}