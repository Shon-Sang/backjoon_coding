package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q0024_N1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int L = Integer.parseInt(stk.nextToken());
		
		int[] holeArr = new int[N];
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			holeArr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(holeArr);
		System.out.println(solve(holeArr, L));
	}
	
	public static int solve(int[] arr, int tape) {
		int cnt = 1;
		int idx = 0;
		int start = idx;
		while(idx < arr.length - 1) {
			if(arr[start] + tape - 1 < arr[idx + 1]) {
				start = idx + 1;
				cnt += 1;
			}
			idx += 1;
		}
		
		return cnt;
	}

}
