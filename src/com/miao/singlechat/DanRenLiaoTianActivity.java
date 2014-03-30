package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class DanRenLiaoTianActivity extends Activity {
	
	private ImageView fanHui;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dan_ren_liao_tian);
		
		fanHui = (ImageView) findViewById(R.id.fanhui);
		fanHui.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		ImageView dogshoot = (ImageView)findViewById(R.id.dog_shoot_btn);
		dogshoot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(DanRenLiaoTianActivity.this,DogActionOne.class);
				startActivity(intent);
				
			}
		});
		
		ImageView dogplayball = (ImageView)findViewById(R.id.dog_playball_btn);
		dogplayball.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(DanRenLiaoTianActivity.this,DogActionTwo.class);
				startActivity(intent);
				
			}
		});
		
		ImageView dogfindball = (ImageView)findViewById(R.id.dog_findball_btn);
		dogfindball.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(DanRenLiaoTianActivity.this,DogActionThree.class);
				startActivity(intent);
				
			}
		});

	}

}