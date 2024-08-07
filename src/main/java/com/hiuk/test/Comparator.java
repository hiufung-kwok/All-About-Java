package com.hiuk.test;

import org.apache.commons.lang3.ObjectUtils;

public class Comparator {
	public static void main(String[] args) {
		Long l = 11l;
		Long l2 = 112l;
		System.out.println(l2.compareTo(l));
		System.out.println(ObjectUtils.compare(l2, l) );
	}
}
