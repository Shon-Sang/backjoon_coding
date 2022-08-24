package homework.question16;

public class JavaStringBuffer {

	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("java test");			
		display(sb.toString().toCharArray());
	}//end main()
	
	public static void display(char[ ] data){
		for(char cn: data)
			System.out.println(cn);
	}//end display()
}
