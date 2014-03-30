package com.miao.roomchat;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
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
import com.miao.util.Base64;

public class RoomChatPage extends Activity {

	private boolean isSpeakingMode=false;
	private EditText et_inputChat;
	private ImageButton ib_back,ib_roomMenu;
	private Button btn_requestSpeech;
	private Button btn_endSpeech;
	private Button btn_roomChatSend;
	private MediaRecorder mr;
	private MediaPlayer mp;
	private String savedPath;
	private ArrayList<ChatInfo> chatData=new ArrayList<ChatInfo>();
	private MyAdapter myAdapter;
	private ChatTypeAdapter chatTypeAdapter;
	private ListView lv_chatMode;
	private ListView lv_roomChatPage;
	private InputMethodManager imm;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_room_chat_page);



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
				stopAll();
				RoomChatPage.this.finish();
			}

		});

		
		lv_roomChatPage=(ListView)findViewById(R.id.lv_roomChatPage);
		myAdapter=new MyAdapter(this,chatData);
		lv_roomChatPage.setAdapter(myAdapter);
		lv_roomChatPage.setOnItemClickListener(new ListItemClickListener());

		lv_chatMode=(ListView)findViewById(R.id.lv_chatMode);
		chatTypeAdapter=new ChatTypeAdapter(this);
		lv_chatMode.setAdapter(chatTypeAdapter);
	}

	public String getSavedDirectory(){ // ���������ش洢�ļ���Ŀ¼
		String path;
		if(!Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			path=this.getCacheDir()+"/Audio/";
		}
		else{ 
			path=Environment.getExternalStorageDirectory()+"/Audio/";
		}
		File folder=new File(path);
		if(!folder.exists()){
			 folder.mkdirs();
		}
		// System.out.println("is folder exists ? path:"+path +folder.exists());
		return path +getTime()+".amr";
	}

	public void recordAudio(String path){

		if(mr!=null){
			Toast.makeText(getApplicationContext(), "�Ѿ���¼��״̬�ˣ���ҪƵ�����Һ�...", Toast.LENGTH_SHORT).show();
			return ;
		}
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
			Toast.makeText(getApplicationContext(), "¼���쳣", Toast.LENGTH_SHORT).show();
			Log.v("recordAudio", "¼���쳣");
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
			Toast.makeText(getApplicationContext(), "¼�����������Է���...", Toast.LENGTH_SHORT).show();

		}
		else 
			Toast.makeText(getApplicationContext(), "����¼��״̬", Toast.LENGTH_SHORT).show();

	}

	@SuppressWarnings("static-access")
	public String getTime(){
		String time;
		time=new DateFormat().format("yyyyMMdd_hhmmss",Calendar.getInstance(Locale.CHINESE))+"";
		return time;
	}

	public void sendAudio(){
		//Toast.makeText(getApplicationContext(), "����...", Toast.LENGTH_SHORT).show();
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

	public void stopAll(){
		
		if(mp!=null){
			if(mp.isPlaying()){
				mp.stop();
				mp.reset();
				mp.release();
				mp=null;
			}
			else {
				mp=null;
			}
			Toast.makeText(getApplicationContext(), "����ֹͣ", Toast.LENGTH_SHORT).show();
		}
		if(mr!=null){
			mr.stop();
			mr.reset();
			mr.release();
			mr=null;
			Toast.makeText(getApplicationContext(), "¼��ֹͣ", Toast.LENGTH_SHORT).show();
		}
		
	} 
	
	@Override
	public boolean  onKeyDown(int keyCode , KeyEvent event){
		super.onBackPressed();
		if(keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0){
			
			stopAll();
			return false ;
		}
		
		return false  ;
		
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
		public int getViewTypeCount(){
			return 4;
		}
		
		@Override
		public int getItemViewType(int position){
			if(data.get(position).getMsgType().equals("userAudio"))
			return 0;
			else if(data.get(position).getMsgType().equals("myAudio"))
				return 1;
			else if(data.get(position).getMsgType().equals("userText"))
				return 2;
			else if(data.get(position).getMsgType().equals("myText")) 
				return 3;
			return -1;
		}
		
		@Override
		public View getView(int position,View convertView,ViewGroup parent){
//			ViewHolder holder=null;
//			index=position;
//			if(convertView==null){
//				holder=new ViewHolder();
//				if(data.get(position).getMsgType().equals("userAudio")){  // ��Ϣ��ԴΪ  ����
//					convertView=mInflater.inflate(R.layout.user_chat_audio, null);
//					holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_userHead);
//					holder.tv_name=(TextView)convertView.findViewById(R.id.tv_userName);
//					holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_uSpeechTime);
//					holder.tv_audio=(TextView)convertView.findViewById(R.id.tv_userAudio);
//					
//					holder.tv_audio.setOnClickListener(new OnClickListener(){
//						@Override
//						public void onClick(View v){
//							try {
//								
//								Toast.makeText(getApplicationContext(), lv_roomChatPage.getSelectedItemPosition()+"���ڲ���...", Toast.LENGTH_SHORT).show();
//								System.out.println(data.get(index).getAudioPath());
//								playAudio(data.get(index).getAudioPath());
//								System.out.println("������...");
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					});
//				}
//				else if(data.get(position).getMsgType().equals("myAudio")){     // ��Ϣ��ԴΪ  ����
//					convertView=mInflater.inflate(R.layout.i_chat_audio, null);
//					holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_myHead);
//					holder.tv_name=(TextView)convertView.findViewById(R.id.tv_myName);
//					holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_mySpeechTime);
//					holder.tv_audio=(TextView)convertView.findViewById(R.id.tv_myAudio);
//					
//					holder.tv_audio.setOnClickListener(new OnClickListener(){
//						@Override
//						public void onClick(View v){
//							try {
//								
//								Toast.makeText(getApplicationContext(), lv_roomChatPage.getSelectedItemPosition()+"���ڲ���...", Toast.LENGTH_SHORT).show();
//								System.out.println(data.get(index).getAudioPath());
//								playAudio( data.get(index).getAudioPath());
//								System.out.println("������...");
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					});
//					
//				}
//				else if(data.get(position).getMsgType().equals("userText")){
//					convertView=mInflater.inflate(R.layout.user_chat_text, null);
//					holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_userHead);
//					holder.tv_name=(TextView)convertView.findViewById(R.id.tv_userName);
//					holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_uSpeechTime);
//					holder.tv_audio=(TextView)convertView.findViewById(R.id.tv_userText);
//					holder.tv_audio.setText(data.get(position).getContent());
//				}
//				else if(data.get(position).getMsgType().equals("myText")){
//					convertView=mInflater.inflate(R.layout.i_chat_text, null);
//					holder.iv_head=(ImageView)convertView.findViewById(R.id.iv_myHead);
//					holder.tv_name=(TextView)convertView.findViewById(R.id.tv_myName);
//					holder.tv_speechTime=(TextView)convertView.findViewById(R.id.tv_mySpeechTime);
//					holder.tv_audio=(TextView)convertView.findViewById(R.id.tv_myText);
//					holder.tv_audio.setText(data.get(position).getContent());
//				}
//
//				convertView.setTag(holder);
//			}
//
//			else {
//				holder=(ViewHolder)convertView.getTag();
//			}
//			holder.iv_head.setImageResource(R.drawable.head_img);
//			holder.tv_name.setText( data.get(position).getUserName());
//			holder.tv_speechTime.setText(data.get(position).getTime());
//
//			return convertView;
			
			ImageView iv_head;
			TextView tv_name;
			TextView tv_speechTime;
			TextView tv_audio;
		 
			//index=data.get(position).getIndex();
			
			
				if(data.get(position).getMsgType().equals("userAudio")){  // ��Ϣ��ԴΪ  ����
					convertView=mInflater.inflate(R.layout.user_chat_audio, null);
					iv_head=(ImageView)convertView.findViewById(R.id.iv_userHead);
					tv_name=(TextView)convertView.findViewById(R.id.tv_userName);
					tv_speechTime=(TextView)convertView.findViewById(R.id.tv_uSpeechTime);
					tv_audio=(TextView)convertView.findViewById(R.id.tv_userAudio);
					tv_audio.setTag(position);
					tv_audio.setOnClickListener(new OnClickListener(){
						@Override
						public void onClick(View v){
							try {
								final int pos=(Integer)v.getTag();
								Toast.makeText(getApplicationContext(), pos+" ���ڲ���...", Toast.LENGTH_SHORT).show();
								System.out.println(data.get(pos).getAudioPath());
								playAudio(data.get(pos).getAudioPath());
								System.out.println("������...");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				}
				else if(data.get(position).getMsgType().equals("myAudio")){     // ��Ϣ��ԴΪ  ����
					convertView=mInflater.inflate(R.layout.i_chat_audio, null);
					iv_head=(ImageView)convertView.findViewById(R.id.iv_myHead);
					tv_name=(TextView)convertView.findViewById(R.id.tv_myName);
					tv_speechTime=(TextView)convertView.findViewById(R.id.tv_mySpeechTime);
					tv_audio=(TextView)convertView.findViewById(R.id.tv_myAudio);
					
					// ͨ��setTag ��������ǣ�һ�߲���¼��ʱ����ȷ�ҵ���Ӧ��¼���ļ�����
					tv_audio.setTag(position);
					tv_audio.setOnClickListener(new OnClickListener(){
						@Override
						public void onClick(View v){
							try {
								
								// ��ȡ֮ǰ���ı�ǣ�ΪѰ��¼���ļ��ṩ�����±�
								final int pos=(Integer)v.getTag();  
								
								Toast.makeText(getApplicationContext(), pos+" ���ڲ���...", Toast.LENGTH_SHORT).show();
								System.out.println(data.get(pos).getAudioPath());
								playAudio( data.get(pos).getAudioPath());
								System.out.println("������...");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					
				}
				else if(data.get(position).getMsgType().equals("userText")){
					convertView=mInflater.inflate(R.layout.user_chat_text, null);
					iv_head=(ImageView)convertView.findViewById(R.id.iv_userHead);
					tv_name=(TextView)convertView.findViewById(R.id.tv_userName);
					tv_speechTime=(TextView)convertView.findViewById(R.id.tv_uSpeechTime);
					tv_audio=(TextView)convertView.findViewById(R.id.tv_userText);
					tv_audio.setText(data.get(position).getContent());
				}
				else {
					convertView=mInflater.inflate(R.layout.i_chat_text, null);
					iv_head=(ImageView)convertView.findViewById(R.id.iv_myHead);
					tv_name=(TextView)convertView.findViewById(R.id.tv_myName);
					tv_speechTime=(TextView)convertView.findViewById(R.id.tv_mySpeechTime);
					tv_audio=(TextView)convertView.findViewById(R.id.tv_myText);
					tv_audio.setText(data.get(position).getContent());
				}

				

			
			iv_head.setImageResource(R.drawable.head_img);
			tv_name.setText( data.get(position).getUserName());
			tv_speechTime.setText(data.get(position).getTime());

			return convertView;
			
			
			
		}
	}

	class ChatTypeAdapter extends BaseAdapter {

		LayoutInflater mInflater ;

		public ChatTypeAdapter(Context context){

			this.mInflater=LayoutInflater.from(context);
		}

		public int getCount()
		{
			return 1;
		}

		public long getId(int position){
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		public Object getItem(int position ){

			return null;
		}

		// ���ز����ļ��������������Ҫ
		@Override
		public int getViewTypeCount(){
			return 2;
		}

		// ����ÿ��Item��Ĳ������ͣ�����getView�����ã�
		@Override
		public int getItemViewType(int position){

			if(isSpeakingMode){
				return 0;
			}
			else {
				return 1;
			}
		}
		public View getView(int position, View convertView,ViewGroup parent){

			if(isSpeakingMode){
				Toast.makeText(getApplicationContext(), "����ģʽ", Toast.LENGTH_SHORT).show();
				convertView=mInflater.inflate(R.layout.speaking_style, null);
				ImageButton ib_toKeyboard=(ImageButton)convertView.findViewById(R.id.ib_toKeyboard);
				ib_toKeyboard.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v){
						//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
						isSpeakingMode=false;
						chatTypeAdapter.notifyDataSetChanged();
					}
				});

				btn_requestSpeech=(Button)convertView.findViewById(R.id.btn_requestSpeech);
				btn_requestSpeech.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v){
						if(mr!=null){
							Toast.makeText(getApplicationContext(), "�Ѿ���¼��״̬�ˣ���ҪƵ�����Һ�...", Toast.LENGTH_SHORT).show();
							return ;
						}
						String time=new DateFormat().format("hh:mm:ss", Calendar.getInstance(Locale.CHINESE))+"";
						savedPath=getSavedDirectory();
						recordAudio(savedPath);
						ChatInfo entity=new ChatInfo();
						entity.setAudioPath(savedPath);
						entity.setTime(time);
						entity.setHeadPath("");
						entity.setUserName("��");
						entity.setContent("");
						entity.setMsgType("myAudio");   // ������Ϣ��ԴΪ����
						entity.setChatType(true);   // ������Ϣ����Ϊ����
						entity.setIndex(chatData.size()); // �������������Ϣ��chatData�е��±꣬�Ա㲥��ʱѰ��

						chatData.add(entity);


					}
				});

				btn_endSpeech=(Button)convertView.findViewById(R.id.btn_endSpeech);
				btn_endSpeech.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v){
						String code="";
						stopRecord(); 
						sendAudio();
						myAdapter.notifyDataSetChanged();
						lv_roomChatPage.setSelection(chatData.size()-1);
					}
				});

			}
			else {
				Toast.makeText(getApplicationContext(), "�ı�ģʽ", Toast.LENGTH_SHORT).show();
				convertView=mInflater.inflate(R.layout.keboard_style,null);
				ImageButton ib_toSpeaking=(ImageButton)convertView.findViewById(R.id.ib_toSpeaking);
				ib_toSpeaking.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v){
						//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
						isSpeakingMode=true ;
						chatTypeAdapter.notifyDataSetChanged();

					}

				});

				et_inputChat=(EditText)convertView.findViewById(R.id.et_inputChat);

				btn_roomChatSend=(Button)convertView.findViewById(R.id.btn_roomChatSend);
				btn_roomChatSend.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v){
						String time=new DateFormat().format("hh:mm:ss", Calendar.getInstance(Locale.CHINESE))+"";
						
						ChatInfo entity=new ChatInfo();
						entity.setAudioPath("");
						entity.setTime(time);
						entity.setHeadPath("");
						entity.setUserName("��");
						entity.setContent(et_inputChat.getText().toString());
						entity.setMsgType("myText");   // ������Ϣ��ԴΪ����
						entity.setChatType(false);   // ������Ϣ����Ϊ�ı�
						entity.setIndex(chatData.size());  // �������������Ϣ��chatData�е��±꣬�Ա㲥��ʱѰ��
						
						chatData.add(entity);
						myAdapter.notifyDataSetChanged();
						lv_roomChatPage.setSelection(chatData.size()-1);
						et_inputChat.setText("");
						imm=(InputMethodManager)getSystemService(Service.INPUT_METHOD_SERVICE);
						imm.hideSoftInputFromWindow(et_inputChat.getWindowToken(),0);

					}
				});
			}



			return convertView;
		}



	}


}
