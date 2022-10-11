package SkillCheck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_01 {
	
	public static void main(String[] args) {
		String[] arr = new String[3];
		int N = 1;
		arr[0] = "sun";
		arr[1] = "bed";
		arr[2] = "car";
		solve2(arr,N);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr = new String[3];
		N = 2;
		arr[0] = "abce";
		arr[1] = "abcd";
		arr[2] = "cdx";
		solve2(arr,N);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	private static String[] solve2(String[] arr, int n) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.charAt(n) > o2.charAt(n)) {
                    return 1;
                } else if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                } else {
                    return -1;
                }
			}
		});
		
		list.toArray(arr);
		return arr;
	}
	

}
