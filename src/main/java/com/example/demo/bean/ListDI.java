package com.example.demo.bean;

import java.util.List;

public class ListDI {
	private List<String> l1;
	private List<String> l2;
	
	private List<String> l3;
	private List<String> l4;
	
	
	public List<String> getL1() {
		return l1;
	}
	public void setL1(List<String> l1) {
		this.l1 = l1;
	}
	public List<String> getL2() {
		return l2;
	}
	public void setL2(List<String> l2) {
		this.l2 = l2;
	}
	public List<String> getL3() {
		return l3;
	}
	public void setL3(List<String> l3) {
		this.l3 = l3;
	}
	public List<String> getL4() {
		return l4;
	}
	public void setL4(List<String> l4) {
		this.l4 = l4;
	}
	@Override
	public String toString() {
		return "ListDI [l1=" + l1 + ", l2=" + l2 + ", l3=" + l3 + ", l4=" + l4 + "]";
	}
	

}
