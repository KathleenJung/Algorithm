// Programmers [코딩테스트 입문] 027. 양꼬치
public class Solution_027 {

	public static void main(String[] args) {
		System.out.println(solution(10, 3));
		System.out.println(solution(64, 6));
	}

	public static int solution(int n, int k) {
		int answer = 0;
		answer = n * 12000 + (k - n / 10) * 2000;
		return answer;
	}

}
