package com.kaikeba.demo1;

public class Demo8 {

	public static void main(String[] args) {
		//外层循环控制的是 行数
		for(int i=0;i<10;i++) {
			//System.out.println("* * * * * * * * * *");
			//内层循环控制的是列数
			for(int j=0;j<10;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
