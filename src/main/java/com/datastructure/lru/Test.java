package com.datastructure.lru;

import java.util.LinkedHashMap;

public class Test {
	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16, .75f, true);

		map.put(1, 1);

		System.out.println(map);

		map.put(2, 2);

		System.out.println(map);

		map.put(3, 3);

		System.out.println(map);

		map.get(2);

		System.out.println(map);
	}
}
