
import java.util.Scanner;
public class Solution_1954 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int init = 1;
			int startX=0;
			int startY=0;
			int endX=n-1;
			int endY=n-1;
			while(init<=n*n) {
				for(int i=startY;i<=endY;i++) {
					arr[startX][i]=init;
					init++;
				}
				startX++;
				for(int i=startX;i<=endX;i++) {
					arr[i][endY]=init;
					init++;
				}
				endY--;
				for(int i=endY;i>=startY;i--) {
					arr[endX][i]=init;
					init++;
				}
				endX--;
				for(int i=endX;i>=startX;i--) {
					arr[i][startY]=init;
					init++;
					
				}
				startY++;
			}

			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}