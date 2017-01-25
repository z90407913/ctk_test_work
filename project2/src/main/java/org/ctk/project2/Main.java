package org.ctk.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		PhoneTable pt = new PhoneTable();
		init(pt);
		System.out.print("Name:\r\n");
		String input = reader.readLine();
		if(input != null)
			input = input.trim();
		Collection<String> r = pt.get(input);
		if(r == null || r.isEmpty()) {
			System.out.println("not found");
		} else {
			int index = 0;
			for (Iterator<String> it = r.iterator(); it.hasNext();) {
				System.out.printf("%d. %s\r\n", ++index, it.next());
			}
		}
	}

	public static void init(PhoneTable table) {
		table.init(new String[][]{
			{ "Иванов И.И.",
				"+8 800 2000 500", "+8 800 200 600"},
			{ "Петров П.П.",
					"+8 800 2000 700"},
			{ "Сидоров С.С.",
					"+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000"},
		});
	}
}
