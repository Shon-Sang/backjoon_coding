import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		List<Long> aList = new ArrayList<Long>();
		int N = Integer.parseInt(stk.nextToken());
		long L = Integer.parseInt(stk.nextToken());
		long W = Integer.parseInt(stk.nextToken());
		long H = Integer.parseInt(stk.nextToken());
		aList.add(L);
		aList.add(W);
		aList.add(H);
		
		double start = 0;
		double end = minInt(aList); // 가장 변의 길이가 짧은애를 최대값으로 정해놓고 찾아야함
		double target = 0;
		double k;
		for(int i =0; i<10000; i++) {
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
	
	public static long minInt(List<Long> list) {
		long result = 10000000;
		for(long k : list) {
			if(k<result) {
				result = k;
			}
		}
		return result;
	}
}