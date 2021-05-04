package com.prabutdr.study.maths;

import java.math.BigInteger;

public class GCD {

	public static int gcdUsingRecursion(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcdUsingBigInteger(b, a % b);
	}
	
	public static int gcdUsingBigInteger(int a, int b) {
		BigInteger ba = BigInteger.valueOf(a);
		BigInteger bb = BigInteger.valueOf(b);
		BigInteger gcd = ba.gcd(bb);
		
		return gcd.intValue();
	}
}
