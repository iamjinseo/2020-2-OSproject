package homework7;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class capitalGame {
	private HashMap<String, String> countries = new HashMap<String, String>();
	private Scanner scanner = new Scanner(System.in);
	
	public CapitalGame() {
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
		int n = store.size();
		System.out.println("���� " + n + "�� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
		n++;
		while(true) {
			System.out.print("����� ���� �Է�" + n + ">> ");
			String country = scanner.next();
			if(country.equals("�׸�")) {
				break;
			}
			String capital = scanner.next();
			if(store.containsKey(country)) {
				System.out.println(country + "�� �̹� �ֽ��ϴ�");
				continue;
			}
			store.put(country, capital);
			n++;
		}
	}
	private void quiz() {
		Set<String> keys = store.keySet();
		Object [] array = (keys.toArray());
		
		while(true) {
			int index = (int)(Math.random()*array.length); //���Ƿ� �� ���� �����ϱ� ����
			String question = (String)array[index];
			String answer = store.get(question);
			
			System.out.print(question + "�� ������? ");
			String capitalFromUser = scanner.next(); //������ �Է�
			
			if(capitalFromUser.equals("�׸�")) 
				break;
			if(capitalFromUser.equals(answer))
				System.out.println("����!!");
			else
				System.out.println("�ƴմϴ�!!");				
		}	
		
	}

	private void finish() {
		System.out.println("������ �����մϴ�.");	
	}
}
	
public class homework_7weeks_2 {
	capitalGame game = new capitalGame();
	game.execute();
}
