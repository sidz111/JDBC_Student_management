package com.siddhu.basic.validation;

public class MyValidation {
	public static boolean checkRoll(Integer roll) {
		if(roll>=0) {
			return true;
		}
		return false;
	}
	
	public static boolean checkName(String name) {
		for(int i=0; i<name.length(); i++) {
			if(name.charAt(i)>48 && name.charAt(i)<57) {
				return false;
			}
		}
		return true;
	}
}
