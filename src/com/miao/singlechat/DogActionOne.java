package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DogActionOne extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dog_action_one);
		
				ImageView iv = (ImageView)findViewById(R.id.dog_one);
		        iv.setBackgroundResource(R.drawable.dog_shoot);
		        AnimationDrawable ad = (AnimationDrawable)iv.getBackground();
		        
		        if(ad.isRunning()) 
		        	  ad.stop();
		        else
		        	  ad.start();	
		        
	}

}