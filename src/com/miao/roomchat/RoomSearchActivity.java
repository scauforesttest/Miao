package com.miao.roomchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miao.main.R;

public class RoomSearchActivity extends Activity {
	private String[] roomNum={"001","002","003","004","005","006","007"};
	private String[] roomTheme={"开心剧场","旅游一族","无兄弟，不篮球","音乐吧","IT农场","美食一族","吃货"};
	private String[] num={"1","2","3","4","5","6","7"};
	private Button btn_roomSearch;
	private ImageButton ib_back;
	private ListView lv_roomSearchResult;
	private EditText et_roomSearchInput;
	private TextView tv_roomSearchResult;
	private TextView tv_searchTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_room_search);
		
		tv_roomSearchResult=(TextView)findViewById(R.id.tv_roomSearchResult);
		tv_searchTitle=(TextView)findViewById(R.id.tv_searchTitle);
		//设置标题控件获取焦点，避免焦点落在编辑区当中直接调用键盘
		tv_searchTitle.setFocusable(true);
		tv_searchTitle.setFocusableInTouchMode(true);
		tv_searchTitle.requestFocus();
		
		et_roomSearchInput=(EditText)findViewById(R.id.et_roomSearchInput);
//		//隐藏键盘
//		InputMethodManager imm=(InputMethodManager)
//                getSystemService(Context.INPUT_METHOD_SERVICE);
//   		imm.hideSoftInputFromWindow(et_roomSearchInput.getWindowToken(),0);    
//  		// windowToken 由窗口请求View.getWindowToken()返回得到的令牌(token)。
//		
		btn_roomSearch=(Button)findViewById(R.id.btn_roomSearch);
		btn_roomSearch.setOnClickListener(new Listener());
		
		ib_back=(ImageButton)findViewById(R.id.ib_back);
		ib_back.setOnClickListener(new Listener());
		
		lv_roomSearchResult=(ListView)findViewById(R.id.lv_roomSearchResult);
		
		
		 
		
	}
	
	
	class ListListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> av,View v,int position,long id){
			Intent intent=new Intent(RoomSearchActivity.this,RoomInfoActivity.class);
			startActivity(intent);
		}
	}
	
	class Listener implements OnClickListener{
		public void onClick(View v){
			if(v.getId()==R.id.btn_roomSearch){
				//隐藏键盘
//				InputMethodManager imm=(InputMethodManager)
//		                getSystemService(Context.INPUT_METHOD_SERVICE);
//		   		imm.hideSoftInputFromWindow(et_roomSearchInput.getWindowToken(),0);    
//		  		// windowToken 由窗口请求View.getWindowToken()返回得到的令牌(token)。
//				
				InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(et_roomSearchInput.getWindowToken(), 0);
				
				tv_roomSearchResult.setVisibility(View.VISIBLE);
				lv_roomSearchResult.setAdapter(new RoomSearchAdapter(RoomSearchActivity.this));
				lv_roomSearchResult.setOnItemClickListener(new ListListener());
			}
			else if(v.getId()==R.id.ib_back){
				RoomSearchActivity.this.finish();
			}
		}
	}
	
	public class RoomSearchAdapter extends BaseAdapter{
		LayoutInflater mInflater;
	public RoomSearchAdapter(Context context){
		this.mInflater=LayoutInflater.from(context);
	}
	public int getCount(){
		return roomNum.length;
	}
	public long getItemId(int position){
		return position;
	}
	public Object getItem(int position){
		return null;
	}
	public View getView(int position,View convertView,ViewGroup parent){
		convertView=mInflater.inflate(R.layout.room_chat_list, null);
		ImageView iv_roomPic=(ImageView)convertView.findViewById(R.id.iv_roomPic);
		TextView tv_roomNum=(TextView)convertView.findViewById(R.id.tv_roomNum);
		TextView tv_roomTheme=(TextView)convertView.findViewById(R.id.tv_roomTheme);
		TextView tv_population=(TextView)convertView.findViewById(R.id.tv_population);
		TextView tv_space=(TextView)convertView.findViewById(R.id.tv_space);
		TextView   tv_requestJoin=(TextView)convertView.findViewById(R.id.tv_requestJoin);
		
		tv_requestJoin.setVisibility(View.VISIBLE);
		tv_requestJoin.setOnClickListener(new OnClickListener(){
			@Override 
			public void onClick(View v){
				Toast.makeText(getApplicationContext(), "已提交申请", Toast.LENGTH_SHORT).show();
			}
		});
		iv_roomPic.setImageResource(R.drawable.default_pic);
		tv_roomNum.setText(roomNum[position]);
		tv_roomTheme.setText(roomTheme[position]);
		tv_population.setText(num[position]+"人");
		return convertView;
	}
}

	
}
