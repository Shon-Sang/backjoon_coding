package myalgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LcmGcf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		System.out.println("숫자 2개를 입력하세요.");
		
		String input = br.readLine();
		stk = new StringTokenizer(input);
		int number1 = Integer.parseInt(stk.nextToken());
		int number2 = Integer.parseInt(stk.nextToken());
		System.out.println("최대공약수 : " + getGCF(number1, number2));
		System.out.println("최소공배수 : " + getLCM(number1, number2));
	}
	
	public static int getGCF(int a, int b) { // 최대공약수
		// a가 더 크다고 가정
		int temp = 0;
		int localA;
		int localB;
		
		if(a < b) {
			localA = b;
			localB = a;
		}else {
			localA = a;
			localB = b;
		}
		while(localB != 0) {
			temp = localA % localB;
			localA = localB;
			localB = temp;
		}
		return localA;
	}
	
	public static int getLCM(int a, int b) {
//		int num = getGCF(a, b);
		return a*b/getGCF(a,b);
		//return a/num * b;
	}

}
