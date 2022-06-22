package com.example.demo.bean;

public class Class1 {
	private int id;
	
	private Class2 class2;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Class2 getClass2() {
		return class2;
	}

	public void setClass2(Class2 class2) {
		this.class2 = class2;
	}
	
	public  void hello()
	{
		System.out.println(class2.getId2());
	}

}
