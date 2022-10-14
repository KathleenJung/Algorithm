
public class Solution_010 {

	public static void main(String[] args) {
		int[] array;
		array = new int[] { 1, 1, 2, 3, 4, 5 };
		System.out.println(solution(array, 1));
		array = new int[] { 0, 2, 3, 4 };
		System.out.println(solution(array, 1));
	}

	public static int solution(int[] array, int n) {
		int answer = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == n) {
				answer++;
			}
		}
		return answer;
	}

}
