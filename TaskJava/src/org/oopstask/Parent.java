package org.oopstask;

public abstract class Parent {
	public void method() {
		System.out.println("Child class");
	}
	public static void main(String[] args) {
		B.method1();
		B b=new B();
		b.method();
		
		
		
	}

}
