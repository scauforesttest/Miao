package com.miao.singlechat;

import com.miao.main.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class DogActionThree extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dog_action_three);
		
				ImageView iv = (ImageView)findViewById(R.id.dog_three);
		        iv.setBackgroundResource(R.drawable.dog_findball);
		        AnimationDrawable ad = (AnimationDrawable)iv.getBackground();
		        
		        if(ad.isRunning()) 
		        	  ad.stop();
		        else
		        	  ad.start();	
		        
	}

}