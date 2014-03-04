package com.miao.me;

import com.miao.main.R;
import com.miao.main.R.layout;
import com.miao.main.R.menu;
import com.miao.me.AboutUs.Listener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class NewMsgAlert extends Activity {

	private ImageButton ib_back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_new_msg_alert);
		ib_back=(ImageButton)findViewById(R.id.ib_back);
		ib_back.setOnClickListener(new Listener());
		
	}
	
	
	class Listener implements OnClickListener {
		@Override 
		public void onClick(View v){
			Intent intent=new Intent();
			switch(v.getId()){
			case R.id.ib_back:
				 NewMsgAlert.this.finish();
				break;
			 
			default: break;
			}
		}
	}
}
