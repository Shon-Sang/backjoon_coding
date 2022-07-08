package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q0012_N1057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		stk.nextToken();
		System.out.println(solcount(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
		//System.out.println(solcount(101, 891));
	}
	
	// 직접 찾아낸 패턴
	// 짝수일 경우 2로 나눈 몫으로
	// 홀수일 경우 2로 나눈 몫+1
	// 1이면 더이상 안나눔
	// 둘이 같은 값이 될때까지 반복하고 반복한 횟수가 최종 리턴값
	
	public static int mydivide(int n) {
		if(n == 1) {
			return n;
		}
		
		if(n%2 == 0) {
			return n/2;
		}
		return n/2 + 1;
	}
	
	public static int solcount(int n1, int n2) {
		int cnt = 0;
		while(n1 != n2) {
			n1 = mydivide(n1);
			n2 = mydivide(n2);
			cnt += 1;
		}
		return cnt;
	}
}
