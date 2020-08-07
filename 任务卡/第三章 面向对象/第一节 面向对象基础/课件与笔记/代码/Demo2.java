package com.kaikeba.demo2;

public class Demo2 {

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		b1.name = "金苹果";
		b1.info = "讲述了果农种植金色苹果的辛勤路程。";
		b2.name = "银苹果";
		b2.info = "讲述了果农种植银色苹果的辛勤路程。";
		
		b1.say();
		b2.say();
		
	}

}
/*
class Book{
	String name;
	String info;
	
	void say() {
		System.out.println("书名："+name+" , 简介："+info);
	}
}
*/