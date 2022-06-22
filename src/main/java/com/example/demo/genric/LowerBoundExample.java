package com.example.demo.genric;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundExample {
	
	public static void print(List<? super Integer> list) 
	{
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		List<Number> l=new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		print(l);
	}

}
