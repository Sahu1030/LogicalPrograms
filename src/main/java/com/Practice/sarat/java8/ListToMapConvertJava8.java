package com.Practice.sarat.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapConvertJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<User> userList = new ArrayList<>();
		userList.add(new User("1","Sarat"));
		userList.add(new User("2","Bharat"));
		Map<String,User> map=userList.stream().collect(Collectors.toMap(User :: getId, user->user));
		System.out.println(map);
	}

}

 class User{
	   String id;
	   String name;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	   
	}
