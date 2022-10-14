
public class Solution_011 {

	public static void main(String[] args) {
		System.out.println(solution(3, 2));
		System.out.println(solution(7, 3));
		System.out.println(solution(1, 16));
		
	}
	public static int solution(double num1, double num2) {
        int answer = 0;
        double t = num1/num2 *1000;
        answer = (int)t;
        return answer;
    }

}
