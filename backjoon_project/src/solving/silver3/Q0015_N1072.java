package solving.silver3;

public class Q0015_N1072 {

	public static void main(String[] args) {
		System.out.println(numcount(100 , 99)); // 전자가 분모, 후자가 분자
	}

	public static int percentage(int deno, int nume) {
		
		if(nume >= deno) {
			return -1;
		}
		
		return (int)((nume/(double)deno)*100);
	}
	
	public static int numcount(int deno, int nume) {
		int cnt = 0;
		int a = deno;
		int b = nume;
		int per1 = percentage(a, b);
		int per2 = per1;
		if(per1 == -1 || per1 == 99) { // 이미 1번이라도 진이상 승률은 100%가 절대 될수없음
			return -1;
		}
		
		while(per1 >= per2) {
			a += 1;
			b += 1;
			cnt += 1;
			per2 = percentage(a, b);
		}
		return cnt;
	}
}
