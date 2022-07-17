package solving.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q0020_N1388 {

	private static int allCnt;
	// 1개짜리 안세서 답안나오는거였음 ㅡ;ㅡ;ㅡ;ㅡ;ㅡ;ㅡ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(stk.nextToken());
		int column = Integer.parseInt(stk.nextToken());
		char[][] board = new char[row][column];
		char[] oneRow;
		for(int i = 0; i<board.length; i++) {
			oneRow = br.readLine().toCharArray();
			for(int j = 0; j<board[0].length; j++) {
				board[i][j] = oneRow[j];
			}
		}
		colCount(board);
		rowCount(board);
		System.out.println(allCnt);
	}
	
	public static void colCount(char[][] board) { // '-' 카운트
		int colCnt;
		for(int i = 0; i<board.length; i++) {
			colCnt = 0;
			for(int j = 0; j<board[0].length; j++) {
				if(board[i][j] == '-') {
					colCnt += 1;
				}else {
					colCnt = 0;
				}
				
				if(colCnt == 1) {
					allCnt += 1;
				}
			}
		}
	}
	
	public static void rowCount(char[][] board) { // '|' 카운트
		int rowCnt;
		for(int i = 0; i<board[0].length; i++) {
			rowCnt = 0;
			for(int j= 0; j<board.length; j++) {
				if(board[j][i] == '|') {
					rowCnt += 1;
				}else {
					rowCnt = 0;
				}
				
				if(rowCnt == 1) {
					allCnt += 1;
				}
			}
		}
	}
	

}
