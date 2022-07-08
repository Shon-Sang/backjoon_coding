import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		stk.nextToken();
		System.out.println(solcount(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
	}
	
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