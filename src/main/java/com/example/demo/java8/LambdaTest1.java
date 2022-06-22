package com.example.demo.java8;


interface Service1 {
	void method1();
	
}
interface Service2 {
	double sqr(int n);
	
}

public class LambdaTest1 {

//	@Override
//	public void method1() {
//		System.out.println("I'm method1");
//		
//	}

	public static void main(String[] args) {
//		Service1 s = () -> System.out.println("I'm method1");
//		s.method1();
		
		Service2 sqrt=(n) -> Math.sqrt(n)	;
		double d=sqrt.sqr(3);
		System.out.println(d);
	}
}