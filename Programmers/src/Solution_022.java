// Programmers [코딩테스트 입문] 022. 배열 뒤집기

public class Solution_022 {

	public static void main(String[] args) {
		int[] num_list;
		num_list = new int[] { 1, 2, 3, 4, 5 };
		num_list = solution(num_list);
		for (int i = 0; i < num_list.length; i++) {
			System.out.print(num_list[i] + " ");
		}
		System.out.println();

		num_list = new int[] { 1, 1, 1, 1, 1, 2 };
		num_list = solution(num_list);
		for (int i = 0; i < num_list.length; i++) {
			System.out.print(num_list[i] + " ");
		}
		System.out.println();

		num_list = new int[] { 1, 0, 1, 1, 1, 3, 5 };
		num_list = solution(num_list);
		for (int i = 0; i < num_list.length; i++) {
			System.out.print(num_list[i] + " ");
		}
		System.out.println();
	}

	public static int[] solution(int[] num_list) {
		int[] answer = new int[num_list.length];
		for (int i = 0; i < answer.length; i++) {
			answer[answer.length-i-1] = num_list[i];
		}
		return answer;
	}
}
