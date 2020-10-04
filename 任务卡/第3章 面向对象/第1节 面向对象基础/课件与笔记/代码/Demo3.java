package com.kaikeba.demo2;

/**
 * 对象创建的内存细节
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.name = "金苹果";
		b1.info = "讲述了果农辛勤种植金苹果的过程。";
		
		Book b2 = new Book();
		b2.name = "银苹果";
		b2.info = "讲述了果农辛勤种植银苹果的过程。";
		
		b2 = b1;
		b2.name = "铜苹果";
		b1.say();
	}

}

class Book{
	String name;
	String info;
	
	void say() {
		System.out.println("书名："+name+" , 简介："+info);
	}
}


