import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406 {

	static int[][] arr;
	static int N, M, K;
	static int r, c, s;
	static int[][] rcs;
	static int[][] temp;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println();

		rcs = new int[K][3];
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			for(int idx=0;idx<3;idx++) {
//				rcs[k][0] = r, [k][1] = c, [k][2] = s
			rcs[k][idx] = Integer.parseInt(st.nextToken());
			}
			rotate();
			answer();
		}
		System.out.println(min);
	}
	static void rotate() {
		temp = arr;
		int first = temp[0][0];
		int si = r-s-1;
		int ei = r+s-1;
		int sj = c-s-1;
		int ej = c+s-1;
		int i, j;

		for(int c=0;c<s;c++) {
			j = sj;
			for(i=si;i<ei;i++) {
				if(i+1 < ei) {
					temp[i][j] = temp[i+1][j];
				}
			}

			i = ei;
			for(j=sj;j<ej;j++) {
				temp[i][j] = temp[i][j+1];
			}

			j = ej;
			for(i=ei;i>si;i--) {
				temp[i][j] = temp[i-1][j];
			}

			i = si;
			for(j=ej;j>sj;j--) {
				temp[i][j] = temp[i][j-1];
			}
			temp[0][1] = first;
			si++; ei--; sj++; ej--;
		}
	}
	static void print(int[][] arr) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void answer() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cnt += temp[i][j];
			}
		}
		min = Math.min(cnt, min);
	}

}