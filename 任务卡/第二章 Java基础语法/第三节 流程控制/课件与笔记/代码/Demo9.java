package com.kaikeba.demo1;

public class Demo9 {

	/**
	 * break与continue语句
	 * 		break是用于终止本轮所有次循环。即不执行本次循环中break后面的语句,直接跳出循环。
	 * 		continue是用于终止本轮本次循环。即本次循环中continue后面的代码不执行,进行下一次循环的入口判断。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			if(i==5) {
				continue;
			}
			System.out.println(i);
		}
	}

}
