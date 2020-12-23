package com.examples.corejava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * If 2 objects are equal, then both hashCode() should be equal.
 * 
 * if 2 hashCode() are equal, it does not mean they are equal.
 *
 */
@SuppressWarnings("unused")
public class HashCodeAndEquals {

	public static void main(String[] args) {
		
		Student s = new Student("A", 100, "A");
		Student s1 = new Student("A", 100, "A");
		
		if (s.equals(s1)) {
			System.out.println("equal"); 
		}
		System.out.println(s.hashCode()); 
		System.out.println(s1.hashCode()); 
		
		Set<Student> set = new HashSet<Student>();
		set.add(s);
		set.add(s1);
		System.out.println(set.size()); 
		
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		map.put(s,100);
		map.put(s1,101);
		System.out.println(map.size()); 
		System.out.println(map.values()); 
	}
}

class Student {
	
	private String name;
	private int    number;
	private String grade;
	
	public Student(String name, int number, String grade) {
		super();
		this.name = name;
		this.number = number;
		this.grade = grade;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
}
