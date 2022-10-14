
public class Solution_009 {

	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(solution(numbers));
		numbers=new int[] {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
		System.out.println(solution(numbers));
	}
	public static double solution(int[] numbers) {
        double answer = 0;
        for (int i = 0; i < numbers.length; i++) {
			answer += numbers[i];
		}
        answer /= numbers.length;
        return answer;
    }
}
