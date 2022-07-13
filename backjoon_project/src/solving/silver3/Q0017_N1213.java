package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class Q0017_N1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Integer> arrIdx = new TreeSet<Integer>(); // 0~26에서 문자가 있는 인덱스만 넣을 변수
		int[] aptNumArr = new int[26]; // 각 문자별 문자의 개수
		System.out.println(solve(br.readLine(), aptNumArr, arrIdx));
		
	}
	
	public static String solve(String name, int[] numArr, TreeSet<Integer> idxArr) {
		char[] nameArr = name.toCharArray();
		int idx;
		for(int i = 0; i<nameArr.length; i++) {
			idx = nameArr[i] - 'A';
			numArr[idx] += 1;
			idxArr.add(idx);
		}
		int oddCnt = 0;
		char finalCh =' ';
		char nowCh;
		int nowIdx;
		int nowNum;
		StringBuilder sb= new StringBuilder();
		Iterator<Integer> it = idxArr.iterator();
		while(it.hasNext()) {
			nowIdx = it.next(); // 문자가 있는 현재 인덱스
			nowNum = numArr[nowIdx]; // 해당 문자의 개수
			nowCh = (char)(nowIdx+'A'); // 해당 문자
			
			// 문자의 개수가 홀수일떄 정의(문자개수가 홀수인 문자가 2개이상이면 끝)
			if(nowNum%2 == 1) { // 문자개수가 홀수면
				oddCnt+=1;
				finalCh = nowCh;
				if(oddCnt>1) {
					return "I'm Sorry Hansoo";
				}
			}
			
			for(int j = 0; j<nowNum/2 ; j++) { // 개수의 반만 추가
				sb.append(nowCh);
			}
			
		}
		
		// 반개의 문자를 가지고 다시 뒤집어서 붙이는 과정(홀수인 경우 1개더)
		String buf;
		if(finalCh != ' ') { // 마지막에 넣어야함
			buf = sb.reverse().toString();
			sb.reverse();
			sb.append(finalCh);
			sb.append(buf);
		}else {
			buf = sb.reverse().toString();
			sb.reverse();
			sb.append(buf);
		}
		
		return sb.toString();
	}

}
