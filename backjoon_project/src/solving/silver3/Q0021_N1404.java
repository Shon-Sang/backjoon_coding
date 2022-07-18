package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q0021_N1404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[][] probabArr = new int[8][7];
		double[] probResultArr = new double[8];
		makeProbArr(probabArr, stk);
		arrView(probabArr);
		makeProbabResult(probabArr, probResultArr);
		for(double e : probResultArr) {
			System.out.print(e + " ");
		}
	}
	
	public static void makeProbArr(int[][] arr, StringTokenizer stk) {
		//wer
		int nowCol = 0;
		int q;
		while(stk.hasMoreElements()) {
			for(int i = 0; i<arr.length; i++) {
				for(int j = i; j<arr[0].length; j++) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
				}
				
//				//q = 0; // i가 3일떄 생각 arr[0]
//				int row;
//				int col;
//				for(int k = 0; k<nowCol; k++) {
//					row = k;
//					col = nowCol - k - 1;
//					arr[i][k] = 100 - arr[row][col];
//					//arr[i][k] = 100 - arr[q - 1][nowCol - k - 1];
//				}
//				nowCol += 1;
				
				for(int k = 0; k<i; k++) {
					arr[i][k] = 100 - arr[k][i - 1];
				}
			}
		}
	}
	
	public static void arrView(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void makeProbabResult(int[][] probArr, double[] resultArr) { // 길이 7개 고정
		double sum;
		for(int i = 0; i<probArr.length; i++) {
			sum = 0;
			
			for(int j = 1; j <= 2; j++) {
				for(int k = 3; k <= 4 ; k++) {
					for(int m = 5; m <= 6; m++) {
						sum += ((double)probArr[i][0]/100.0)*
								((double)probArr[i][j]/100.0)*
								((double)probArr[i][k]/100.0)*
								((double)probArr[i][m]/100.0);
					}
				}
			}
			resultArr[i] = (sum/8.0)*100;
		}
	}

}
