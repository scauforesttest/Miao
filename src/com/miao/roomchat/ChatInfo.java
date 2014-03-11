package com.miao.roomchat;

public class ChatInfo {
	private String time;
	private String headPath;
	private String audioPath;
	private String userName;
	private boolean isComeMessage;
	
	
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
	
	public void setMsgType(boolean bool){
		isComeMessage=bool;
	}
	
	public boolean getMsgType(){
		return isComeMessage;
	}
}
