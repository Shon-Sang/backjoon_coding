import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static int yPosVar = 0;
	private static int xPosVar = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer[]> posList = new ArrayList<Integer[]>();
		char[][] mazeBoard; // 최종 미로 배열
		Integer[] nowPos = {0, 0}; // 현재 위치 좌표
		Integer[] maxPos = {0, 0}; // 최종 배열을 그리기위해 필요
		char nowDirect = 'S'; // 현재 위치에서 보고있는 방향
		posList.add(nowPos);
		
		// while문 쓰려면 nowDirect,nowPos,maxPos 멤버변수 초기화시켜야함
		br.readLine();// 첫번째 입력값은 필요 없으므로
		String inputDirect = br.readLine();
		char[] inputCharArr = inputDirect.toCharArray();
		
		for(int i = 0; i<inputCharArr.length; i++) {
			if(inputCharArr[i] == 'F') {
				nowPos = addPos(nowDirect, nowPos, posList);
			}else {
				nowDirect = nextDirect(inputCharArr[i], nowDirect);
			}
		}
		posListInDe(posList, maxPos);
		mazeBoard = makeMazeBoard(posList, maxPos);
		mazeView(mazeBoard);
		
	}
	
	// 입력으로 방향이 들어올때 방향을 정해줌
	public static char nextDirect(char inDir, char nowDir) {
		char nextDir = ' ';
		
		// 'R' or 'L' 밖에 못들어오게 할거임
		if(inDir == 'R') {
			switch(nowDir) {
			case 'S':
				nextDir = 'W';
				break;
			case 'W':
				nextDir = 'N';
				break;
			case 'N':
				nextDir = 'E';
				break;
			case 'E':
				nextDir = 'S';
				break;
			default:
				break;
			}
		}else {
			switch(nowDir) {
			case 'S':
				nextDir = 'E';
				break;
			case 'E':
				nextDir = 'N';
				break;
			case 'N':
				nextDir = 'W';
				break;
			case 'W':
				nextDir = 'S';
				break;
			default:
				break;
			}
		}
		
		return nextDir;
	}
	
	// 위치를 추가함
	public static Integer[] addPos(char nowDir, Integer[] nowPos, List<Integer[]> posList) {
		Integer[] nextPos = nowPos.clone();
		switch (nowDir) {
		case 'S': // y
			nextPos[0] += 1;
			break;
		case 'N': // y
			nextPos[0] -= 1;
			
			// y좌표의 최소값(음수값 절대값이 제일크게)
			if(yPosVar > nextPos[0]) {
				yPosVar = nextPos[0];
			}
			break;
		case 'E': // x
			nextPos[1] += 1;
			break;
		case 'W': // x
			nextPos[1] -= 1;
			
			// x좌표의 최소값(음수값 절대값이 제일크게)
			if(xPosVar > nextPos[1]) {
				xPosVar = nextPos[1];
			}
			break;

		default:
			break;
		}
		
		posList.add(nextPos);
		return nextPos;
		
	}
	
	// 추가한 좌표들에 음수가 있을경우를 위해서(음수좌표를 없앰-> 미로를 평행이동시킨다고 생각)
	public static void posListInDe(List<Integer[]> posList, Integer[] maxPos) {
		Integer[] buf;
		for(int i = 0; i<posList.size(); i++) {
			buf = posList.get(i); // clone해야함? 다시 생각해볼것 결과적으로 문제가없다면 안해도됨
			buf[0] += yPosVar * -1;
			buf[1] += xPosVar * -1;
			
			if(buf[0] > maxPos[0]) { // y좌표 최대값
				maxPos[0] = buf[0];
			}
			
			if(buf[1] > maxPos[1]) {
				maxPos[1] = buf[1];
			}
			
		}
			
	}
	
	// 위치 리스트를 이용해서 미로배열을 만듬
	public static char[][] makeMazeBoard(List<Integer[]> posList, Integer[] maxPos) {
		// maxPos에 각각 1씩 더해야함(이 좌표는 실제 마지막 좌표이기에 배열로 만들려면 1개씩늘려야함
		char[][] board = new char[maxPos[0]+1][maxPos[1]+1];
		
		for(int i = 0; i<maxPos[0]+1; i++) {
			for(int j = 0; j<maxPos[1]+1; j++) {
				board[i][j] = '#';
			}
		}
		
		Integer[] buf;
		for(int k = 0; k<posList.size(); k++) {
			buf = posList.get(k);
			board[buf[0]][buf[1]] = '.';
		}
		
		return board;
	}
	
	// 미로를 보여줌
	public static void mazeView(char[][] mazeBoard) {
		for(int i = 0; i<mazeBoard.length; i++) {
			for(int j = 0; j<mazeBoard[0].length; j++) {
				System.out.printf("%s",mazeBoard[i][j]);			
			}
			System.out.println();
		}
	}

}