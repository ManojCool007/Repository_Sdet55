package com.parctice;

import java.util.Random;

public class RandonTest {

	public static void main(String[] args) {
		Random ran=new Random();
		int rannum = ran.nextInt(10000);
		System.out.println(rannum);

	}

}
