package com.miao.me;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.Toast;

import com.miao.main.R;

public class SettingActivity extends Activity implements Runnable {
	private ImageButton ib_back;
	private TableRow tr_newMsgAlert , tr_clearDialog , tr_setTheme ,tr_about ;
	private Handler handler;
	private  ProgressDialog  pg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting);
		
		tr_newMsgAlert=(TableRow)findViewById(R.id.tr_newMsgAlert);
		tr_newMsgAlert.setOnClickListener(new Listener());
		tr_clearDialog=(TableRow)findViewById(R.id.tr_clearDialog);
		tr_clearDialog.setOnClickListener(new Listener());
		tr_setTheme=(TableRow)findViewById(R.id.tr_setTheme);
		tr_setTheme.setOnClickListener(new Listener());
		tr_about=(TableRow)findViewById(R.id.tr_about);
		tr_about.setOnClickListener(new Listener());
		
		ib_back=(ImageButton)findViewById(R.id.ib_back);
		ib_back.setOnClickListener(new Listener());
		
		
	}

	class Listener implements OnClickListener {
		@Override 
		public void onClick(View v){
			Intent intent=new Intent();
			switch(v.getId()){
			case R.id.ib_back:
				SettingActivity.this.finish();
				break;
			case R.id.tr_newMsgAlert:
				intent.setClass(SettingActivity.this, NewMsgAlert.class);
				startActivity(intent);
				break;
			case R.id.tr_clearDialog:
				
				 
				Toast.makeText(getApplicationContext(), "«Â¿ÌÕÍ±œ£°", Toast.LENGTH_SHORT).show();
				break;
			case R.id.tr_setTheme:
				intent.setClass(SettingActivity.this,ThemeActivity.class);
				startActivity(intent);
				break;
			case R.id.tr_about:
				intent.setClass(SettingActivity.this, AboutUs.class);
				startActivity(intent);
				break;
			default: break;
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		handler.postDelayed(SettingActivity.this, 30000);

	}

}
