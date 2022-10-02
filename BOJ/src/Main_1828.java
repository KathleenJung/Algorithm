

import java.util.Arrays;
import java.util.Scanner;

public class Main_1828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt=1;
		Degree[] d = new Degree[N];
		
		for(int i=0;i<N;i++) {
			d[i]= new Degree(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(d);
		Degree temp = d[0];
		for(int i=1;i<N;i++) {
			if(temp.high<d[i].low) {
				cnt++;
				temp=d[i];
			}
		}
		System.out.println(cnt);
		sc.close();
	}
	
	static class Degree implements Comparable<Degree>{
		int low;
		int high;
		
		Degree(int low, int high){
			this.low =low;
			this.high = high;
		}

		@Override
		public int compareTo(Degree o) {
			return this.high-o.high;
		}
	}
}
