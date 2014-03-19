package com.miao.roomchat;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.miao.main.R;

public class RoomChatPage extends Activity {

	private ListView lv_roomChatPage;
	private int[] test={0,0,0,1,0,0,1,0,1};
	private ImageButton ib_back,ib_roomMenu;
	private Button btn_requestSpeech;
	private Button btn_endSpeech;
	private MediaRecorder mr;
	private MediaPlayer mp;
	private String savedPath;
	private ArrayList<ChatInfo> chatData=new ArrayList<ChatInfo>();
	private MyAdapter myAdapter;
	private int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_room_chat_page);
		
		
		btn_requestSpeech=(Button)findViewById(R.id.btn_requestSpeech);
		btn_requestSpeech.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				String time=new DateFormat().format("hh:mm:ss", Calendar.getInstance(Locale.CHINESE))+"";
				Toast.makeText(getApplicationContext(), "开始录音...", Toast.LENGTH_SHORT).show();
				savedPath=getSavedDirectory();
				recordAudio(savedPath);
				ChatInfo entity=new ChatInfo();
				entity.setAudioPath(savedPath);
				entity.setTime(time);
				entity.setHeadPath("");
				entity.setUserName("我");
				entity.setMsgType(false);
				
				chatData.add(entity);
				
				
			}
		});
		
		btn_endSpeech=(Button)findViewById(R.id.btn_endSpeech);
		btn_endSpeech.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				stopRecord();
				sendAudio();
				myAdapter.notifyDataSetChanged();
				lv_roomChatPage.setSelection(chatData.size()-1);
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
		myAdapter=new MyAdapter(this,chatData);
		lv_roomChatPage.setAdapter(myAdapter);
		lv_roomChatPage.setOnItemClickListener(new ListItemClickListener());
		
	}

	

	public String getSavedDirectory(){ // 创建并返回存储文件父目录
		String path;
		if(!Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			path=this.getCacheDir()+"/Audio/";
			Toast.makeText(getApplicationContext(),"SD卡不存在",Toast.LENGTH_SHORT).show();
		}
		else{ 
			path=Environment.getExternalStorageDirectory()+"/Audio/";
			Toast.makeText(getApplicationContext(),"SD卡存在",Toast.LENGTH_SHORT).show();
            System.out.println("saved path : "+path );
		}
		File folder=new File(path);
		if(!folder.exists()){
			System.out.println("is successful? "+folder.mkdirs());
		}
		System.out.println("is folder exists ? path:"+path +folder.exists());
		return path +getTime()+".amr";
	}
	
	public void recordAudio(String path){
		
		mr=new MediaRecorder();
		mr.setAudioSource(MediaRecorder.AudioSource.MIC);
		mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		mr.setOutputFile(path);
		
		try{
			System.out.println(path);
			File file=new File(path);
			file.createNewFile();
			System.out.println("is file exists ? " +file.exists());
			mr.prepare();
			mr.start();
		}
		catch(Exception e){
			Toast.makeText(getApplicationContext(), "录音异常", Toast.LENGTH_SHORT).show();
			Log.v("recordAudio", "录音异常");
		}
	}
	
	public void stopRecord(){
		if(mr!=null){
			System.out.println("stop");
			mr.stop();
			System.out.println("reset");
			mr.reset();
			System.out.println("release");
			mr.release();
			
			mr=null;
			Toast.makeText(getApplicationContext(), "录音结束", Toast.LENGTH_SHORT).show();

		}
		else 
			Toast.makeText(getApplicationContext(), "不在录音状态", Toast.LENGTH_SHORT).show();

	}
	
	@SuppressWarnings("static-access")
	public String getTime(){
		String time;
		time=new DateFormat().format("yyyyMMdd_hhmmss",Calendar.getInstance(Locale.CHINESE))+"";
		return time;
	}
	
	
	public void sendAudio(){
		Toast.makeText(getApplicationContext(), "未连接服务，暂时无法发送", Toast.LENGTH_SHORT).show();
	}
	
	public void playAudio(String path) throws Exception{
		
		if(mp!=null){
			mp.stop();
			mp.reset();
			File file=new File(path);
			FileInputStream fis=new FileInputStream(file);
			mp.setDataSource(fis.getFD());
			mp.prepare();
			mp.start();
		}
		else {
			mp=new MediaPlayer();
			mp.reset();
			File file=new File(path);
			FileInputStream fis=new FileInputStream(file);
			mp.setDataSource(fis.getFD());
			mp.prepare();
			mp.start();
		}
	}
	
	class ListItemClickListener implements OnItemClickListener{
		
		 @Override
		 public void onItemClick( AdapterView<?> arg,View v,int position,long id ){
			 Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_SHORT).show();
		 }
	}
	
	protected class ViewHolder{
		private ImageView iv_head;
		private TextView tv_name;
		private TextView tv_speechTime;
		private TextView tv_audio;
	}
	
	
	class MyAdapter extends BaseAdapter{
		
		private LayoutInflater mInflater;
		private ArrayList<ChatInfo> data;
		
		public  MyAdapter(Context context,ArrayList<ChatInfo> data){
			this.mInflater=LayoutInflater.from(context);
			this.data=data;
		}
		
		@Override 
		public int getCount(){
			return data.size();
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
			index=position;
			if(convertView==null){
				holder=new ViewHolder();
			if(data.get(position).getMsgType()){
				convertView=mInflater.inflate(R.layout.user_chat, null);
				holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_userHead);
				holder.tv_name=(TextView)convertView.findViewById(R.id.tv_userName);
				holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_uSpeechTime);
				holder.tv_audio=(TextView)convertView.findViewById(R.id.tv_userAudio);
			}
			else {
				convertView=mInflater.inflate(R.layout.i_chat, null);
				holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_myHead);
				holder.tv_name=(TextView)convertView.findViewById(R.id.tv_myName);
				holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_mySpeechTime);
				holder.tv_audio=(TextView)convertView.findViewById(R.id.tv_myAudio);
			}
			
			convertView.setTag(holder);
			}
			
			else {
				holder=(ViewHolder)convertView.getTag();
			}
			holder.iv_head.setImageResource(R.drawable.head_img);
			holder.tv_name.setText( data.get(position).getUserName());
			holder.tv_speechTime.setText(data.get(position).getTime());
			holder.tv_audio.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v){
					try {
						
						Toast.makeText(getApplicationContext(), lv_roomChatPage.getSelectedItemPosition()+"正在播放...", Toast.LENGTH_SHORT).show();
						System.out.println(data.get(index).getAudioPath());
						playAudio(data.get(lv_roomChatPage.getSelectedItemPosition()).getAudioPath());
						System.out.println("播放中...");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			return convertView;
		}
	}

}
