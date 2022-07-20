package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q0023_N1448 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] sideArr = new int[Integer.parseInt(br.readLine())];
		for(int i = 0; i<sideArr.length; i++) {
			sideArr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(sideArr); // 오름차순 정렬
		reserveSort(sideArr); // 내림차순 정렬
//		for(int i : sideArr) {
//			System.out.printf(i + " ");
//		}
		System.out.println(makeTriMax(sideArr));
	}
	
	public static int makeTriMax(int[] arr) {
		int idx = 0;
		while(idx < arr.length - 2) {
			if(arr[idx] < arr[idx+1] + arr[idx+2]) {
				return arr[idx] + arr[idx+1] + arr[idx+2];
			}
			idx += 1;
		}
		
		return -1;
	}
	
	public static void reserveSort(int[] arr) {
		int temp;
		int endIdx;
		for(int i = 0; i<arr.length/2; i++) {
			endIdx = arr.length - 1 - i;
			temp = arr[i];
			arr[i] = arr[endIdx];
			arr[endIdx] = temp;
		}
	}

}
