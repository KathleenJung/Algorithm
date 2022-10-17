
public class Solution_018 {

	public static void main(String[] args) {
		System.out.println(solution(6));
		System.out.println(solution(10));
		System.out.println(solution(4));
	}
	public static int solution(int n) {
        int answer = 1;
        while((6*answer)%n!=0) {
        	answer++;
        }
        return answer;
    }

}
