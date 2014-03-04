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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.miao.main.R;

public class RoomChat extends Activity {

	private String[] roomNum={"001","002","003","004","005","006","007"};
	private String[] roomTheme={"开心剧场","旅游一族","无兄弟，不篮球","音乐吧","IT农场","美食一族","吃货"};
	private String[] num={"1","2","3","4","5","6","7"};
	private ListView lv_roomChat;
	private ImageButton ib_roomSearch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_room_chat);
		
		ib_roomSearch=(ImageButton)findViewById(R.id.ib_roomSearch);
		ib_roomSearch.setOnClickListener(new OnClickListener(){
			@Override 
			public void onClick(View v){
				Intent intent=new Intent(RoomChat.this,RoomSearchActivity.class);
				startActivity(intent);
			}
		});
		
		
		lv_roomChat=(ListView)findViewById(R.id.lv_roomChat);
		lv_roomChat.setAdapter(new MyAdapter(this));
		lv_roomChat.setOnItemClickListener(new ListListener());
		
	}
	
	class ListListener implements  OnItemClickListener{

		
		@Override 
		public void onItemClick(AdapterView<?> arg0,View v,int position,long id){
			Intent intent=new Intent(RoomChat.this,RoomChatPage.class);
			startActivity(intent);
		}
		
	} 
	
	class MyAdapter extends BaseAdapter{
			LayoutInflater mInflater;
		public MyAdapter(Context context){
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
			
			iv_roomPic.setImageResource(R.drawable.default_pic);
			tv_roomNum.setText(roomNum[position]);
			tv_roomTheme.setText(roomTheme[position]);
			tv_population.setText(num[position]+"人");
			return convertView;
		}
	}


}
