
public class Solution_019 {

	public static void main(String[] args) {
		System.out.println(solution(7, 10));
		System.out.println(solution(4, 12));
	}

	public static int solution(int slice, int n) {
		int answer = 0;
		if (n % slice == 0) {
			answer = n / slice;
		} else {
			answer = n / slice + 1;
		}
		return answer;
	}

}
