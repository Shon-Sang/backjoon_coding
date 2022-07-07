package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q0009_N1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String input;
		
		for(int i = 0; i<caseNum; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			System.out.println(matchnum(
					distsol(Integer.parseInt(st.nextToken()), 
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
					distsol(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
							Integer.parseInt(st.nextToken()))
					));
		}
		
//		List<Integer[]> list1 = distsol(1, 1, 1);
//		List<Integer[]> list2 = distsol(1, 1, 5);
//		System.out.println(matchnum(list1, list2));
	}
	
	
	public static List<Integer[]> distsol(int x, int y, int r) {
		List<Integer[]> result = new ArrayList<Integer[]>();
		int x_f = r - Math.abs(x);
		int x_b = r + Math.abs(x);
		int y_f = r - Math.abs(y);
		int y_b = r + Math.abs(y);
		
		if(y_f > 0) {
			y_f = -y_f;
		}
		if(x_f > 0) {
			x_f = -x_f;
		}
			
			
		for(int i = y_f; i<=y_b; i++) {
			if(i*i > r*r) {
				continue;
			}
			for(int j = x_f; j<x_b; j++) {
				if(j*j > r*r) {
					continue;
				}
				if((x-j)*(x-j) + (y-i)*(y-i) == r*r) {
					Integer[] buf = new Integer[2];
					buf[0] = i;
					buf[1] = j;
					result.add(buf);
				}
			}
		}
		
		return result;
	}
	
	public static int matchnum(List<Integer[]> aList1, List<Integer[]> aList2) {
		int cnt = 0;
		for(int i = 0; i<aList1.size(); i++) {
			Integer[] a1 = aList1.get(i);
			for(int j = 0; j<aList2.size(); j++) {
				Integer[] a2 = aList2.get(j);
				
				if(a1[0] == a2[0]) {
					if(a1[1] == a2[1]) {
						cnt += 1;
					}
				}
			}
		}
		return cnt;
	}
}
