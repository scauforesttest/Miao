package com.miao.me;

import com.miao.main.R;
import com.miao.main.R.id;
import com.miao.main.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class AboutUs extends Activity {

	private ImageButton ib_back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_about_us);
		ib_back=(ImageButton)findViewById(R.id.ib_back);
		ib_back.setOnClickListener(new Listener());
		
	}
	
	
	class Listener implements OnClickListener {
		@Override 
		public void onClick(View v){
			Intent intent=new Intent();
			switch(v.getId()){
			case R.id.ib_back:
				 AboutUs.this.finish();
				break;
			 
			default: break;
			}
		}
	}

}
