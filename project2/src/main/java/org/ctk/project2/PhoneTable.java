package org.ctk.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class PhoneTable {
	private final HashMap<String, ArrayList<String>> hashMap;
	
	public PhoneTable() {
		hashMap = new HashMap<String, ArrayList<String>>();
	}
	
	public Collection<String> get(String name) {
		Collection<String> c = hashMap.get(name);
		if(c == null)
			return null;
		return Collections.unmodifiableCollection(c);
	}
	
	public void init(String[][] input) {
		for(String[] array: input) {
			hashMap.put(array[0], new ArrayList<String>(Arrays.asList(array).subList(1, array.length)));
		}
	}
}
