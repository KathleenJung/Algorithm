
public class Solution_013 {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		solution(arr);
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		arr = new int[] { 1, 2, 100, -99, 1, 2, 3 };
		solution(arr);
		for (int i = 0; i < 7; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int[] solution(int[] numbers) {
		int[] answer = {};
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] *= 2;
		}
		answer = numbers;
		return answer;
	}

}
