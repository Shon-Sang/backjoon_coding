package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q0025_N1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		System.out.println(solve(input));

	}
	
	public static int solve(int n) {
		int num = n;
		int count = 0;
		while(num != 1) {
			if(num%3 == 0) {
				num /= 3;
				count += 1;
			}else if( (num-1)%3 == 0) {
				num = (num-1)/3;
				count += 2;
			}else if( num%2 == 0) {
				num /= 2;
				count += 1;
			}else {
				num -= 1;
				count += 1;
			}
		}
		
		return count;
	}

}
