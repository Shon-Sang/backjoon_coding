package solving.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q0009_1_N1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int x1, y1, r1, x2, y2, r2;
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<cnt; i++) {
			stk = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(stk.nextToken());
			y1 = Integer.parseInt(stk.nextToken());
			r1 = Integer.parseInt(stk.nextToken());
			x2 = Integer.parseInt(stk.nextToken());
			y2 = Integer.parseInt(stk.nextToken());
			r2 = Integer.parseInt(stk.nextToken());
			
			System.out.println(posnum(r1, r2, distsolve(x1, y1, x2, y2)));
		}
	}
	
	public static int distsolve(int x1, int y1, int x2, int y2) {
		double dist;
		dist = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
		dist = Math.sqrt(dist);
		
		return (int)dist;
	}
	
	public static int posnum(int r1, int r2, int d) {
		if(d == 0) { // 중점이 겹칠때
			if(r1 == r2) { // 반지름까지 겹치면 무한
				return -1;
			}
			return 0;
		}
		
		int t = r1 + r2 - d;
		if(t < 0) {
			return 0;
		}else if(t == 0) {
			return 1;
		}else {
			return 2;
		}
	}
}
