package homework;
import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("ù��° ���� �߽ɰ� ������ �Է�>>");
		Scanner scanner = new Scanner(System.in);
		double x1=scanner.nextDouble();
		double y1=scanner.nextDouble();
		double r1=scanner.nextDouble();
		
		System.out.print("�ι�° ���� �߽ɰ� ������ �Է�>>");
		double x2=scanner.nextDouble();
		double y2=scanner.nextDouble();
		double r2=scanner.nextDouble();
		
		double distance=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		if(distance<=r1+r2)
			System.out.println("�� ���� ���� ��ģ��.");
		else
			System.out.println("�� ���� ���� ��ġ�� �ʴ´�.");
		
		scanner.close();
	}

}
