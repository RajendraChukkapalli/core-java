package com.examples.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {

	public static void main(String[] args) {
		
		int[] arr = {4,2,1,3,5,8};
		
        SortedMap<Integer, ArrayList<Integer>> mapList = new TreeMap<>();
        
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        
       // mapList.
        minimumAbsDifference(arr);
	}
	
	 public static List<List<Integer>> minimumAbsDifference(int[] arr) {

	        
	        List<List<Integer>> list = new ArrayList<>();
	        SortedMap<Integer, List<List<Integer>>> mapList = new TreeMap<>();
	        
	        // sort the array
	        Arrays.sort(arr);
	        
	        // find the min difference between the numbers and store them in map.
	        // if the diffence already exists, add the number set to the existing. 
	        // if not create a new list
	        for (int i=0; i< arr.length - 1; i++) {
	            
	            int diff = Math.abs(arr[i] - arr[i+1]);
	            List<List<Integer>> tempList = new ArrayList<>();
	            List<Integer> arrList = new ArrayList<>();
	            arrList.add(arr[i]);
	            arrList.add(arr[i+1]);
	            if (!mapList.containsKey(diff)) {
	            	tempList.add(arrList);
	                mapList.put(diff, tempList);
	            } else {
	            	List<List<Integer>> tempList2 = mapList.get(diff);
	            	tempList2.add(arrList);
	            	mapList.put(diff, tempList2);
	            }
	        }
	        // find all the ket set 
	        int key = mapList.firstKey();
	        return mapList.get(key);
	    }

}
