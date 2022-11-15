import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4008. [모의 SW 역량테스트] 숫자 만들기
public class Solution_4008_comment {
	// 숫자 수, 연산자:N-1개
	static int N;
	// 가진 숫자판을 저장할 배열
	static int[] num;
	// 가진 연산자 개수를 저장할 배열
	static int[] op;
	// 모든 숫자판과 연산자를 사용한 뒤 나온 값
	static int ans;
	// 연산 후 최소값, 최대값 저장할 변수
	static int min, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			// 배열 초기화
			num = new int[N];
			op = new int[4];
			// 전역 변수 초기화
			ans = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());

			// 각 연산자 개수 입력 받기 ( + - * / 순서 )
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}

			// 숫자판 입력 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			// 첫번째 숫자 가지고 탐색 시작
			solve(1, num[0]);

			/* 연산자 카드를 사용하여 만들 수 있는 수식으로
			얻은 결과값 중 최댓값과 최솟값의 차이 */
			System.out.println("#" + (t+1) + " " + (max - min));
		}
	}

	// pos -> 숫자판 순서
	// ans -> 연산하여 얻은 값
	private static void solve(int pos, int ans) {
		// 가진 숫자판 개수만큼 연산을 완료했으면 (계산 완료)
		if(pos==N) {
			// min 값과 max 값 갱신 시켜주기
			min = Math.min(ans, min);
			max = Math.max(ans, max);
			return;
		}
		
		// + 연산자의 수가 남아있다면
		if(op[0] != 0) {
			// 가진 + 연산자의 수를 감소 시키고
			op[0]--;
			// 더하기 연산 해주고, 다음 수 계산하러 가기
			solve(pos+1, ans+num[pos]);
			// 감소 시킨 + 연산자의 수 복구 시켜주기
			op[0]++;
		}
		
		// - 연산자의 수가 남아있다면
		if(op[1] !=0) {
			// 가진 - 연산자의 수를 감소 시키고
			op[1]--;
			// 빼기 연산 해주고, 다음 수 계산하러 가기
			solve(pos+1, ans-num[pos]);
			// 감소 시킨 - 연산자의 수 복구 시켜주기
			op[1]++;
		}
		
		// * 연산자의 수가 남아있다면
		if(op[2] !=0) {
			// 가진 * 연산자의 수를 감소 시키고
			op[2]--;
			// 곱하기 연산 해주고, 다음 수 계산하러 가기
			solve(pos+1, ans*num[pos]);
			// 감소 시킨 * 연산자의 수 복구 시켜주기
			op[2]++;
		}
		
		// / 연산자의 수가 남아있다면
		if(op[3] !=0) {
			// 가진 / 연산자의 수를 감소 시키고
			op[3]--;
			// 나누기 연산 해주고, 다음 수 계산하러 가기
			solve(pos+1, ans/num[pos]);
			// 감소 시킨 / 연산자의 수 복구 시켜주기
			op[3]++;
		}
	}

}
