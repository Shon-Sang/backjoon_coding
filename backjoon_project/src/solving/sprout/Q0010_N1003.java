package solving.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q0010_N1003 {
	public static int[] num = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			fibonacci(Integer.parseInt(br.readLine()));
			System.out.printf("%d %d\n", num[0], num[1]);
		}

	}
	
	public static int fibonacci(int n) {
		if(n == 0) {
			num[0] = 1;
			num[1] = 0;
			return 0;
		}
		if(n == 1) {
			num[0] = 0;
			num[1] = 1;
			return 1;
		}
		
		int back = 1;
		int buf = 0;
		int buf1 = 0;
		int front = 1;
		for(int i =1; i<n; i++) {
			buf = front;
			buf1 = back;
			front = back + front;
			back = buf;
		}
		num[0] = buf1;
		num[1] = buf;
		return front;
	}
}
