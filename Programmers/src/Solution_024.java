// Programmers [코딩테스트 입문] 024. 짝수 홀수 개수
public class Solution_024 {

	public static void main(String[] args) {
		int[] num_list;
		num_list = new int[] { 1, 2, 3, 4, 5 };
		num_list = solution(num_list);
		print(num_list);
		num_list = new int[] { 1, 3, 5, 7 };
		num_list = solution(num_list);
	}

	private static void print(int[] num_list) {
		for (int i = 0; i < num_list.length; i++) {
			System.out.print(num_list[i] + " ");
		}
		System.out.println();
	}

	public static int[] solution(int[] num_list) {
		int[] answer = {};
		int a = 0;
		int b = 0;
		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] % 2 == 1) {
				a++;
			} else if (num_list[i] % 2 == 0) {
				b++;
			}
		}
		answer = new int[] { b, a };
		return answer;
	}

}
