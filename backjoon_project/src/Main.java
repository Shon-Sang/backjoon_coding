import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int[] aArr = new int[Integer.parseInt(stk.nextToken())];
		int[] bArr = new int[Integer.parseInt(stk.nextToken())];
		
		stk = new StringTokenizer(br.readLine());
		for(int i =0; i<aArr.length; i++) {
			aArr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(aArr);
		stk = new StringTokenizer(br.readLine());
		for(int j =0; j<bArr.length; j++) {
			bArr[j] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(bArr);
		int count = 0;
		int result;
		for(int k = 0; k<aArr.length; k++) {
			count += myBSearch(aArr[k], bArr);
		}
		result = (aArr.length + bArr.length) - (count*2);
		System.out.println(result);
	}
	
	public static int myBSearch(int target, int[] arr) {
		
		int start = 0;
		int end = arr.length;
		int middle;

		while(end - start != 1) {
			if(arr[start] == target || arr[end-1] == target) {
				return 1;
			}
			middle = (start+end)/2;
			if(target == arr[middle]) {
				return 1;
			}else if(target < arr[middle]) {
				end = middle;
			}else {
				start = middle;
			}
			
		}
		
		return 0;
	}

}