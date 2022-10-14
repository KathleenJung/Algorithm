
public class Solution_012 {

	public static void main(String[] args) {
		int[] arr = solution(1, 2, 3, 4);
		for (int i = 0; i < 2; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		arr = solution(9, 2, 1, 3);
		for (int i = 0; i < 2; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int[] solution(int denum1, int num1, int denum2, int num2) {
		int gcd = gcd(num1, num2);
		int lcm = lcm(num1, num2, gcd);
		int mul1 = lcm / num1;
		denum1 *= mul1;
		int mul2 = lcm / num2;
		denum2 *= mul2;
		int denum = denum1 + denum2;
		int gcd2 = gcd(denum, lcm);
		int[] answer = { denum / gcd2, lcm / gcd2 };
		return answer;
	}

	public static int gcd(int num1, int num2) {
		boolean b = false;
		int temp1 = num1;
		int temp2 = num2;

		while (!b) {
			if (temp2 == 0) {
				break;
			}
			if (temp2 != 0 || temp1 % temp2 != 0) {
				int temp = temp1;
				temp1 = temp2;
				temp2 = temp % temp2;
			} else {
				b = true;
			}
		}
		return temp1;
	}

	public static int lcm(int num1, int num2, int gcd) {
		return (num1 * num2) / gcd;
	}

}
