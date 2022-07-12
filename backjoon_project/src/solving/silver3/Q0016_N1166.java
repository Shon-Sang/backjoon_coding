package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q0016_N1166 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		List<Integer> aList = new ArrayList<Integer>();
		int N = Integer.parseInt(stk.nextToken());
		int L = Integer.parseInt(stk.nextToken());
		int W = Integer.parseInt(stk.nextToken());
		int H = Integer.parseInt(stk.nextToken());
		aList.add(L);
		aList.add(W);
		aList.add(H);
		
		double start = 0;
		double end = minInt(aList); // 가장 변의 길이가 짧은애를 최대값으로 정해놓고 찾아야함
		double target = 0;
		double k;
		for(int i =0; i<8000; i++) {
			target = (start+end)/2;
			k = (long)(L/target) * (long)(W/target) * (long)(H/target);
			if(N <= k) {
				start = target;
			}else {
				end = target;
			}
		}
		System.out.println(target);
	}
	
	public static int maxInt(List<Integer> list) {
		int result = 0;
		for(int k : list) {
			if(k>result) {
				result = k;
			}
		}
		return result;
	}
	
	public static int minInt(List<Integer> list) {
		int result = 10000000;
		for(int k : list) {
			if(k<result) {
				result = k;
			}
		}
		return result;
	}

}
