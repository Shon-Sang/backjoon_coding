package mypractice01;

import java.util.ArrayList;
import java.util.List;

public class ListSearchArray {

	public static void main(String[] args) {
		List<Integer[]> aList = new ArrayList<Integer[]>();
		Integer[] a = {0, -1};
		Integer[] b = {3, -3};
		Integer[] c = {0, -1};
		aList.add(a);
		aList.add(b);
		
		System.out.println(aList.contains(a));
		System.out.println(aList.contains(c));
	}

}
