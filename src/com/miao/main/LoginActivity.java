package com.miao.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {
	
	private Button btn_login;
	private TextView tv_register ,tv_findPwd;
	private EditText et_userName,et_password;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		
		et_userName=(EditText)findViewById(R.id.et_userName);
		et_password=(EditText)findViewById(R.id.et_password);
		
		tv_register=(TextView)findViewById(R.id.tv_register);
		tv_register.setOnClickListener(new OnClickListener(){
			@Override 
			public void onClick(View v){
				
			}
		});
		
		tv_findPwd=(TextView)findViewById(R.id.tv_findPwd);
		tv_findPwd.requestFocus();
		tv_findPwd.setOnClickListener(new OnClickListener(){
			@Override 
			public void onClick(View v){
				
			}
		});
		
		btn_login=(Button)findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new OnClickListener(){
			@Override 
			public void onClick(View v){
				if(et_userName.getText().toString().equals("")||et_password.getText().toString().equals("")){
					Toast.makeText(getApplicationContext(), "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
				}
				else{
					Toast.makeText(getApplicationContext(), "登陆成功！", Toast.LENGTH_SHORT).show();
					Intent intent=new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					LoginActivity.this.finish();
				}
				
			}
		});
	}
	
}
