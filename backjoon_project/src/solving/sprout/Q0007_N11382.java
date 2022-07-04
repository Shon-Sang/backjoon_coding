package solving.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q0007_N11382 {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String input = br.readLine();
//		String[] numbers = input.split(" ");
//		int sum = 0;
//		for(String s:numbers) {
//			sum += Integer.parseInt(s);
//		}
//		System.out.println(sum);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		br.close();
		StringTokenizer st = new StringTokenizer(input);
		System.out.println(Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()));
//		String s;
//		int sum = 0;
//		while(true) {
//			try {
//				s=st.nextToken();
//				sum += Long.parseLong(s);
//			}catch(Exception e) {
//				break;
//			}
//			
//		}
//		System.out.println(sum);
	}

}
