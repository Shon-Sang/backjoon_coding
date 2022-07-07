import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] num = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int cnt = Integer.parseInt(br.readLine());
		int inoutCnt = 0;
		int circleCnt = 0;
		int x1,y1,x2,y2,xr,yr,r;
		for(int i = 0; i<cnt; i++) {
			stk = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(stk.nextToken());
			y1 = Integer.parseInt(stk.nextToken());
			x2 = Integer.parseInt(stk.nextToken());
			y2 = Integer.parseInt(stk.nextToken());
			circleCnt = Integer.parseInt(br.readLine());
			for(int j= 0; j<circleCnt; j++) {
				stk = new StringTokenizer(br.readLine());
				xr = Integer.parseInt(stk.nextToken());
				yr = Integer.parseInt(stk.nextToken());
				r = Integer.parseInt(stk.nextToken());
				inoutCnt += inoutcount(pointloc(x1, y1, xr, yr, r), pointloc(x2, y2, xr, yr, r));
			}
			System.out.println(inoutCnt);
			inoutCnt = 0;
		}

	}

	public static boolean pointloc(int x, int y, int xr, int yr, int r) {
		if(Math.pow((x-xr), 2) + Math.pow((y-yr), 2) < Math.pow(r, 2)) {
			return true;
		}
		return false;
	}
	
	public static int inoutcount(boolean p1, boolean p2) {
		if(p1 ^ p2) {
			return 1;
		}
		return 0;
	}
}
