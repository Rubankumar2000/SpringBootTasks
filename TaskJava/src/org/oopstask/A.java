package org.oopstask;

 class P {
	 public static String method1() {
		 System.out.println("parent class");
		return null;
	 }

 }
 class C extends P {
	 public static String method1() {
		 System.out.println("child class");
		return null;
	 }
//	 public String method1(int n) {
//		 System.out.println("child class"+n);
//		return null;
//	 }
	 
 }
 
 class A extends C{
	 public static String method1() {
		 System.out.println("main class");
		 return null;
	 }
	 
		public static void main(String[] args) {
			P p=new P();
			p.method1();
			C c=new C();
			c.method1();
			P p1=new C();
			p1.method1();
			A a=new A();
			a.method1();
			C c1=new A();
			c1.method1();
			
		}
	}
