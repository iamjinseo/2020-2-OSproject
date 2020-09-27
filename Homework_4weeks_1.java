package homework3;
import java.util.Scanner;

public class Homework_4weeks_1 {
	public static void main(String[] args) {
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		Scanner sc = new Scanner(System.in);
		int menu;
		Reservation RV = new Reservation();		
		
		while(true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			menu=sc.nextInt();
			switch(menu) {
			case 1 :
				System.out.print("좌석구분 S(1), A(2), B(3)>>");
				menu=sc.nextInt();
				if(menu<1||menu>3) {
					System.out.println("좌석을 다시 선택해 주세요.");
					break;
				}
				RV.showSeats(menu);  //좌석상태출력
				RV.reserve(menu);   //예약
				break;
			case 2:
				RV.showAllSeats();  //모든 좌석 조회
				break;
			case 3:
				System.out.print("좌석구분 S(1), A(2), B(3)>>");
				menu=sc.nextInt();
				if(menu<1||menu>3) {
					System.out.println("좌석을 다시 선택해 주세요.");
					break;
				}
				RV.showSeats(menu);  //좌석상태출력
				RV.cancleReservation(menu);  //예약 취소
				break;
			case 4:
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

}

class Reservation{
	Scanner sc = new Scanner(System.in);
	String seats[][] = new String[3][10];  //좌석 배열
	
	Reservation(){
		for(int i=0;i<3;i++)
			for(int j=0;j<10;j++)
				seats[i][j]="--- ";  //좌석 상태 초기화
	}
	
	public void showSeats(int n) {
		/* 좌석 예약 상태 출력 */
		if(n==1)
			System.out.print("S>> ");
		else if(n==2)
			System.out.print("A>> ");
		else if(n==3)
			System.out.print("B>> ");
		else {
			System.out.println("없는 좌석입니다.");
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
			else if(i==2) System.out.print("B>>" );  //S, A, B좌석 차례대로 출력
			
			for(int j=0;j<10;j++) 
				System.out.print(seats[i][j]);
			  //각 좌석마다 예약 상태 확인
			System.out.println();
		}
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
	public void reserve(int n) {
		System.out.print("이름>> ");
		String name = sc.next();
		
		System.out.print("번호>> ");
		int seatNum = sc.nextInt();
		if (seatNum > 10 || seatNum < 1) {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
		/* 이름과 좌석번호로 예약 */
		
		if(!seats[n-1][seatNum].equals("--- ")) {
			System.out.println("예약된 좌석입니다.");
			return;
		}
		seats[n-1][seatNum-1]=name;   //입력받은 이름으로 예약
	}
	
	public void cancleReservation(int n) {
		int for_nameCount=0;  //동명이인 수 
		
		System.out.print("이름>> ");
		String name = sc.next();  //이름 입력
		
		for(int i=0;i<10;i++) {
			if(seats[n-1][i].equals(name))
				for_nameCount++;
		}  //동명이인 검사
		
		if(for_nameCount>1) {
			System.out.println("동명이인이 있는 것 같습니다.");
			System.out.println("취소하고싶은 "+name+"님의 좌석 번호를 입력해 주세요.");
			int seatNum = sc.nextInt();
			seats[n-1][seatNum-1]="--- ";
		}
		else if(for_nameCount == 1) {
			for(int i=0;i<10;i++) 
				if(seats[n-1][i].equals(name))
					seats[n-1][i]="--- ";
		}
		else if(for_nameCount == 0) 
			System.out.println("해당 이름을 가진 사람이 없습니다.");
	}
}
