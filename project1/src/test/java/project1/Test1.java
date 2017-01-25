package project1;

import static org.junit.Assert.*;

import org.ctk.project1.Main;
import org.junit.Test;


public class Test1 {
	
	private static final String ARRAY[] = new String[]{
			"127.0.0.1",
			"0.0.0.0",
			
			"255.255.255.255",
			"221.217.19.65",
			"238.232.120.84",
			"35.91.221.89",
			"197.222.168.98",
			"7.174.84.1",
			"81.82.242.10",
			"79.206.231.224",
			"147.244.112.113",
			"207.131.177.191",
			"109.43.20.143",
			"134.241.231.76",
			"208.144.173.215",
			"64.2.215.144",
			"83.203.153.161",
			"154.130.131.46",
			"119.242.159.72",
	};

	@Test
	public void test() {
		for(String in: ARRAY) {
			long value = Main.ip2long(in);
			String out = Main.long2ip(value);
			assertEquals(in, out);
		}
	}

}
