package com.examples.corejava.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalTest {

	public static void main(String[] args) {

		Stream<Integer> st = Stream.of();
		Stream<Integer> opt = st.peek(n -> System.out.println(n));
		System.out.println(opt.findFirst());
	}
}


class Hosting {

    private int Id;
 

	private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }
    
	/*
	 * public Hosting(int id, long websites) { Id = id; this.websites = websites; }
	 */

    public int getId() {
 		return Id;
 	}

 	public void setId(int id) {
 		Id = id;
 	}

 	public String getName() {
 		return name;
 	}

 	public void setName(String name) {
 		this.name = name;
 	}

 	public long getWebsites() {
 		return websites;
 	}

 	public void setWebsites(long websites) {
 		this.websites = websites;
 	}
}