import java.util.Arrays;
//Programmers [코딩테스트 입문] 034. 진료순서 정하기

public class Solution_034 {

	public static void main(String[] args) {
		int[] arr;
		arr = new int[] { 3, 76, 24 };
		arr = solution(arr);
		System.out.println(Arrays.toString(arr));
		arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		arr = solution(arr);
		System.out.println(Arrays.toString(arr));
		arr = new int[] { 30, 10, 23, 6, 100 };
		arr = solution(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] solution(int[] emergency) {
		int[] answer = new int[emergency.length];
		for (int i = 0; i < emergency.length; i++) {
			answer[i]++;
			for (int j = 0; j < emergency.length; j++) {
				if (emergency[i] < emergency[j]) {
					answer[i]++;
				}
			}
		}
		return answer;
	}

}
