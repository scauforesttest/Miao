package com.miao.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.miao.main.R;

public class Me extends Activity {
	
	  
	public ImageView iv_myPic;  
	private TextView tv_myNickName,tv_myLevel,tv_myMotto,tv_myName,
	tv_myAnimal,tv_myAge,tv_myMiaoAge,tv_myBirthday,tv_mySex,
	tv_myShow,tv_setting;
    private ImageButton ib_editMyInfo;
    private RelativeLayout rlMe;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_me);
		
		tv_myNickName=(TextView)findViewById(R.id.tv_myNickName);
		tv_myLevel=(TextView)findViewById(R.id.tv_myLevel);
		tv_myMotto=(TextView)findViewById(R.id.tv_myMotto);
		tv_myName=(TextView)findViewById(R.id.tv_myName);
		tv_myAnimal=(TextView)findViewById(R.id.tv_myAnimal);
		tv_myAge=(TextView)findViewById(R.id.tv_myAge);
		tv_myMiaoAge=(TextView)findViewById(R.id.tv_myMiaoAge);
		tv_myBirthday=(TextView)findViewById(R.id.tv_myBirthday);
		tv_mySex=(TextView)findViewById(R.id.tv_mySex);
		tv_myShow=(TextView)findViewById(R.id.tv_myShow);
		tv_setting=(TextView)findViewById(R.id.tv_setting);
		
		ib_editMyInfo=(ImageButton)findViewById(R.id.ib_editMyInfo);
		ib_editMyInfo.setOnClickListener(new Listener());
		
		iv_myPic=(ImageView)findViewById(R.id.iv_myPic);
		iv_myPic.setOnClickListener(new Listener());
		
		rlMe=(RelativeLayout)findViewById(R.id.rl_meSetting);
		rlMe.setOnClickListener(new Listener());
	}
	
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		switch (resultCode){
		case 1:
		Bundle b=data.getExtras();
		System.out.println("nickName : "+b.getString("NickName"));
		System.out.println("motto: "+b.getString("Motto"));
		tv_myNickName.setText(b.getString("NickName"));
		tv_myMotto.setText(b.getString("Motto"));
		tv_myName.setText(b.getString("Name"));
		tv_myAnimal.setText(b.getString("Animal"));
		tv_myAge.setText(b.getString("Age"));
		tv_myBirthday.setText(b.getString("Birthday"));
		tv_mySex.setText(b.getString("Sex"));
		tv_myShow.setText(b.getString("Show"));
		break;
		default: break;
		}
	}
	
	class Listener implements OnClickListener{
		@Override
		public void onClick(View v){
			Intent intent=new Intent();
			switch(v.getId()){
			case R.id.ib_editMyInfo:
				intent.setClass(Me.this, MyInfoEdit.class);
				startActivityForResult(intent,0);   //交给下一个Activity完成任务并返回数据
				break;
			case R.id.rl_meSetting:
				intent.setClass(Me.this, SettingActivity.class);
				startActivity(intent);
				break;
			default:break;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
