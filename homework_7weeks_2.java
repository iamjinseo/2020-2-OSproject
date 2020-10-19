package homework7;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class capitalGame {
	private HashMap<String, String> countries = new HashMap<String, String>();
	private Scanner scanner = new Scanner(System.in);
	
	public CapitalGame() {
		/* 입력된 9개의 나라들 */
		countries.add(new Nation("그리스", "아테네"));
		countries.add(new Nation("독일", "베를린"));
		countries.add(new Nation("멕시코", "멕시코시티"));
		countries.add(new Nation("영국", "런던"));
		countries.add(new Nation("미국", "워싱턴D.C."));
		countries.add(new Nation("캐나다", "오타와"));
		countries.add(new Nation("일본", "도쿄"));
		countries.add(new Nation("중국", "베이징"));
		countries.add(new Nation("베트남", "하노이"));
	}

	public void execute() {
		/* 메인메뉴 실행 */
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		while(true) {
			System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
			int menu = sc.nextInt();
			switch(menu) {
				case 1: input(); break;
				case 2: quiz(); break;
				case 3: finish(); return;
				default: 
					System.out.println("잘못된 메뉴입니다");
			}
		}
	}

	private void input() {
		int n = store.size();
		System.out.println("현재 " + n + "개 나라와 수도가 입력되어 있습니다.");
		n++;
		while(true) {
			System.out.print("나라와 수도 입력" + n + ">> ");
			String country = scanner.next();
			if(country.equals("그만")) {
				break;
			}
			String capital = scanner.next();
			if(store.containsKey(country)) {
				System.out.println(country + "는 이미 있습니다");
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
			int index = (int)(Math.random()*array.length); //임의로 한 나라를 선택하기 위함
			String question = (String)array[index];
			String answer = store.get(question);
			
			System.out.print(question + "의 수도는? ");
			String capitalFromUser = scanner.next(); //수도명 입력
			
			if(capitalFromUser.equals("그만")) 
				break;
			if(capitalFromUser.equals(answer))
				System.out.println("정답!!");
			else
				System.out.println("아닙니다!!");				
		}	
		
	}

	private void finish() {
		System.out.println("게임을 종료합니다.");	
	}
}
	
public class homework_7weeks_2 {
	capitalGame game = new capitalGame();
	game.execute();
}
