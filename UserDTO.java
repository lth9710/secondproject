package com.project2;

import java.io.Serializable;



public class UserDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String gender;
	private String email;
	private String pw;
	private String birth;
	private String tel;

	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String toString(){
		
		String str ="";
		String genderp ="";
		if("m".equals(gender)){
			genderp="남자";
		}else if("f".equals(gender)){
			genderp="여자";
		}
		
		
		str=String.format("%10s\t%5s\t\t%3s\t%14s\t%25s",id,name,genderp,tel,email);
		return str; 
		 
	}



/*//public String userId;
	private String id;
	private String name;
	private String gender;
	private String email;
	private String pw;
	private String birth;
	private String tel;*/
	
	
}
