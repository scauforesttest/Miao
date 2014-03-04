package com.miao.roomchat;

import com.miao.main.R;
import com.miao.main.R.layout;
import com.miao.main.R.menu;

import android.widget.ImageButton;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class RoomInfoActivity extends Activity {

	private ImageButton ib_back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_room_info);
		
		ib_back=(ImageButton)findViewById(R.id.ib_back);
		ib_back.setOnClickListener(new Listener());
	}
    
	class Listener implements OnClickListener{
		@Override
		public void onClick(View v){
			if(v.getId()==R.id.ib_back){
			RoomInfoActivity.this.finish();
			}
		}

		
	}
	
}
