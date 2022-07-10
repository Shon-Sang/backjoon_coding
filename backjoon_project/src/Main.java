import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static char[] row = {'8' ,'7', '6', '5', '4', '3', '2', '1'};
	private static char[] col = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] kingPos = posEncoder(stk.nextToken()); // (x,y)
		int[] rockPos = posEncoder(stk.nextToken());
		int cnt = Integer.parseInt(stk.nextToken());
		int[][] fPos;
		
		for(int i=0; i<cnt; i++) {
			fPos = posMoving(br.readLine(), kingPos, rockPos);
			kingPos = fPos[0];
			rockPos = fPos[1];
		}
		
		System.out.printf("%s\n%s",posDecoder(kingPos), posDecoder(rockPos));
	}

	
	public static int[] posEncoder(String point) {
		int[] pos = new int[2];
		char[] pArr = point.toCharArray();
		for(int i = 0; i<pArr.length; i++) {
			
			if(i == 0) { // col 좌표
				pos[i] = mySearchIndex(col, pArr[i]);
			}else {
				pos[i] = mySearchIndex(row, pArr[i]);
			}
		}
		
		return pos;
	}
	
	public static String posDecoder(int[] pos) { // x,y
		StringBuilder sb = new StringBuilder();
		sb.append(col[pos[0]]);
		sb.append(row[pos[1]]);
		return sb.toString();
	}
	
	public static int mySearchIndex(char[] arr, char e) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == e) {
				return i;
			}
		}
		return -1;
	}
	
	public static int[] movePos(String str) {
		// x,y 식임
		int[] move = new int[2];
		switch(str) {
		case "R":
			move[0] = 1;
			move[1] = 0;
			break;
		case "L":
			move[0] = -1;
			move[1] = 0;
			break;
		case "B":
			move[0] = 0;
			move[1] = 1;
			break;
		case "T":
			move[0] = 0;
			move[1] = -1;
			break;
		case "RT":
			move[0] = 1;
			move[1] = -1;
			break;
		case "LT":
			move[0] = -1;
			move[1] = -1;
			break;
		case "RB":
			move[0] = 1;
			move[1] = 1;
			break;
		case "LB":
			move[0] = -1;
			move[1] = 1;
			break;
		default:
			break;
		}
		return move;
	}
	
	public static int[][] posMoving(String inputPos, int[] kPos, int[] rPos) {
		int[] movePos = movePos(inputPos);
		
		int[] buf_k;
		int[] buf_r;
		int[][] result = new int[2][2];
		boolean check = true;
		
		buf_k = kPos.clone();
		for(int i = 0; i<buf_k.length; i++) {
			buf_k[i] += movePos[i];
			if(buf_k[i] > 7 || buf_k[i] < 0) { // 체크판 밖으로 가는지 안가는지 확인
				check = false;
				break;
			}
		}
		
		if(check) { // 판 밖으로 안나갔다면
			result[0] = buf_k;
		}else { // 판 밖으로 나갔다면
			result[0] = kPos;
		}
		check = true;
		
		// 킹이 움직인후 그좌표가 돌과 겹쳐야 돌을 움직임
		if(result[0][0] == rPos[0] && result[0][1] == rPos[1]) {
			buf_r = rPos.clone();
			for(int i = 0; i<buf_r.length; i++) {
				buf_r[i] += movePos[i];
				if(buf_r[i] > 7 || buf_r[i] < 0) {
					check = false;
					break;
				}
			}
			
			if(check) {
				result[1] = buf_r;
			}else {
				result[0] = kPos;
				result[1] = rPos;
			}
		}else {
			result[1] = rPos;
		}
		return result;

	}
}