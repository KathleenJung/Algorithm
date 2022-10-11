package SkillCheck;
import java.util.ArrayList;
import java.util.List;

public class Solution_02 {

//	[문제 설명]
//	정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
//	단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
//	예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
//
//	[제한 조건]
//	arr은 길이 1 이상인 배열입니다.
//	인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

	public static void main(String[] args) {
		int[] arr = new int[4];
		arr[0] = 4;
		arr[1] = 3;
		arr[2] = 2;
		arr[3] = 1;
		arr = solution(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		int[] arr2 = new int[1];
		arr2[0] = 10;
		arr2 = solution(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

	}

	private static int[] solution(int[] arr) {
		if (arr.length == 1) {
			arr = new int[1];
			arr[0] = -1;
			return arr;
		}
		int min = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			list.add(arr[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == min) {
				list.remove(i);
				break;
			}
		}
		arr = new int[arr.length - 1];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;

	}

}
