package homework2;
import java.util.Scanner;

public class Homework_3weeks_2 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		String str[]= {"����", "����", "��"};
		
		do {
			int n = (int)(Math.random()*3);
			System.out.print("���� ���� ��!>>");
			String user = scanner.next();
			
			if(user.equals("�׸�")) {
				System.out.println("������ �����մϴ�. . .");
				break;
			}
			else if(user.equals(str[n])) {
				System.out.println("����� = "+user+", ��ǻ�� = "+str[n]+" �����ϴ�.");
			}
			else if(user.equals("����")) {
				if(n==1)
					System.out.println("����� = "+user+", ��ǻ�� = "+str[n]+" ��ǻ�Ͱ� �̰���ϴ�.");
				else
					System.out.println("����� = "+user+", ��ǻ�� = "+str[n]+" ����ڰ� �̰���ϴ�.");
			}
			else if(user.equals("����")) {
				if(n==0)
					System.out.println("����� = "+user+", ��ǻ�� = "+str[n]+" ����ڰ� �̰���ϴ�.");
				else
					System.out.println("����� = "+user+", ��ǻ�� = "+str[n]+" ��ǻ�Ͱ� �̰���ϴ�.");
			}
			else if(user.equals("��")){
				if(n==0)
					System.out.println("����� = "+user+", ��ǻ�� = "+str[n]+" ��ǻ�Ͱ� �̰���ϴ�.");
				else
					System.out.println("����� = "+user+", ��ǻ�� = "+str[n]+" ����ڰ� �̰���ϴ�.");
			}
			else
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;
		}while(true);
	scanner.close();
	}
}
