//Programmers [코딩테스트 입문] 033. 순서쌍의 개수

public class Solution_033 {

	public static void main(String[] args) {
		System.out.println(solution(20));
		System.out.println(solution(100));
	}

	public static int solution(int n) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				cnt++;
			}
		}
		return cnt;
	}

}
