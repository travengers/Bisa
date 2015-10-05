package com.example.bisa.models;

import java.io.Serializable;

import android.R.string;

public class Tweet implements Serializable{
	string id;
	String body;
	String title;
	public string getId() {
		return id;
	}
	public void setId(string id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String string) {
		this.body = string;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String string) {
		this.title = string;
	}
	
}
