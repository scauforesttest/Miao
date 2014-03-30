package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TableRow;

public class GaoJiSouSuoActivity extends Activity {
	
	private ImageView fanHui;
	private TableRow suijipipei;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gao_ji_sou_suo);
		
		fanHui = (ImageView) findViewById(R.id.fanhui);
		fanHui.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}

}