import java.util.Arrays;

public class Solution_014 {

	public static void main(String[] args) {
		int[] arr;
		arr = new int[] { 1, 2, 7, 10, 11 };
		System.out.println(solution(arr));
		arr = new int[] { 9, -1, 0 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] array) {
		int answer = 0;
		Arrays.sort(array);
		answer = array[array.length / 2];
		return answer;
	}

}
