package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class DogActionTwo extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dog_action_two);
		
				ImageView iv = (ImageView)findViewById(R.id.dog_two);
		        iv.setBackgroundResource(R.drawable.dog_playball);
		        AnimationDrawable ad = (AnimationDrawable)iv.getBackground();
		        
		        if(ad.isRunning()) 
		        	  ad.stop();
		        else
		        	  ad.start();	
		        
	}

}