package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q0013_N1058 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] ynArr = makeYNarray(br);
		boolean[][] checkArr = new boolean[ynArr.length][ynArr[0].length];
		int[] frArr = new int[ynArr.length];
		
		for(int i = 0; i<ynArr.length; i++) {
			for(int j = 0; j<ynArr[0].length; j++) {
				if(ynArr[i][j] == 'Y') { // Y면
					if(!checkArr[i][j]) {
						checkArr[i][j] = true;
						//checkArr[j][i] = true;
						frArr[i] += 1;
						//frArr[j] += 1;
					}
				
					// 여기 알고리즘 잘이해할것
					// 한 행의 친구의 친구를 찾을 때는 현재 비교중인 열의 친구의 친구를 확인함(j행의 친구상태)
					// 이때 이 행의 친구상태(i행의 친구상태)을 비교해야하는게 중요
					// 열과 행이 같은 부분은 무시(자기자신)
					for(int k = 0; k<ynArr.length; k++) {
						if(ynArr[j][k] == 'Y' && !checkArr[i][k] && i!=k) {
							checkArr[i][k] = true;
							//checkArr[k][j] = true;
							frArr[i] += 1;
							
						}
					}
				}
			}
		}
		
		System.out.println(maxArr(frArr));
	}
	
	public static char[][] makeYNarray(BufferedReader br) throws NumberFormatException, IOException{
		int n = Integer.parseInt(br.readLine());
		char[][] result = new char[n][n];
		char[] chArrBuf;
		for(int i = 0; i<n; i++) {
			chArrBuf = br.readLine().toCharArray();
			for(int j = 0; j<chArrBuf.length; j++) {
				result[i][j] = chArrBuf[j];
			}
		}
		return result;
	}
	
	public static int maxArr(int[] input) {
		
		int max = 0;
		for(int i = 0; i<input.length; i++) {
			if(max<input[i]) {
				max = input[i];
			}
		}
		
		return max;
	}

}
