package homework;

import java.util.Scanner;

public class Homework2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("연산>>");
		Scanner scanner = new Scanner(System.in);
		
		double result=0;
		double x=scanner.nextDouble();
		String OP=scanner.next();
		double y=scanner.nextDouble();
		
		switch(OP) {
			case "+":
				result=x+y;
				System.out.println(x+OP+y+"의 계산 결과는 "+result);
				break;
			case "-":
				result=x-y;
				System.out.println(x+OP+y+"의 계산 결과는 "+result);
				break;
			case "*":
				result=x*y;
				System.out.println(x+OP+y+"의 계산 결과는 "+result);
				break;
			case "/":
				if(y==0) {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				else {
					result=x/y;
					System.out.println(x+OP+y+"의 계산 결과는 "+result);
				}
				break;
			default:
				System.out.println("잘못된 연산자입니다.");
		}
		scanner.close();
	}

}
