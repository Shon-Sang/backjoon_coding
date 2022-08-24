package homework.question07;

public class Mission7_2 {

	public static void main(String[] args) {
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		double total = 0, avg = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
			total += array[i][j];
			}
		}
		avg = total / (array.length * array[0].length);
		System.out.println ("합계 : " + total);
		System.out.println ("평균 : " + avg);

	}

}
