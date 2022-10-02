import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			int temp = sc.nextInt();
			temp %= 42;
			int index = 0;
			while(true) {
				if(index >= list.size()) {
					list.add(temp);
					break;
				}
				if(list.get(index) == temp) {
					break;
				} else {
					index++;
				}
			}
		}
		System.out.println(list.size());
		sc.close();
	}

}
