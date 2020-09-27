package homework3;
import java.util.Scanner;

public class Homework_4weeks_1 {
	public static void main(String[] args) {
		System.out.println("��ǰ�ܼ�ƮȦ ���� �ý����Դϴ�.");
		Scanner sc = new Scanner(System.in);
		int menu;
		Reservation RV = new Reservation();		
		
		while(true) {
			System.out.print("����:1, ��ȸ:2, ���:3, ������:4>>");
			menu=sc.nextInt();
			switch(menu) {
			case 1 :
				System.out.print("�¼����� S(1), A(2), B(3)>>");
				menu=sc.nextInt();
				if(menu<1||menu>3) {
					System.out.println("�¼��� �ٽ� ������ �ּ���.");
					break;
				}
				RV.showSeats(menu);  //�¼��������
				RV.reserve(menu);   //����
				break;
			case 2:
				RV.showAllSeats();  //��� �¼� ��ȸ
				break;
			case 3:
				System.out.print("�¼����� S(1), A(2), B(3)>>");
				menu=sc.nextInt();
				if(menu<1||menu>3) {
					System.out.println("�¼��� �ٽ� ������ �ּ���.");
					break;
				}
				RV.showSeats(menu);  //�¼��������
				RV.cancleReservation(menu);  //���� ���
				break;
			case 4:
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				break;
			}
		}
	}

}

class Reservation{
	Scanner sc = new Scanner(System.in);
	String seats[][] = new String[3][10];  //�¼� �迭
	
	Reservation(){
		for(int i=0;i<3;i++)
			for(int j=0;j<10;j++)
				seats[i][j]="--- ";  //�¼� ���� �ʱ�ȭ
	}
	
	public void showSeats(int n) {
		/* �¼� ���� ���� ��� */
		if(n==1)
			System.out.print("S>> ");
		else if(n==2)
			System.out.print("A>> ");
		else if(n==3)
			System.out.print("B>> ");
		else {
			System.out.println("���� �¼��Դϴ�.");
			return;
		}
		
		for(int i=0;i<10;i++) 
			System.out.print(seats[n-1][i]+" ");
		System.out.println(); 
	}
	
	public void showAllSeats() {
		for(int i=0;i<3;i++) {
			if(i==0) System.out.print("S>> ");
			else if(i==1) System.out.print("A>> ");
			else if(i==2) System.out.print("B>>" );  //S, A, B�¼� ���ʴ�� ���
			
			for(int j=0;j<10;j++) 
				System.out.print(seats[i][j]);
			  //�� �¼����� ���� ���� Ȯ��
			System.out.println();
		}
		System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
	}
	
	public void reserve(int n) {
		System.out.print("�̸�>> ");
		String name = sc.next();
		
		System.out.print("��ȣ>> ");
		int seatNum = sc.nextInt();
		if (seatNum > 10 || seatNum < 1) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			return;
		}
		/* �̸��� �¼���ȣ�� ���� */
		
		if(!seats[n-1][seatNum].equals("--- ")) {
			System.out.println("����� �¼��Դϴ�.");
			return;
		}
		seats[n-1][seatNum-1]=name;   //�Է¹��� �̸����� ����
	}
	
	public void cancleReservation(int n) {
		int for_nameCount=0;  //�������� �� 
		
		System.out.print("�̸�>> ");
		String name = sc.next();  //�̸� �Է�
		
		for(int i=0;i<10;i++) {
			if(seats[n-1][i].equals(name))
				for_nameCount++;
		}  //�������� �˻�
		
		if(for_nameCount>1) {
			System.out.println("���������� �ִ� �� �����ϴ�.");
			System.out.println("����ϰ���� "+name+"���� �¼� ��ȣ�� �Է��� �ּ���.");
			int seatNum = sc.nextInt();
			seats[n-1][seatNum-1]="--- ";
		}
		else if(for_nameCount == 1) {
			for(int i=0;i<10;i++) 
				if(seats[n-1][i].equals(name))
					seats[n-1][i]="--- ";
		}
		else if(for_nameCount == 0) 
			System.out.println("�ش� �̸��� ���� ����� �����ϴ�.");
	}
}
