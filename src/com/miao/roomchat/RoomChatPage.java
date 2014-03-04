package com.miao.roomchat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.miao.main.R;

public class RoomChatPage extends Activity {

	private ListView lv_roomChatPage;
	private int[] test={0,0,0,1,0,0,1,0,1};
	private ImageButton ib_back,ib_roomMenu;
	private Button btn_requestSpeech;
	private Button btn_endSpeech;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_room_chat_page);
		
		
		btn_requestSpeech=(Button)findViewById(R.id.btn_requestSpeech);
		btn_requestSpeech.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(getApplicationContext(), "抢话筒！", Toast.LENGTH_SHORT).show();
			}
		});
		
		btn_endSpeech=(Button)findViewById(R.id.btn_endSpeech);
		btn_endSpeech.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(getApplicationContext(), "讲完了！", Toast.LENGTH_SHORT).show();
			}
		});
		
		
		ib_roomMenu=(ImageButton)findViewById(R.id.ib_roomMenu);
		ib_roomMenu.setOnClickListener(new OnClickListener(){
			@Override 
			public void onClick(View v){
				Intent intent=new Intent(RoomChatPage.this,RoomInfoActivity.class);
				startActivity(intent);
			}
		});
		
		ib_back=(ImageButton)findViewById(R.id.ib_back);
		ib_back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RoomChatPage.this.finish();
			}
			
		});
		
		lv_roomChatPage=(ListView)findViewById(R.id.lv_roomChatPage);
		lv_roomChatPage.setAdapter(new MyAdapter(this));
		
	}

	protected class ViewHolder{
		private ImageView iv_head;
		private TextView tv_name;
		private TextView tv_speechTime;
	}
	class MyAdapter extends BaseAdapter{
		private LayoutInflater mInflater;
		public  MyAdapter(Context context){
			this.mInflater=LayoutInflater.from(context);
		}
		@Override 
		public int getCount(){
			return test.length;
		}
		
		@Override 
		public long getItemId(int position){
			return position;
		}
		
		@Override
		public Object getItem(int position){
			return null;
		}
		
		@Override
		public View getView(int position,View convertView,ViewGroup parent){
			ViewHolder holder=null;
			if(convertView==null){
				holder=new ViewHolder();
			if(test[position]==0){
				convertView=mInflater.inflate(R.layout.user_chat, null);
				holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_userHead);
				holder.tv_name=(TextView)convertView.findViewById(R.id.tv_userName);
				holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_uSpeechTime);
			}
			else {
				convertView=mInflater.inflate(R.layout.i_chat, null);
				holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_myHead);
				holder.tv_name=(TextView)convertView.findViewById(R.id.tv_myName);
				holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_mySpeechTime);

			}
			
			convertView.setTag(holder);
			}
			
			else {
				holder=(ViewHolder)convertView.getTag();
			}
			holder.iv_head.setImageResource(R.drawable.head_img);
			holder.tv_name.setText("用户***正在讲话...");
			holder.tv_speechTime.setText("2014-01-0"+position+" 00:00");
			return convertView;
		}
	}

}
