import java.util.ArrayList;
import java.util.List;

//Programmers [코딩테스트 입문] 031. 배열 자르기

public class Solution_031 {

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5 };
		numbers = solution(numbers, 1, 3);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		numbers = new int[] { 1, 3, 5 };
		numbers = solution(numbers, 1, 2);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

	public static int[] solution(int[] numbers, int num1, int num2) {
		int[] answer = {};
		List<Integer> list = new ArrayList<Integer>();
		for (int i = num1; i <= num2; i++) {
			list.add(numbers[i]);
		}
		answer = list.stream().mapToInt(i -> i).toArray();
		return answer;
	}

}
