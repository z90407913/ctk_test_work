package org.ctk.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("IP 1:\r\n");
		long value = ip2long(reader.readLine());
		System.out.print("IP 2:\r\n");
		long to = ip2long(reader.readLine());
		System.out.print("IP list:\r\n");
		value++;
		while(value < to) {
			if((value & 0xFF) != 0 && (value & 0xFF) != 0xFF) {
				System.out.println(long2ip(value));
			}
			value++;
		}
	}
	
	public static long ip2long(String value) {
		if(value == null) {
			throw new NullPointerException();
		}
		String b[] = value.split("\\.");
		if(b == null || b.length != 4) {
			throw new IllegalArgumentException("IP Format error");
		}
		long lv = 0l;
		for(int i=0; i<b.length; i++) {
			long bv = 0;
			try {
				bv = Integer.parseInt(b[i]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("IP Format error", e);
			}
			if((bv & 0xFF) != bv) {
				throw new IllegalArgumentException("IP Format error");
			}
			lv |= bv << ((3 - i) * Byte.SIZE);
		}
		return lv;
	}
	
	public static String long2ip(long value) {
		StringBuilder b = new StringBuilder(16);
		for(int i = 0; i < 4; i++) {
			b.append(Long.toString((value >> (3 - i) * 8) & 0xFF));
			if(i < 3) {
				b.append('.');
			}
		}
		return b.toString();
	}
}
