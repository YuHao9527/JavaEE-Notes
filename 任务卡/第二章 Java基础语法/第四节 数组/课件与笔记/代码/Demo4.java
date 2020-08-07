package com.kaikeba.demo1;

public class Demo4 {

	/**
	 * 冒泡排序
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {20,15,18,13,30,60};
		int temp;
		//外层循环控制的是， 比较的轮数。
		//外层循环次数： length-1
		for(int i=0;i<nums.length-1;i++) {
			//内层循环控制的是，每轮比较的次数
			//第i轮（i从0开始计算）， 比较次数为：length-i-1
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					//两两相比， 满足移动条件
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
		
		//排序已经完成。 下面是遍历打印查看的过程
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
		
		
		
	}

}
