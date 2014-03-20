package com.miao.roomchat;

public class ChatInfo {
	private String time;
	private String headPath;
	private String audioPath;
	private String userName;
	private String content;
	private String msgType;
	private boolean isVoiceMsg;
	private int index;
	
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setTime(String time ){
		this.time=time;
	}
	
	public String getTime(){
		return time;
	}
	
	public void setHeadPath(String headPath){
		this.headPath=headPath;
	}
	
	public String getHeadPath(){
		return headPath;
	}
	
	public void setAudioPath(String audioPath){
		this.audioPath=audioPath;
	}
	public String  getAudioPath(){
		return audioPath;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setMsgType(String  msg){
		msgType=msg;
	}
	
	public String getMsgType(){
		return msgType;
	}
	
	public void setChatType(boolean bool){
		this.isVoiceMsg=bool;
	}
	
	public boolean getChatType(){
		return isVoiceMsg;
	}
	
	public void setIndex(int index){
		this.index=index;
		
	}
	
	public int getIndex(){
		return this.index;
	}
}
