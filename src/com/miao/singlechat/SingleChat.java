package com.miao.singlechat;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import com.miao.main.R;;

public class SingleChat extends Activity {
	
	
	private ImageView sousuo;
	private ImageView tianjia;
	private TableRow liebiao1;
	private TableRow liebiao2;
	private TableRow liebiao3;
	private TableRow liebiao4;
	private TableRow liebiao5;
	private TableRow liebiao6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dan_liao_main);
		sousuo = (ImageView)findViewById(R.id.sousuo);
		sousuo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,SouSuoActivity.class);
				startActivity(intent);
			}
		});
		
		tianjia = (ImageView) findViewById(R.id.tianjia);
		tianjia.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,HaoYouActivity.class);
				startActivity(intent);
			}
		});
		
		liebiao1 = (TableRow) findViewById(R.id.liaotianliebiao1);
		liebiao1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,DanRenLiaoTianActivity.class);
				startActivity(intent);
				
			}
		});
		
		liebiao2 = (TableRow) findViewById(R.id.liaotianliebiao2);
		liebiao2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,DanRenLiaoTianActivity.class);
				startActivity(intent);
				
			}
		});
		
		liebiao3 = (TableRow) findViewById(R.id.liaotianliebiao3);
		liebiao3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,DanRenLiaoTianActivity.class);
				startActivity(intent);
				
			}
		});
		
		liebiao4 = (TableRow) findViewById(R.id.liaotianliebiao4);
		liebiao4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,DanRenLiaoTianActivity.class);
				startActivity(intent);
				
			}
		});
		
		liebiao5 = (TableRow) findViewById(R.id.liaotianliebiao5);
		liebiao5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,DanRenLiaoTianActivity.class);
				startActivity(intent);
				
			}
		});
		
		liebiao6 = (TableRow) findViewById(R.id.liaotianliebiao6);
		liebiao6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(SingleChat.this,DanRenLiaoTianActivity.class);
				startActivity(intent);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_chat, menu);
		return true;
	}

}
