package homework7;
import java.util.Scanner;
import java.util.Vector;

class Nation {
	private String country;  //나라 이름
	private String capital;  //수도 이름
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}//생성자
	public String getCountry() {
		return country;
	} //나라이름 반환
	public String getCapital() {
		return capital;
	}//수도이름 반환
}

class capitalGame{
	private Vector<Nation>countries = new Vector<Nation>();
	private Scanner sc = new Scanner(System.in);
	
	public capitalGame() {
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
		int n = countries.size();
		System.out.println("현재 " + n + "개 나라와 수도가 입력되어 있습니다.");
		n++;
		while(true) {
			System.out.print("나라와 수도 입력" + n + ">> ");
			String country = sc.next(); //나라 이름 입력
			if(country.equals("그만")) {
				break;
			}
			String capital = sc.next(); //수도 이름 입력
			if(isExist(country)) { //중복입력일 때
				System.out.println(country + "는 이미 있습니다!");
				continue;
			}
			countries.add(new Nation(country, capital));
			n++;
		}
	}
	
	private void quiz() {
		while(true) {
			int index = (int)(Math.random()*countries.size()); //임의로 한 나라를 선택하기 위함
			Nation nation = countries.get(index);
			String question = nation.getCountry();
			String answer = nation.getCapital();
			
			System.out.print(question + "의 수도는? ");  //수도 질문
			String userAnswer = sc.next(); //수도 이름 입력
			
			if(userAnswer.equals("그만")) 
				break;
			else if(userAnswer.equals(answer))
				System.out.println("정답!!");
			else
				System.out.println("아닙니다!!");				
		}	
		
	}
	private void finish() {
		System.out.println("게임을 종료합니다.");	
	}
	
	private boolean isExist(String country) {
		/* 입력한 나라가 존재하는지 검사함 */
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
