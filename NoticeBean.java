package com.bean;
public class NoticeBean {
	private String title;
	private String re_data;
	private String content;
	private String author;
	private int ID;	
	public int getID(){
		return ID;
	}
	public void setID(int ID){
		this.ID=ID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRe_data() {
		return re_data;
	}
	public void setRe_data(String re_data) {
		this.re_data = re_data;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}	
}
