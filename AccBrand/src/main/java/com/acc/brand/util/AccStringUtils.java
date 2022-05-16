package com.acc.brand.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccStringUtils {
	public static Boolean containSpecialCharacter(String s) {
		 boolean res=false;
	     Pattern p = Pattern.compile("[^A-Za-z0-9]");
	     Matcher m = p.matcher(s);
	     boolean b = m.find();
	     if (b)
	    	 res=true;
	     return res;
	 }
}
