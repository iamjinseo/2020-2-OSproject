package homework;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("����>>");
		Scanner scanner = new Scanner(System.in);
		
		double result=0;
		double x=scanner.nextDouble();
		String OP=scanner.next();
		double y=scanner.nextDouble();
		
		if(OP.equals("+")) {
			result=x+y;
			System.out.println(x+OP+y+"�� ��� ����� "+result);
		}
		else if(OP.equals("-")) {
			result=x-y;
			System.out.println(x+OP+y+"�� ��� ����� "+result);
		}
		else if(OP.equals("*")) {
			result=x*y;
			System.out.println(x+OP+y+"�� ��� ����� "+result);
		}
		else if(OP.equals("/")) {
			if(y==0) {
				System.out.println("0���� ���� �� �����ϴ�.");
			}
			else {
				result=x/y;
				System.out.println(x+OP+y+"�� ��� ����� "+result);
			}
		}
		else
			System.out.println("�߸��� �������Դϴ�.");
		
		scanner.close();
	}

}
