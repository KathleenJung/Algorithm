public class Solution_008 {

	public static void main(String[] args) {
		System.out.println(solution(70));
		System.out.println(solution(91));
		System.out.println(solution(180));
	}

	public static int solution(int angle) {
		int answer = 0;
		if (0 < angle && angle < 90) {
			answer = 1;
		} else if (angle == 90) {
			answer = 2;
		} else if (90 < angle && angle < 180) {
			answer = 3;
		} else if (angle == 180) {
			answer = 4;
		}
		return answer;
	}
}
