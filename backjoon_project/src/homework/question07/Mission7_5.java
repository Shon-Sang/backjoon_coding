package homework.question07;

public class Mission7_5 {

	public static void main(String[] args) {
		for(int x = 0; x<=10; x++) {
			for(int y = 0; y<=10; y++) {
				if(2*x + 3*y == 10) {
					System.out.printf("x=%d, y=%d\n", x , y);
				}
			}
		}
	}

}
