package listDemo;

import java.util.ArrayList;
import java.util.List;

class Demo{
	
	int i;
	String name;
	public Demo(int i, String name) {
		super();
		this.i = i;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Demo [i=" + i + ", name=" + name + "]";
	}
	
}


public class Test {


	public static void main(String[] args) {
		Demo d1=new Demo(1, "a");
		Demo d2=new Demo(1, "b");
		
		
		List<Demo>d=new ArrayList<>();
		d.add(d1);
		d.add(d2);
		
		System.out.println(d);

	}

}
