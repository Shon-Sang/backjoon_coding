package solving.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q0008_N2738 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] rw = new int[2];
		
		while(true) {
			rw[cnt] = Integer.parseInt(st.nextToken());
			cnt += 1;
			if(cnt == 2) {
				cnt = 0;
				break;
			}
		}
		int row = rw[0];
		int col = rw[1];
		int[][] ar1 = new int[row][col];
		int[][] ar2 = new int[row][col];
		int[][] sum = new int[row][col];
		
		while(cnt < row*2) {
			int buf = 0;
			int colbuf = 0;
			st = new StringTokenizer(br.readLine());
			if(cnt < row) {
				while(true) {
					try {
						buf = Integer.parseInt(st.nextToken());
						ar1[cnt][colbuf] = buf;
					}catch(Exception e) {
						break;
					}
					colbuf += 1;
				}
				colbuf = 0;
			}else {
				while(true) {
					try {
						buf = Integer.parseInt(st.nextToken());
						ar2[cnt-row][colbuf] = buf;
					}catch(Exception e) {
						break;
					}
					colbuf += 1;
				}
				colbuf = 0;
			}
			cnt += 1;
		}
		
		arrView(sumArr(ar1, ar2, sum));
	}
	
	public static int[][] sumArr(int[][] arr1, int[][] arr2, int[][] result){
		for(int i = 0; i<arr1.length; i++) {
			for(int j = 0; j<arr1[0].length; j++) {
				result[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return result;
	}
	
	public static void arrView(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<arr.length; i++) {
			for(int j =0; j<arr[0].length; j++) {
				sb.append(arr[i][j]);
				sb.append(" ");
				System.out.print(sb.toString());
				sb.setLength(0);
			}
			System.out.println();
		}
	}

}
