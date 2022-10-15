public class Solution_015 {
	public static void main(String[] args) {
		int[] arr;
		arr = new int[] { 1, 2, 3, 3, 3, 4 };
		System.out.println(solution(arr));
		arr = new int[] { 1, 1, 2, 2 };
		System.out.println(solution(arr));
		arr = new int[] { 1 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] array) {
		int answer = 0;
		int maxIdx = 0;
		if (array.length == 1) {
			return array[0];
		}
		int max = -1001;
		int count = 0;
		int[] cnt = new int[2001];
		for (int i = 0; i < array.length; i++) {
			cnt[array[i] + 1000]++;
		}
		for (int i = 0; i < cnt.length; i++) {
			if (max < cnt[i]) {
				maxIdx = i - 1000;
				max = cnt[i];
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if (max == cnt[i]) {
				count++;
			}
			if (count >= 2) {
				return -1;
			}
		}
		answer = maxIdx;
		return answer;
	}

}
