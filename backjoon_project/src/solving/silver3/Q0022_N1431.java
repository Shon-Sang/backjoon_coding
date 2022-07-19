package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q0022_N1431 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arrSize = Integer.parseInt(br.readLine());
		String[] strArr = new String[arrSize];
		for(int i = 0; i<arrSize; i++) {
			strArr[i] = br.readLine();
		}
		
		for(int i = 0; i<arrSize; i++) {
			for(int j = i + 1; j<arrSize; j++) {
				if(myCompare(strArr[i], strArr[j])) {
					String buf = strArr[i];
					strArr[i] = strArr[j];
					strArr[j] = buf;
				}
			}
		}
		
		for(int i = 0; i<arrSize; i++) {
			System.out.println(strArr[i]);
		}
	}
	
	
	public static boolean myCompare(String front, String back) { // true를 리턴하면 자리교환
		if(front.length() > back.length()) { // 1번조건
			return true;
		}
		else if(front.length() == back.length()) {
			
			if(mySum(front) > mySum(back)) {
				return true;
			}
			else if(mySum(front) == mySum(back)) {
				return myDirCom(front, back);
			}
			else {
				return false;
			}
			
		}else {
			return false;
		}
		
	}
	
	public static int mySum(String str) {
		int sum = 0;
		char buf;
		for(int i = 0; i<str.length(); i++) {
			buf = str.charAt(i);
			if(buf >= '0' && buf <='9') {
				sum += buf - '0';
			} 
		}
		
		return sum;
	}
	
	public static boolean myDirCom(String front, String back) {
		
		for(int i = 0; i<front.length(); i++) { 
			if(front.charAt(i) > back.charAt(i)) { // 앞에가 더 크므로 바꿔야함
				return true;
			}else if(front.charAt(i) == back.charAt(i)) {
				continue;
			}else { // 앞에가 더 작으므로 바꿀필요 없음
				return false;
			}
		}
		
		return false;
	}
}
