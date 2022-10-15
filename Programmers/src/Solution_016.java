import java.util.ArrayList;
import java.util.List;

public class Solution_016 {

	public static void main(String[] args) {
		int[] arr = solution(10);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		arr = solution(15);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int[] solution(int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
			if(i%2==1) {
				list.add(i);
			}
		}
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }

}
