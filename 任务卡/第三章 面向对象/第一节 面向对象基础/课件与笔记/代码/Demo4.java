package com.kaikeba.demo2;

public class Demo4 {

	public static void main(String[] args) {
		//System.out.println("1");
		Person2 p1 = new Person2("张三");
		//System.out.println("2");
		//p1.name  = "张三";
		p1.age = 18;
		p1.say();
	}

}
class Person2{
	
	Person2(String n){
		name = n;
	}
	
	
	String name;
	int age;
	
	void say() {
		System.out.println("自我介绍。我是:"+name+" , 我的年龄:"+age);
	}
}