package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;

public class SouSuoActivity extends Activity {
	
	private ImageView fanHui;
	private TableRow suijipipei;
	private TableRow gaojisousuo;
	private TableRow xunzhaofujin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sou_suo);
		
		fanHui = (ImageView) findViewById(R.id.fanhui);
		fanHui.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		suijipipei = (TableRow) findViewById(R.id.suijipipei);
		suijipipei.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(SouSuoActivity.this, SuijipipeiActivity.class);
				startActivity(intent);
				
			}
		});
		
		gaojisousuo = (TableRow) findViewById(R.id.gaojisousuo);
		gaojisousuo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(SouSuoActivity.this,GaoJiSouSuoActivity.class);
				startActivity(intent);
				
			}
		});
		
		xunzhaofujin = (TableRow) findViewById(R.id.xunzhaofujin);
		xunzhaofujin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(SouSuoActivity.this,FuJinYongHuActivity.class);
				startActivity(intent);
				
			}
		});
	}

}
