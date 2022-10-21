package org.exception;

import java.util.Iterator;
import java.util.Scanner;

public class ExceptionProgram {
	public int m=10;
	public static void main(String[] args) {
//		int num=10/1;
//		System.out.println(num);
		
//		String str=null;
//		System.out.println(str);
		
//		int[] arr= {12,13,11,45,76};
//		System.out.println(arr[5]);
		
//		String n="23,23";
//		System.out.println(Integer.parseInt(n));
		
		Scanner sc=new Scanner(System.in);
		
//		try {
//			int number=sc.nextInt();
//			System.out.println(number);
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
		
		String s="String buffer and builder";
		System.out.println(s);
		System.out.println(System.identityHashCode(s));
		StringBuffer sb=new StringBuffer(sc.next());
		System.out.println(sb);
		System.out.println(System.identityHashCode(sb));
		StringBuilder str=new StringBuilder(sc.next().concat(s));
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		sb.append(s);
		sb.append(str);
		System.out.println(System.identityHashCode(sb));
		System.out.println(sb.reverse());
		System.out.println(System.identityHashCode(sb));
		sb.append(str+"Welcome");
		System.out.println(System.identityHashCode(str));
		System.out.println(str);
		System.out.println(System.identityHashCode(sb));
		
	
	}
	

}
