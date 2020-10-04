package com.kaikeba.demo1;

public class Demo10 {

	/**
	 * 如何退出多重循环
	 * @param args
	 */
	public static void main(String[] args) {
		haha:for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.println("i="+i+" , j="+j);
				if(i==5 && j==5) {
					break haha;
				}
			}
		}
	}
}
