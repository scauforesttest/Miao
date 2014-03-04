package com.miao.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.miao.main.R;

public class MyInfoEdit extends Activity {
	private TextView tv_editInfoTitle;
	private ImageButton ib_back;
	private EditText et_myNickName,et_myMotto,et_myName,et_myAnimal,et_myAge,
	et_mySex,et_myBirthday,et_myShow;
	private Button btn_myInfoSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_my_info_edit);
		
		et_myNickName=(EditText)findViewById(R.id.et_myNickName);
		et_myMotto=(EditText)findViewById(R.id.et_myMotto);
		et_myName=(EditText)findViewById(R.id.et_myName);
		et_myAnimal=(EditText)findViewById(R.id.et_myAnimal);
		et_myAge=(EditText)findViewById(R.id.et_myAge);
		et_mySex=(EditText)findViewById(R.id.et_mySex);
		et_myBirthday=(EditText)findViewById(R.id.et_mySex);
		et_myShow=(EditText)findViewById(R.id.et_myShow);
		
		
		tv_editInfoTitle=(TextView)findViewById(R.id.tv_editInfoTitle);
		tv_editInfoTitle.requestFocus();
		
		btn_myInfoSubmit=(Button)findViewById(R.id.btn_myInfoSubmit);
		btn_myInfoSubmit.setOnClickListener(new Listener());
		
		ib_back=(ImageButton)findViewById(R.id.ib_back);
		ib_back.setOnClickListener(new Listener());
		
	}

	class Listener implements OnClickListener{
		@Override
		public void onClick(View v){
			switch(v.getId()){
			case R.id.ib_back:
				MyInfoEdit.this.finish();
				break;
			case R.id.btn_myInfoSubmit:
				Intent intent=new Intent(MyInfoEdit.this,Me.class);
				Bundle b=new Bundle();
				b.putString("NickName",et_myNickName.getText().toString());
				b.putString("Motto",et_myMotto.getText().toString());
				b.putString("Name",et_myName.getText().toString());
				b.putString("Animal",et_myAnimal.getText().toString());
				b.putString("Age",et_myAge.getText().toString());
				b.putString("Sex",et_mySex.getText().toString());
				b.putString("Birthday",et_myBirthday.getText().toString());
				b.putString("Show",et_myShow.getText().toString());
				intent.putExtras(b);
				setResult(1,intent);  //返回前一个页面，交回数据处理     第二个参数>=0
				Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_SHORT).show();
				MyInfoEdit.this.finish();
				break;
			default:break;
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_info_edit, menu);
		return true;
	}

}
