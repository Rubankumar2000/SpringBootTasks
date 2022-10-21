package org.interf;

interface InterClass {
	public static int min=5;
	public static void method1() {
		System.out.println("Interface concept");
	}
	private void method2() {
	}
	public void method3();

}

public abstract class Interf implements InterClass {
	public static void main(String[] args) {
		System.out.println("Interface");
		InterClass.method1();
		System.out.println(InterClass.min);
	}
	public void method2() {
		
	}
}