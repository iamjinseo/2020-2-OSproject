package homework7;
import java.util.Scanner;
import java.util.Vector;

class Nation {
	private String country;  //���� �̸�
	private String capital;  //���� �̸�
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}//������
	public String getCountry() {
		return country;
	} //�����̸� ��ȯ
	public String getCapital() {
		return capital;
	}//�����̸� ��ȯ
}

class capitalGame{
	private Vector<Nation>countries = new Vector<Nation>();
	private Scanner sc = new Scanner(System.in);
	
	public capitalGame() {
		/* �Էµ� 9���� ����� */
		countries.add(new Nation("�׸���", "���׳�"));
		countries.add(new Nation("����", "������"));
		countries.add(new Nation("�߽���", "�߽��ڽ�Ƽ"));
		countries.add(new Nation("����", "����"));
		countries.add(new Nation("�̱�", "������D.C."));
		countries.add(new Nation("ĳ����", "��Ÿ��"));
		countries.add(new Nation("�Ϻ�", "����"));
		countries.add(new Nation("�߱�", "����¡"));
		countries.add(new Nation("��Ʈ��", "�ϳ���"));
	}
	
	public void execute() {
		/* ���θ޴� ���� */
		System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
		while(true) {
			System.out.print("�Է�:1, ����:2, ����:3>> ");
			int menu = sc.nextInt();
			switch(menu) {
				case 1: input(); break;
				case 2: quiz(); break;
				case 3: finish(); return;
				default: 
					System.out.println("�߸��� �޴��Դϴ�");
			}
		}
	}
	
	private void input() {
		int n = countries.size();
		System.out.println("���� " + n + "�� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
		n++;
		while(true) {
			System.out.print("����� ���� �Է�" + n + ">> ");
			String country = sc.next(); //���� �̸� �Է�
			if(country.equals("�׸�")) {
				break;
			}
			String capital = sc.next(); //���� �̸� �Է�
			if(isExist(country)) { //�ߺ��Է��� ��
				System.out.println(country + "�� �̹� �ֽ��ϴ�!");
				continue;
			}
			countries.add(new Nation(country, capital));
			n++;
		}
	}
	
	private void quiz() {
		while(true) {
			int index = (int)(Math.random()*countries.size()); //���Ƿ� �� ���� �����ϱ� ����
			Nation nation = countries.get(index);
			String question = nation.getCountry();
			String answer = nation.getCapital();
			
			System.out.print(question + "�� ������? ");  //���� ����
			String userAnswer = sc.next(); //���� �̸� �Է�
			
			if(userAnswer.equals("�׸�")) 
				break;
			else if(userAnswer.equals(answer))
				System.out.println("����!!");
			else
				System.out.println("�ƴմϴ�!!");				
		}	
		
	}
	private void finish() {
		System.out.println("������ �����մϴ�.");	
	}
	
	private boolean isExist(String country) {
		/* �Է��� ���� �����ϴ��� �˻��� */
		for(int i=0;i<countries.size();i++) {
			if(countries.get(i).getCountry().equals(country))
				return true;
		}
		return false;
	}
	
}

public class homework_7weeks {
	public static void main(String[] args) {
		capitalGame game = new capitalGame();
		game.execute();
	}

}
