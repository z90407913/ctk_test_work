package project2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.ctk.project2.Main;
import org.ctk.project2.PhoneTable;
import org.junit.Test;

public class Test1 {
	
	private static final String[] INPUT_ARRAY = new String[]{
			"Иванов И.И.", "Петров П.П.", "Сидоров С.С."
	};
	
	private static final String[][] OUTPUT_ARRAY = new String[][]{
			{"+8 800 2000 500", "+8 800 200 600"},
			{"+8 800 2000 700"},
			{"+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000"}
	};

	@Test
	public void test() {
		final PhoneTable table = new PhoneTable();
		Main.init(table);
		for(int i = 0; i < INPUT_ARRAY.length; i++) {
			Collection<String> output = table.get(INPUT_ARRAY[i]);
			assertNotNull(output);
			HashSet<String> si = new HashSet<String>(Arrays.asList(OUTPUT_ARRAY[i]));
			HashSet<String> so = new HashSet<String>(output);
			assertEquals(si, so);
		}
	}

}
