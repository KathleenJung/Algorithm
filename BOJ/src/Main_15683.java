

import java.util.Scanner;

public class Main_15683 {
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 1) {
					int t = j+1; // 우
					while(t<M && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t++;
					}
				} else if(arr[i][j] == 2) {
					int t = j+1; // 우
					while(t<M && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t++;
					}
					t = j-1; // 좌
					while(t>=0 && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t--;
					}
				} else if(arr[i][j] == 3) {
					int t = j+1; // 우
					while(t<M && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t++;
					}
					t = i-1; // 상
					while(t>=0 && arr[t][j]!=6) {
						if(arr[t][j]==0) {
							arr[t][j] = 8;
						}
						t--;
					}
				} else if(arr[i][j]==4) {
					int t = j+1; // 우
					while(t<M && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t++;
					}
					t = j-1; // 좌
					while(t>=0 && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t--;
					}
					t = i-1; // 상
					while(t>=0 && arr[t][j]!=6) {
						if(arr[t][j]==0) {
							arr[t][j] = 8;
						}
						t--;
					}
				} else if(arr[i][j]==5) {
					int t = j+1; // 우
					while(t<M && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t++;
					}
					t = j-1; // 좌
					while(t>=0 && arr[i][t]!=6) {
						if(arr[i][t]==0) {
							arr[i][t] = 8;
						}
						t--;
					}
					t = i-1; // 상
					while(t>=0 && arr[t][j]!=6) {
						if(arr[t][j]==0) {
							arr[t][j] = 8;
						}
						t--;
					}
					t = i+1; // 하
					while(t<N && arr[t][j]!=6) {
						if(arr[t][j]==0) {
							arr[t][j] = 8;
						}
						t++;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		sc.close();
	}

}
